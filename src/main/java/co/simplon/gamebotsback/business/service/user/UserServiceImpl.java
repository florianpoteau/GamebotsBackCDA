package co.simplon.gamebotsback.business.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createAccount(UserDTO userDTO) {
        userRepository.save(UserConvert.getInstance().convertDtoToEntity(userDTO));
    }

    @Override
    public UserDTO getById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return UserConvert.getInstance().convertEntityToDto(user);
    }

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
            throw new EntityNotFoundException("The user does not exist: " + id);
        }
    }

    @Override
    public void deleteAccount(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("L'utilisateur n'existe pas " + id);
        }
    }

}
