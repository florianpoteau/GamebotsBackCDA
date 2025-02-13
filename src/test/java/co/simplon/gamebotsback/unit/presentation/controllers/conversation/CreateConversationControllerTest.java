package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.CreateConversationController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateConversationControllerTest {

  @InjectMocks
  private CreateConversationController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  @DisplayName("Test de création d'une conversation depuis le controller")
  void createConversation() {
    Conversationdto inputDto = new Conversationdto();
    Conversationdto returnedDto = new Conversationdto();

    when(conversationService.addNewConversation(any(Conversationdto.class))).thenReturn(returnedDto);

    controller.createConversation(inputDto);

    verify(conversationService, times(1)).addNewConversation(any(Conversationdto.class));
  }
}
