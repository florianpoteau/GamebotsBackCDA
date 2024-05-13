package co.simplon.gamebotsback.business.service.user;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.Iuserrepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the <code>IUserService</code> interface providing
 * functionalities for managing users.
 */
@Service
public class UserServiceImpl implements Iuserservice {

  /**
   * Error message indicating that a user with the specified ID does not exist.
   */
  public static final String ERROR_MESSAGE = "User does not exist: ";

  /**
   * The className used to encodepassword.
   */
  private final PasswordEncoder passwordEncoder;

  /**
   * The repository used to access user data.
   */
  private final Iuserrepository userRepository;

  /**
   * Constructor for <code>UserServiceImpl</code>.
   *
   * @param repositoryUser
   *     The repository used to access user data.
   * @param encoderPassword
   *     The password encoder used for encoding passwords.
   */
  @Autowired
  public UserServiceImpl(
      final Iuserrepository repositoryUser,
      final PasswordEncoder encoderPassword) {
    this.userRepository = repositoryUser;
    this.passwordEncoder = encoderPassword;
  }


  /**
   * Creates a new user account.
   *
   * @param userDto
   *     The information of the new user to create.
   */
  @Override
  public void createUserAccount(final Userdto userDto) {
    String encodePassword = passwordEncoder.encode(userDto.getPassword());
    userDto.setPassword(encodePassword);
    userDto.setCreationDate(new Date());
    userRepository.save(UserConvert.getInstance().convertDtoToEntity(userDto));
  }

  /**
   * Retrieves information about a user based on its ID.
   *
   * @param username
   *     The username of the user.
   *
   * @return Information about the user corresponding to the given ID.
   *
   * @throws EntityNotFoundException
   *     if no user corresponding to the ID is found.
   */
  @Override
  public int getUserIdByUsername(final String username) {
    Optional<User> optionalUser = userRepository.findUserAccountByUsername(
        username);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      UserConvert.getInstance().convertEntityToDto(user);
      return user.getIdUser();
    } else {
      throw new EntityNotFoundException(ERROR_MESSAGE + username);
    }
  }

  /**
   * Modifies information of an existing user account.
   *
   * @param userId
   *     The ID of the user to modify.
   * @param userDto
   *     The new information to associate with the user.
   *
   * @throws EntityNotFoundException
   *     if no user corresponding to the ID is found.
   */
  @Override
  public void modifyUserAccount(final int userId, final Userdto userDto) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      existingUser.setUsername(userDto.getUsername());
      existingUser.setEmail(userDto.getEmail());
      existingUser.setPassword(userDto.getPassword());
      existingUser.setImage(userDto.getImage());
      existingUser.setPhone(userDto.getPhone());
      existingUser.setModificationDate(new Date());

      userRepository.save(existingUser);

    } else {
      throw new EntityNotFoundException(ERROR_MESSAGE + userId);
    }
  }

  /**
   * Deletes the user account corresponding to the given ID.
   *
   * @param userId
   *     The ID of the user to delete.
   *
   * @throws EntityNotFoundException
   *     if no user corresponding to the ID is found.
   */
  @Override
  public void deleteUserAccount(final int userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      userRepository.deleteById(userId);
    } else {
      throw new EntityNotFoundException(ERROR_MESSAGE + userId);
    }
  }

  /**
   * Retrieves information about a user based on its ID.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return Information about the user corresponding to the given ID.
   *
   * @throws EntityNotFoundException
   *     if no user corresponding to the ID is found.
   */
  @Override
  public Userdto getUserAccountByUserId(final int userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      return UserConvert.getInstance().convertEntityToDto(user);
    } else {
      throw new EntityNotFoundException(ERROR_MESSAGE + userId);
    }
  }

}
