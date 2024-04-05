/**
 * This class provides methods to convert between UserDTO objects and User entities.
 */
package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    private static UserConvert instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private UserConvert() {
    }

    /**
     * Returns the singleton instance of UserConvert.
     *
     * @return the singleton instance of UserConvert
     */
    public static UserConvert getInstance() {
        if (instance == null)
            instance = new UserConvert();
        return instance;
    }

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param entity the User entity to convert
     * @return the converted UserDTO
     */
    public UserDTO convertEntityToDto(final User entity) {
        final UserDTO dto = new UserDTO();
        dto.setIdUser(entity.getIdUser());
        dto.setUsername(entity.getUsername());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());
        dto.setImage(entity.getImage());

        return dto;
    }

    /**
     * Converts a UserDTO to a User entity.
     *
     * @param dto the UserDTO to convert
     * @return the converted User entity
     */
    public User convertDtoToEntity(final UserDTO dto) {
        final User user = new User();
        user.setIdUser(dto.getIdUser());
        user.setUsername(dto.getUsername());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCreationDate(dto.getCreationDate());
        user.setModificationDate(dto.getModificationDate());
        user.setImage(dto.getImage());

        return user;
    }

    /**
     * Converts a list of UserDTO objects to a list of User entities.
     *
     * @param dtoList the list of UserDTO objects to convert
     * @return the list of converted User entities
     */
    public List<User> convertListDtoToListEntity(final List<UserDTO> dtoList) {
        final List<User> entityList = new ArrayList<>();
        for (UserDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }

        return entityList;
    }

    /**
     * Converts a list of User entities to a list of UserDTO objects.
     *
     * @param entityList the list of User entities to convert
     * @return the list of converted UserDTO objects
     */
    public List<UserDTO> convertListEntityToListDto(final List<User> entityList) {
        final List<UserDTO> dtoList = new ArrayList<>();
        for (User entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }

        return dtoList;
    }
}