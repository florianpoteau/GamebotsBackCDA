package co.simplon.gamebotsback.unit.presentation.controllers.user;

import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.user.DeleteUserAccountController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteUserAccountControllerTest {

  @InjectMocks
  private DeleteUserAccountController controller;

  @Mock
  private Iuserservice userService;

  @Test
  @DisplayName("Test de suppression d'un utilisateur depuis le controller")
  void deleteUserAccount() {
    doNothing().when(userService).deleteUserAccount(anyInt());
    controller.deleteUserAccountByUserId(anyInt());
    verify(userService, times(1)).deleteUserAccount(anyInt());
  }
}
