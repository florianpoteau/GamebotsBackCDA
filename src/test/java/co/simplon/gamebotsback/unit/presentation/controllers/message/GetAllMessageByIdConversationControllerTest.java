package co.simplon.gamebotsback.unit.presentation.controllers.message;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.Imessageservice;
import co.simplon.gamebotsback.presentation.controller.message.GetAllMessageByIdConversationController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllMessageByIdConversationControllerTest {

  @InjectMocks
  private GetAllMessageByIdConversationController controller;

  @Mock
  private Imessageservice messageService;

  @Test
  @DisplayName("Test de recuperation de tous les messages par l'id d'une conversation depuis le controller")
  void getAllMessageByIdConversation() {
    when(messageService.getAllMessageConversation(anyInt())).thenReturn(List.of(new Messagedto()));
    controller.findAllMessagesByIdConversation(anyInt());
    verify(messageService, times(1)).getAllMessageConversation(anyInt());
  }
}
