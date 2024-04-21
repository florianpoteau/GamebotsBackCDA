package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.business.service.user.UserServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static co.simplon.gamebotsback.business.service.user.UserServiceImpl.ERRORMESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IUserRepository iUserRepository;

    User existingUser = new User();
    int userId = 1;
    UserDTO modifiedUserDTO = new UserDTO();

    @Test
    @DisplayName("Test d'ajout d'un nouvel utilisateur")
    void createAccount() {

        when(iUserRepository.save(any(User.class))).thenReturn(null);

        userService.createAccount(new UserDTO());

        verify(iUserRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Test de récupération d'un jeu par son id")
    void testGetById() {

        existingUser.setIdUser(userId);

        when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        UserDTO userDTO = userService.getById(userId);

        verify(iUserRepository, times(1)).findById(userId);
        assertNotNull(userDTO, "UserDTO attendu dans la liste");
        assertEquals(userId, userDTO.getIdUser(), "UserDTO attendu dans la liste");
    }

    @Test
    @DisplayName("Test de récupération d'un jeu par son id - jeu non trouvé")
    void testGetByIdWhenUserDoesNotExist() {

        when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->  userService.getById(userId));

        assertEquals(ERRORMESSAGE + userId, exception.getMessage(), "Le message d'erreur doit être correct");
        verify(iUserRepository, times(1)).findById(userId);
    }

    @Test
    @DisplayName("Test de modification d'un utilisateur existant")
    void testModifyAccount() {

        existingUser.setIdUser(userId);
        modifiedUserDTO.setIdUser(userId);
        modifiedUserDTO.setUsername("leGamerzzz");
        modifiedUserDTO.setPhone("1234567890");
        modifiedUserDTO.setEmail("leGamerzzz@gmail.com");
        modifiedUserDTO.setPassword("*****");
        modifiedUserDTO.setCreationDate(new Date());
        modifiedUserDTO.setModificationDate(new Date());
        modifiedUserDTO.setImage(new Image());

        when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(iUserRepository.save(any(User.class))).thenReturn(existingUser);
        UserDTO modifiedUser = userService.modifyAccount(userId, modifiedUserDTO);

        verify(iUserRepository, times(1)).findById(userId);
        verify(iUserRepository, times(1)).save(any(User.class));
        assertNotNull(modifiedUser,"L'utilisateur modifié ne doit pas être null");
        assertEquals(modifiedUserDTO.getIdUser(), modifiedUser.getIdUser());
        assertEquals(modifiedUserDTO.getUsername(), modifiedUser.getUsername());
        assertEquals(modifiedUserDTO.getPhone(), modifiedUser.getPhone());
        assertEquals(modifiedUserDTO.getEmail(), modifiedUser.getEmail());
        assertEquals(modifiedUserDTO.getPassword(), modifiedUser.getPassword());
        assertEquals(modifiedUserDTO.getCreationDate(), modifiedUser.getCreationDate());
        assertEquals(modifiedUserDTO.getModificationDate(), modifiedUser.getModificationDate());
        assertEquals(modifiedUserDTO.getImage(), modifiedUser.getImage());
    }

    @Test
    @DisplayName("Test de modification d'un utilisateur existant - utilisateur non trouvé")
    void testModifyAccountNotFound() {

        modifiedUserDTO.setIdUser(userId);
        modifiedUserDTO.setUsername("leGamerzzz");
        modifiedUserDTO.setPhone("1234567890");
        modifiedUserDTO.setEmail("leGamerzzz@gmail.com");
        modifiedUserDTO.setPassword("*****");
        modifiedUserDTO.setCreationDate(new Date());
        modifiedUserDTO.setModificationDate(new Date());
        modifiedUserDTO.setImage(new Image());

        when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.modifyAccount(userId, modifiedUserDTO));

        assertEquals(UserServiceImpl.ERRORMESSAGE + userId, exception.getMessage(), "Le message d'erreur doit être correct");
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
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> userService.deleteAccount(userId));

        assertEquals(UserServiceImpl.ERRORMESSAGE + userId, exception.getMessage(), "Le message d'erreur doit être correct");
        verify(iUserRepository, times(1)).findById(userId);
        verify(iUserRepository, never()).deleteById(any(Integer.class));
    }

}
