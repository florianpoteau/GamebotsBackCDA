package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.business.service.user.UserServiceImpl;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @Test
    @DisplayName("Test d'ajout d'un nouvel utilisateur")
    void createAccount() {
        when(iUserRepository.save(any(User.class))).thenReturn(null);
        userService.createAccount(new UserDTO());
        verify(iUserRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Test de récupération d'un jeu par son id")
    void getById() {
        existingUser.setIdUser(userId);
        when(iUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        UserDTO userDTO = userService.getById(userId);
        verify(iUserRepository, times(1)).findById(userId);
        assertNotNull(userDTO, "ImageDTO attendu dans la liste");
        assertEquals(userId, userDTO.getIdUser(), "ImageDTO attendu dans la liste");
    }

    @Test
    @DisplayName("Test de récupération d'un jeu par son id - jeu non trouvé")
    void testGetByIdWhenUserDoesNotExist() {
        when(iUserRepository.findById(userId)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->  userService.getById(userId));
        assertEquals(ERRORMESSAGE + userId, exception.getMessage(), "Le message d'erreur doit être correct");
        verify(iUserRepository, times(1)).findById(userId);
    }

}
