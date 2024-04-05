package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;

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
        return dto;
    }
}
