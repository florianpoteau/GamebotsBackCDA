package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.business.service.user.UserServiceImpl;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IUserRepository iUserRepository;

    @Test
    @DisplayName("Test d'ajout d'un nouvel utilisateur")
    void createAccount() {
        when(iUserRepository.save(any(User.class))).thenReturn(null);
        userService.createAccount(new UserDTO());
        verify(iUserRepository, times(1)).save(any(User.class));
    }
}
