package co.simplon.gamebotsback.unit.presentation.controllers.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.user.ModifyUserAccountController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ModifyUserAccountControllerTest {

  @InjectMocks
  private ModifyUserAccountController controller;

  @Mock
  private Iuserservice userService;

  @Test
  @DisplayName("Test de modification d'un utilisateur depuis le controller")
  void modifyConversation() {
    doNothing().when(userService).modifyUserAccount(anyInt(), any(Userdto.class));
    controller.modifyUserAccount(1, new Userdto());
    verify(userService, times(1)).modifyUserAccount(anyInt(), any(Userdto.class));
  }
}
