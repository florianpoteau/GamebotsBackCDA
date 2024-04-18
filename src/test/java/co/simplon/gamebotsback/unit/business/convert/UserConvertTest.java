package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.persistance.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit test for the UserConvert class.
 */
class UserConvertTest {

    private static final UserConvert userConvert = UserConvert.getInstance();

    /**
     * Tests the conversion of a User entity to a UserDTO.
     */
    @Test
    void testConvertUserToUserDTO() {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("PaRzIval");
        user.setPhone("0656565656");
        user.setEmail("flo@email.com");
        user.setPassword("123456");
        Date creationDate = new Date();
        user.setCreationDate(creationDate);
        user.setModificationDate(null);
        user.setImage(null);

        UserDTO userDTO = userConvert.convertEntityToDto(user);

        assertSame(1, userDTO.getIdUser());
        assertSame("PaRzIval", userDTO.getUsername());
        assertSame("0656565656", userDTO.getPhone());
        assertSame("flo@email.com", userDTO.getEmail());
        assertSame("123456", userDTO.getPassword());
        assertSame(creationDate, userDTO.getCreationDate());
        assertNull(userDTO.getModificationDate());
        assertNull(userDTO.getImage());
    }

    /**
     * Tests the conversion of a UserDTO to a User.
     */
    @Test
    void testConvertUserDTOToUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(1);
        userDTO.setUsername("PaRzIval");
        userDTO.setPhone("0656565656");
        userDTO.setEmail("flo@email.com");
        userDTO.setPassword("123456");
        Date creationDate = new Date();
        userDTO.setCreationDate(creationDate);
        userDTO.setModificationDate(null);
        userDTO.setImage(null);

        User user = userConvert.convertDtoToEntity(userDTO);

        assertSame(1, user.getIdUser());
        assertSame("PaRzIval", user.getUsername());
        assertSame("0656565656", user.getPhone());
        assertSame("flo@email.com", user.getEmail());
        assertSame("123456", user.getPassword());
        assertSame(creationDate, user.getCreationDate());
        assertNull(user.getModificationDate());
        assertNull(user.getImage());
    }

    /**
     * Tests the conversion of a List User entity to a List UserDTO.
     */
    @Test
    void testConvertListUserToListUserDTO() {
        User user = new User();
        user.setIdUser(1);
        user.setUsername("PaRzIval");
        user.setPhone("0656565656");
        user.setEmail("flo@email.com");
        user.setPassword("123456");
        Date creationDate = new Date();
        user.setCreationDate(creationDate);
        user.setModificationDate(null);
        user.setImage(null);

        User user2 = new User();
        user2.setIdUser(2);
        user2.setUsername("Yoan");
        user2.setPhone("0667565656");
        user2.setEmail("yoan@email.com");
        user2.setPassword("123326");
        Date creationDate2 = new Date();
        user2.setCreationDate(creationDate2);
        user2.setModificationDate(null);
        user2.setImage(null);

        List<User> userList = List.of(user, user2);

        List<UserDTO> userDTOList = userConvert.convertListEntityToListDto(userList);

        assertSame(1, userDTOList.get(0).getIdUser());
        assertSame(2, userDTOList.get(1).getIdUser());
        assertSame("PaRzIval", userDTOList.get(0).getUsername());
        assertSame("Yoan", userDTOList.get(1).getUsername());
        assertSame("0656565656", userDTOList.get(0).getPhone());
        assertSame("0667565656", userDTOList.get(1).getPhone());
        assertSame("flo@email.com", userDTOList.get(0).getEmail());
        assertSame("yoan@email.com", userDTOList.get(1).getEmail());
        assertSame("123456", userDTOList.get(0).getPassword());
        assertSame("123326", userDTOList.get(1).getPassword());
        assertSame(creationDate, userDTOList.get(0).getCreationDate());
        assertSame(creationDate2, userDTOList.get(1).getCreationDate());
        assertNull(userDTOList.get(0).getModificationDate());
        assertNull(userDTOList.get(1).getModificationDate());
        assertNull(userDTOList.get(0).getImage());
        assertNull(userDTOList.get(1).getImage());
    }

    /**
     * Tests the conversion of a List UserDTO to a List User entity.
     */
    @Test
    void testConvertListUserDTOToListUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(1);
        userDTO.setUsername("PaRzIval");
        userDTO.setPhone("0656565656");
        userDTO.setEmail("flo@email.com");
        userDTO.setPassword("123456");
        Date creationDate = new Date();
        userDTO.setCreationDate(creationDate);
        userDTO.setModificationDate(null);
        userDTO.setImage(null);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setIdUser(2);
        userDTO2.setUsername("Yoan");
        userDTO2.setPhone("0667565656");
        userDTO2.setEmail("yoan@email.com");
        userDTO2.setPassword("123326");
        Date creationDate2 = new Date();
        userDTO2.setCreationDate(creationDate2);
        userDTO2.setModificationDate(null);
        userDTO2.setImage(null);

        List<UserDTO> userDTOList = List.of(userDTO, userDTO2);

        List<User> userList = userConvert.convertListDtoToListEntity(userDTOList);

        assertSame(1, userList.get(0).getIdUser());
        assertSame(2, userList.get(1).getIdUser());
        assertSame("PaRzIval", userList.get(0).getUsername());
        assertSame("Yoan", userList.get(1).getUsername());
        assertSame("0656565656", userList.get(0).getPhone());
        assertSame("0667565656", userList.get(1).getPhone());
        assertSame("flo@email.com", userList.get(0).getEmail());
        assertSame("yoan@email.com", userList.get(1).getEmail());
        assertSame("123456", userList.get(0).getPassword());
        assertSame("123326", userList.get(1).getPassword());
        assertSame(creationDate, userList.get(0).getCreationDate());
        assertSame(creationDate2, userList.get(1).getCreationDate());
        assertNull(userList.get(0).getModificationDate());
        assertNull(userList.get(1).getModificationDate());
        assertNull(userList.get(0).getImage());
        assertNull(userList.get(1).getImage());
    }
}
