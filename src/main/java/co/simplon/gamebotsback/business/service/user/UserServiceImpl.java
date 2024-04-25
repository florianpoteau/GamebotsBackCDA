package co.simplon.gamebotsback.business.service.user;


import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.Iuserrepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of the <code>IUserService</code> interface
 * providing functionalities for managing users.
 */
@Service
public class UserServiceImpl implements Iuserservice {

  /**
   * Error message indicating that a user with the specified ID does not exist.
   */
  public static final String ERRORMESSAGE = "User does not exist: ";

  /**
   * The repository used to access user data.
   */
  private final Iuserrepository userRepository;

  /**
   * Constructor for <code>UserServiceImpl</code>.
   *
   * @param repositoryUser The repository used to access user data.
   */
  @Autowired
  public UserServiceImpl(final Iuserrepository repositoryUser) {
    this.userRepository = repositoryUser;
  }

  /**
   * Creates a new user account.
   *
   * @param userDto The information of the new user to create.
   */
  @Override
  public void createAccount(final Userdto userDto) {
    userRepository.save(UserConvert.getInstance().convertDtoToEntity(userDto));
  }

  /**
   * Retrieves information about a user based on its ID.
   *
   * @param id The ID of the user.
   * @return Information about the user corresponding to the given ID.
   * @throws EntityNotFoundException if no
   *                                 user corresponding to the ID is found.
   */
  @Override
  public Userdto getById(final int id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      return UserConvert.getInstance().convertEntityToDto(user);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

  /**
   * Modifies information of an existing user account.
   *
   * @param id      The ID of the user to modify.
   * @param userDto The new information to associate with the user.
   * @return The updated information of the user.
   * @throws EntityNotFoundException if no
   *                                 user corresponding to the ID is found.
   */
  @Override
  public Userdto modifyAccount(final int id, final Userdto userDto) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      existingUser.setUsername(userDto.getUsername());
      existingUser.setEmail(userDto.getEmail());
      existingUser.setPassword(userDto.getPassword());
      existingUser.setImage(userDto.getImage());
      existingUser.setPhone(userDto.getPhone());
      existingUser.setCreationDate(userDto.getCreationDate());
      existingUser.setModificationDate(userDto.getModificationDate());

      User updatedUser = userRepository.save(existingUser);

      return UserConvert.getInstance().convertEntityToDto(updatedUser);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

  /**
   * Deletes the user account corresponding to the given ID.
   *
   * @param id The ID of the user to delete.
   * @throws EntityNotFoundException if no
   *                                 user corresponding to the ID is found.
   */
  @Override
  public void deleteAccount(final int id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      userRepository.deleteById(id);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

}
