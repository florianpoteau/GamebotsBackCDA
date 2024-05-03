package co.simplon.gamebotsback.unit.presentation.controllers.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.user.ModifyUserAccountController;
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
  void modifyConversation() {
    doNothing().when(userService).modifyAccount(anyInt(), any(Userdto.class));
    controller.modifyUserAccount(1, new Userdto());
    verify(userService, times(1)).modifyAccount(anyInt(), any(Userdto.class));
  }
}
