package co.simplon.gamebotsback.unit.presentation.controllers.message;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.Imessageservice;
import co.simplon.gamebotsback.presentation.controller.message.CreateMessageController;
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
public class CreateMessageControllerTest {

  @InjectMocks
  private CreateMessageController createMessageController;

  @Mock
  private Imessageservice messageService;

  @Test
  void CreateMessage() {
    doNothing().when(messageService).addNewMessage(any(Messagedto.class));
    createMessageController.createMessage(new Messagedto());
    verify(messageService, times(1)).addNewMessage(any(Messagedto.class));
  }
}
