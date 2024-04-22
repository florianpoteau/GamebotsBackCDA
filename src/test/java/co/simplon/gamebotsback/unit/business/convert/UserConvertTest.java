package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class UserConvertTest {

    private static final UserConvert userConvert = UserConvert.getInstance();

    private static final String username = "PaRzIval";
    private static final String phone = "0656565656";
    private static final String email = "flo@email.com";
    private static final String password = "123456";

    private User createSampleUser() {

        User user = new User();

        user.setIdUser(1);
        user.setUsername(username);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreationDate(new Date());
        user.setModificationDate(new Date());
        user.setImage(new Image());

        return user;
    }

    private User createSampleUserWithNull() {

        User user = new User();
        user.setIdUser(1);
        user.setUsername(null);
        user.setPhone(null);
        user.setEmail(null);
        user.setPassword(null);
        user.setCreationDate(null);
        user.setModificationDate(null);
        user.setImage(null);

        return user;
    }

    private UserDTO createSampleUserDTO() {

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(1);
        userDTO.setUsername(username);
        userDTO.setPhone(phone);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setCreationDate(new Date());
        userDTO.setModificationDate(new Date());
        userDTO.setImage(new Image());

        return userDTO;
    }

    private UserDTO createSampleUserDTOWithNull() {

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(1);
        userDTO.setUsername(null);
        userDTO.setPhone(null);
        userDTO.setEmail(null);
        userDTO.setPassword(null);
        userDTO.setCreationDate(null);
        userDTO.setModificationDate(null);
        userDTO.setImage(null);

        return userDTO;
    }

    @Test
    void testGetInstanceReturnsInstanceOfUserConvert() {

        UserConvert userConvert = UserConvert.getInstance();

        assertNotNull(userConvert);
        assertInstanceOf(UserConvert.class, userConvert);
    }

    @Test
    void testConvertUserToUserDTO() {

        User user = createSampleUser();
        UserDTO userDTO = userConvert.convertEntityToDto(user);

        assertSame(1, userDTO.getIdUser());
        assertSame(username, userDTO.getUsername());
        assertSame(phone, userDTO.getPhone());
        assertSame(email, userDTO.getEmail());
        assertSame(password, userDTO.getPassword());
        assertSame(user.getCreationDate(), userDTO.getCreationDate());
        assertSame(user.getModificationDate(), userDTO.getModificationDate());
        assertSame(user.getImage(), userDTO.getImage());
    }

    @Test
    void testConvertUserToUserDTOWithNull() {

        User user = createSampleUserWithNull();
        UserDTO userDTO = userConvert.convertEntityToDto(user);

        assertSame(1, userDTO.getIdUser());
        assertNull(userDTO.getUsername());
        assertNull(userDTO.getPhone());
        assertNull(userDTO.getEmail());
        assertNull(userDTO.getPassword());
        assertNull(userDTO.getCreationDate());
        assertNull(userDTO.getModificationDate());
        assertNull(userDTO.getImage());
    }

    @Test
    void testConvertUserDTOToUser() {

        UserDTO userDTO = createSampleUserDTO();
        User user = userConvert.convertDtoToEntity(userDTO);

        assertSame(1, user.getIdUser());
        assertSame(username, user.getUsername());
        assertSame(phone, user.getPhone());
        assertSame(email, user.getEmail());
        assertSame(password, user.getPassword());
        assertSame(userDTO.getCreationDate(), user.getCreationDate());
        assertSame(userDTO.getModificationDate(), user.getModificationDate());
        assertSame(userDTO.getImage(), user.getImage());
    }

    @Test
    void testConvertUserDTOToUserWithNull() {

        UserDTO userDTO = createSampleUserDTOWithNull();
        User user = userConvert.convertDtoToEntity(userDTO);

        assertSame(1, user.getIdUser());
        assertNull(user.getUsername());
        assertNull(user.getPhone());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getCreationDate());
        assertNull(user.getModificationDate());
        assertNull(user.getImage());
    }

    @Test
    void testConvertListUserToListUserDTO() {

        List<User> userList = List.of(createSampleUser(), createSampleUser());
        List<UserDTO> userDTOList = userConvert.convertListEntityToListDto(userList);

        assertSame(1, userDTOList.get(0).getIdUser());
        assertSame(1, userDTOList.get(1).getIdUser());
        assertSame(username, userDTOList.get(0).getUsername());
        assertSame(username, userDTOList.get(1).getUsername());
        assertSame(phone, userDTOList.get(0).getPhone());
        assertSame(phone, userDTOList.get(1).getPhone());
        assertSame(email, userDTOList.get(0).getEmail());
        assertSame(email, userDTOList.get(1).getEmail());
        assertSame(password, userDTOList.get(0).getPassword());
        assertSame(password, userDTOList.get(1).getPassword());
        assertSame(userList.get(0).getCreationDate(), userDTOList.get(0).getCreationDate());
        assertSame(userList.get(1).getCreationDate(), userDTOList.get(1).getCreationDate());
        assertSame(userList.get(0).getModificationDate(), userDTOList.get(0).getModificationDate());
        assertSame(userList.get(1).getModificationDate(), userDTOList.get(1).getModificationDate());
        assertSame(userList.get(0).getImage(), userDTOList.get(0).getImage());
        assertSame(userList.get(1).getImage(), userDTOList.get(1).getImage());
    }

    @Test
    void testConvertListUserToListUserDTOWithNull() {

        List<User> userList = List.of(createSampleUserWithNull(), createSampleUserWithNull());
        List<UserDTO> userDTOList = userConvert.convertListEntityToListDto(userList);

        assertSame(1, userDTOList.get(0).getIdUser());
        assertSame(1, userDTOList.get(1).getIdUser());
        assertNull(userDTOList.get(0).getUsername());
        assertNull(userDTOList.get(1).getUsername());
        assertNull(userDTOList.get(0).getPhone());
        assertNull(userDTOList.get(1).getPhone());
        assertNull(userDTOList.get(0).getEmail());
        assertNull(userDTOList.get(1).getEmail());
        assertNull(userDTOList.get(0).getPassword());
        assertNull(userDTOList.get(1).getPassword());
        assertNull(userDTOList.get(0).getCreationDate());
        assertNull(userDTOList.get(1).getCreationDate());
        assertNull(userDTOList.get(0).getModificationDate());
        assertNull(userDTOList.get(1).getModificationDate());
        assertNull(userDTOList.get(0).getImage());
        assertNull(userDTOList.get(1).getImage());
    }

    @Test
    void testConvertListUserDTOToListUser() {

        List<UserDTO> userDTOList = List.of(createSampleUserDTO(), createSampleUserDTO());
        List<User> userList = userConvert.convertListDtoToListEntity(userDTOList);

        assertSame(1, userList.get(0).getIdUser());
        assertSame(1, userList.get(1).getIdUser());
        assertSame(username, userList.get(0).getUsername());
        assertSame(username, userList.get(1).getUsername());
        assertSame(phone, userList.get(0).getPhone());
        assertSame(phone, userList.get(1).getPhone());
        assertSame(email, userList.get(0).getEmail());
        assertSame(email, userList.get(1).getEmail());
        assertSame(password, userList.get(0).getPassword());
        assertSame(password, userList.get(1).getPassword());
        assertSame(userDTOList.get(0).getCreationDate(), userList.get(0).getCreationDate());
        assertSame(userDTOList.get(1).getCreationDate(), userList.get(1).getCreationDate());
        assertSame(userDTOList.get(0).getModificationDate(), userList.get(0).getModificationDate());
        assertSame(userDTOList.get(1).getModificationDate(), userList.get(1).getModificationDate());
        assertSame(userDTOList.get(0).getImage(), userList.get(0).getImage());
        assertSame(userDTOList.get(1).getImage(), userList.get(1).getImage());
    }

    @Test
    void testConvertListUserDTOToListUserWithNull() {

        List<UserDTO> userDTOList = List.of(createSampleUserDTOWithNull(), createSampleUserDTOWithNull());
        List<User> userList = userConvert.convertListDtoToListEntity(userDTOList);

        assertSame(1, userList.get(0).getIdUser());
        assertSame(1, userList.get(1).getIdUser());
        assertNull(userList.get(0).getUsername());
        assertNull(userList.get(1).getUsername());
        assertNull(userList.get(0).getPhone());
        assertNull(userList.get(1).getPhone());
        assertNull(userList.get(0).getEmail());
        assertNull(userList.get(1).getEmail());
        assertNull(userList.get(0).getPassword());
        assertNull(userList.get(1).getPassword());
        assertNull(userList.get(0).getCreationDate());
        assertNull(userList.get(1).getCreationDate());
        assertNull(userList.get(0).getModificationDate());
        assertNull(userList.get(1).getModificationDate());
        assertNull(userList.get(0).getImage());
        assertNull(userList.get(1).getImage());
    }
}
