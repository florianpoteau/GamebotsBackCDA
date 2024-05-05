package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.UserServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.Iuserrepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

import static co.simplon.gamebotsback.business.service.user.UserServiceImpl.ERRORMESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  User existingUser = new User();

  int userId = 1;

  String username = "Je suis un Username";

  Userdto modifiedUserdto = new Userdto();

  @Mock
  private PasswordEncoder passwordEncoder;

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private Iuserrepository iUserRepository;

  @Test
  @DisplayName("Test d'ajout d'un nouvel utilisateur")
  void createAccount() {

    when(iUserRepository.save(any(User.class))).thenReturn(null);

    userService.createAccount(new Userdto());

    verify(iUserRepository, times(1)).save(any(User.class));
  }

  @Test
  @DisplayName("Test de récupération d'un utilisateur par son id")
  void testGetById() {

    existingUser.setIdUser(userId);

    when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
    Userdto userDTO = userService.getById(userId);

    verify(iUserRepository, times(1)).findById(userId);
    assertNotNull(userDTO, "UserDTO attendu dans la liste");
    assertEquals(userId, userDTO.getIdUser(), "UserDTO attendu dans la liste");
  }

  @Test
  @DisplayName("Test de récupération d'un utilisateur par son id - utilisateur non trouvé")
  void testGetByIdWhenUserDoesNotExist() {

    when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.getById(userId));

    assertEquals(ERRORMESSAGE + userId, exception.getMessage(), "User does not exist: ");
    verify(iUserRepository, times(1)).findById(userId);
  }

  @Test
  @DisplayName("Test de récupération d'un id d'utilisateur par son username")
  void testGetIdByUsername() {

    existingUser.setUsername(username);
    existingUser.setIdUser(userId);

    when(iUserRepository.findByUsername(username)).thenReturn(Optional.of(existingUser));
    int idUser = userService.getIdByUsername(username);

    verify(iUserRepository, times(1)).findByUsername(username);
    assertEquals(userId, idUser, "id non égaux");
  }

  @Test
  @DisplayName("Test de récupération d'un id d'utilisateur par son username - utilisateur non trouvé")
  void testGetIdByUsernameWhenUserDoesNotExist() {

    when(iUserRepository.findByUsername(username)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> userService.getIdByUsername(username));

    verify(iUserRepository, times(1)).findByUsername(username);
    assertEquals(ERRORMESSAGE + username, exception.getMessage(), "User does not exist: ");
  }

  @Test
  @DisplayName("Test de modification d'un utilisateur existant")
  void testModifyAccount() {

    existingUser.setIdUser(userId);
    modifiedUserdto.setIdUser(userId);
    modifiedUserdto.setUsername("leGamerzzz");
    modifiedUserdto.setPhone("1234567890");
    modifiedUserdto.setEmail("leGamerzzz@gmail.com");
    modifiedUserdto.setPassword("*****");
    modifiedUserdto.setModificationDate(new Date());
    modifiedUserdto.setImage(new Image());

    when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
    userService.modifyAccount(userId, modifiedUserdto);

    verify(iUserRepository, times(1)).findById(userId);
    verify(iUserRepository, times(1)).save(any(User.class));
  }

  @Test
  @DisplayName("Test de modification d'un utilisateur existant - utilisateur non trouvé")
  void testModifyAccountNotFound() {

    modifiedUserdto.setIdUser(userId);
    modifiedUserdto.setUsername("leGamerzzz");
    modifiedUserdto.setPhone("1234567890");
    modifiedUserdto.setEmail("leGamerzzz@gmail.com");
    modifiedUserdto.setPassword("*****");
    modifiedUserdto.setModificationDate(new Date());
    modifiedUserdto.setImage(new Image());

    when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> userService.modifyAccount(userId, modifiedUserdto));

    assertEquals(UserServiceImpl.ERRORMESSAGE + userId, exception.getMessage(),
        "Le message d'erreur doit être correct");
    verify(iUserRepository, times(1)).findById(userId);
    verify(iUserRepository, never()).save(any(User.class));
  }

  @Test
  @DisplayName("Test de suppression d'un utilisateur par son ID")
  void testDeleteAccount() {

    existingUser.setIdUser(userId);

    when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
    userService.deleteAccount(userId);

    verify(iUserRepository, times(1)).findById(userId);
    verify(iUserRepository, times(1)).deleteById(any(Integer.class));
  }

  @Test
  @DisplayName("Test de suppression d'un utilisateur par son ID - utilisateur non trouvé")
  void testDeleteAccountNotFound() {

    when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
    EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
        () -> userService.deleteAccount(userId));

    assertEquals(UserServiceImpl.ERRORMESSAGE + userId, exception.getMessage(),
        "Le message d'erreur doit être correct");
    verify(iUserRepository, times(1)).findById(userId);
    verify(iUserRepository, never()).deleteById(any(Integer.class));
  }

}
