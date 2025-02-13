package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.UserConvert;
import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.entity.User;
import org.junit.jupiter.api.DisplayName;
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

  private Userdto createSampleUserDTO() {

    Userdto userDTO = new Userdto();

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

  private Userdto createSampleUserDTOWithNull() {

    Userdto userDTO = new Userdto();

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
  @DisplayName("Test de récupération de l'instance de UserConvert")
  void testGetInstanceReturnsInstanceOfUserConvert() {

    UserConvert userConvert = UserConvert.getInstance();

    assertNotNull(userConvert);
    assertInstanceOf(UserConvert.class, userConvert);
  }

  @Test
  @DisplayName("Test de conversion de User à UserDto")
  void testConvertUserToUserDTO() {

    User user = createSampleUser();
    Userdto userDTO = userConvert.convertEntityToDto(user);

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
  @DisplayName("Test de conversion de User à UserDto quand User est null")
  void testConvertUserToUserDTOWithNull() {

    User user = createSampleUserWithNull();
    Userdto userDTO = userConvert.convertEntityToDto(user);

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
  @DisplayName("Test de conversion de UserDto à User")
  void testConvertUserDTOToUser() {

    Userdto userDTO = createSampleUserDTO();
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
  @DisplayName("Test de conversion de UserDto à User quand UserDto est null")
  void testConvertUserDTOToUserWithNull() {

    Userdto userDTO = createSampleUserDTOWithNull();
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
  @DisplayName("Test de conversation d'une liste de User à une liste de UserDto")
  void testConvertListUserToListUserDTO() {

    List<User> userList = List.of(createSampleUser(), createSampleUser());
    List<Userdto> userdtoList = userConvert.convertListEntityToListDto(userList);

    assertSame(1, userdtoList.get(0).getIdUser());
    assertSame(1, userdtoList.get(1).getIdUser());
    assertSame(username, userdtoList.get(0).getUsername());
    assertSame(username, userdtoList.get(1).getUsername());
    assertSame(phone, userdtoList.get(0).getPhone());
    assertSame(phone, userdtoList.get(1).getPhone());
    assertSame(email, userdtoList.get(0).getEmail());
    assertSame(email, userdtoList.get(1).getEmail());
    assertSame(password, userdtoList.get(0).getPassword());
    assertSame(password, userdtoList.get(1).getPassword());
    assertSame(userList.get(0).getCreationDate(), userdtoList.get(0).getCreationDate());
    assertSame(userList.get(1).getCreationDate(), userdtoList.get(1).getCreationDate());
    assertSame(userList.get(0).getModificationDate(), userdtoList.get(0).getModificationDate());
    assertSame(userList.get(1).getModificationDate(), userdtoList.get(1).getModificationDate());
    assertSame(userList.get(0).getImage(), userdtoList.get(0).getImage());
    assertSame(userList.get(1).getImage(), userdtoList.get(1).getImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de User à une liste de UserDto quand la liste de User est null")
  void testConvertListUserToListUserDTOWithNull() {

    List<User> userList = List.of(createSampleUserWithNull(), createSampleUserWithNull());
    List<Userdto> userdtoList = userConvert.convertListEntityToListDto(userList);

    assertSame(1, userdtoList.get(0).getIdUser());
    assertSame(1, userdtoList.get(1).getIdUser());
    assertNull(userdtoList.get(0).getUsername());
    assertNull(userdtoList.get(1).getUsername());
    assertNull(userdtoList.get(0).getPhone());
    assertNull(userdtoList.get(1).getPhone());
    assertNull(userdtoList.get(0).getEmail());
    assertNull(userdtoList.get(1).getEmail());
    assertNull(userdtoList.get(0).getPassword());
    assertNull(userdtoList.get(1).getPassword());
    assertNull(userdtoList.get(0).getCreationDate());
    assertNull(userdtoList.get(1).getCreationDate());
    assertNull(userdtoList.get(0).getModificationDate());
    assertNull(userdtoList.get(1).getModificationDate());
    assertNull(userdtoList.get(0).getImage());
    assertNull(userdtoList.get(1).getImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de UserDto à une liste de User")
  void testConvertListUserDTOToListUser() {

    List<Userdto> userdtoList = List.of(createSampleUserDTO(), createSampleUserDTO());
    List<User> userList = userConvert.convertListDtoToListEntity(userdtoList);

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
    assertSame(userdtoList.get(0).getCreationDate(), userList.get(0).getCreationDate());
    assertSame(userdtoList.get(1).getCreationDate(), userList.get(1).getCreationDate());
    assertSame(userdtoList.get(0).getModificationDate(), userList.get(0).getModificationDate());
    assertSame(userdtoList.get(1).getModificationDate(), userList.get(1).getModificationDate());
    assertSame(userdtoList.get(0).getImage(), userList.get(0).getImage());
    assertSame(userdtoList.get(1).getImage(), userList.get(1).getImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de UserDto à une liste de User quand la liste de UserDto est null")
  void testConvertListUserDTOToListUserWithNull() {

    List<Userdto> userdtoList = List.of(createSampleUserDTOWithNull(), createSampleUserDTOWithNull());
    List<User> userList = userConvert.convertListDtoToListEntity(userdtoList);

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
