package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    private static UserConvert instance;

    private UserConvert() {

    }

    public static UserConvert getInstance() {
        if (instance == null)
            instance = new UserConvert();
        return instance;
    }

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

    public List<User> convertListDtotoListEntity(final List<UserDTO> dtoList) {
        final List<User> entityList = new ArrayList<>();
        for (UserDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }

        return entityList;
    }

    public List<UserDTO> convertListEntitytoListDto(final List<User> entityList) {
        final List<UserDTO> dtoList = new ArrayList<>();
        for (User entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }

        return dtoList;
    }
}
