package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.DeleteConversationController;
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
class DeleteConversationControllerTest {

  @InjectMocks
  private DeleteConversationController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  @DisplayName("Test de suppression d'une conversation depuis le controller")
  void deleteConversation() {
    doNothing().when(conversationService).deleteConversation(anyInt());
    controller.deleteConversationbyid(anyInt());
    verify(conversationService, times(1)).deleteConversation(anyInt());
  }
}
