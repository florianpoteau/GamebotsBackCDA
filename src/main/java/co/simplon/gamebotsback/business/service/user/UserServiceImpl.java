/**
 * Implementation of the <code>IUserService</code> interface providing functionalities for managing users.
 */
package co.simplon.gamebotsback.business.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * Implementation of the <code>IUserService</code> interface providing functionalities for managing users.
 */
@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    /**
     * Constructor for <code>UserServiceImpl</code>.
     *
     * @param userRepository The repository used to access user data.
     */
    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user account.
     *
     * @param userDTO The information of the new user to create.
     */
    @Override
    public void createAccount(UserDTO userDTO) {
        userRepository.save(UserConvert.getInstance().convertDtoToEntity(userDTO));
    }

    /**
     * Retrieves information about a user based on its ID.
     *
     * @param id The ID of the user.
     * @return Information about the user corresponding to the given ID.
     * @throws EntityNotFoundException if no user corresponding to the ID is found.
     */
    @Override
    public UserDTO getById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserConvert.getInstance().convertEntityToDto(user);
        } else {
            throw new EntityNotFoundException("User does not exist: " + id);
        }
    }

    /**
     * Modifies information of an existing user account.
     *
     * @param id      The ID of the user to modify.
     * @param userDTO The new information to associate with the user.
     * @return The updated information of the user.
     * @throws EntityNotFoundException if no user corresponding to the ID is found.
     */
    @Override
    public UserDTO modifyAccount(int id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(userDTO.getPassword());
            existingUser.setImage(userDTO.getImage());
            existingUser.setPhone(userDTO.getPhone());
            existingUser.setCreationDate(userDTO.getCreationDate());
            existingUser.setModificationDate(userDTO.getModificationDate());

            User updatedUser = userRepository.save(existingUser);

            return UserConvert.getInstance().convertEntityToDto(updatedUser);
        } else {
            throw new EntityNotFoundException("User does not exist: " + id);
        }
    }

    /**
     * Deletes the user account corresponding to the given ID.
     *
     * @param id The ID of the user to delete.
     * @throws EntityNotFoundException if no user corresponding to the ID is found.
     */
    @Override
    public void deleteAccount(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User does not exist: " + id);
        }
    }

}
