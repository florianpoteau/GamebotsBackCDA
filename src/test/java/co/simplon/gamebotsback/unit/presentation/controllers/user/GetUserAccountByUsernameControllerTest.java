package co.simplon.gamebotsback.unit.presentation.controllers.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.user.GetUserAccountByUsernameController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserAccountByUsernameControllerTest {

  @InjectMocks
  GetUserAccountByUsernameController controller;

  @Mock
  private Iuserservice userService;

  @Test
  @DisplayName("Test de recuperation d'un utilisateur par son username depuis le controller")
  void getUserAccountByUsername() {
    when(userService.getUserIdByUsername(anyString())).thenReturn(new Userdto().getIdUser());
    int id = controller.findUserIdByUsername(anyString());
    verify(userService, times(1)).getUserIdByUsername(anyString());
    assertEquals(id, userService.getUserIdByUsername(anyString()));
  }
}
