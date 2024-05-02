package co.simplon.gamebotsback.unit.presentation.controllers.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.user.CreateUserAccountController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateUserAccountControllerTest {

  @InjectMocks
  CreateUserAccountController controller;

  @Mock
  private Iuserservice userService;

  @Test
  void createUserAccount() {
    doNothing().when(userService).createAccount(any(Userdto.class));
    controller.createAccount(new Userdto());
    verify(userService, times(1)).createAccount(any(Userdto.class));
  }
}
