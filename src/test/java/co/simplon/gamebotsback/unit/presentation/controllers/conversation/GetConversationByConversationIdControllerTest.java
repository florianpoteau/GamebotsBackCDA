package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.GetConversationByConversationIdController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetConversationByConversationIdControllerTest {

  @InjectMocks
  private GetConversationByConversationIdController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  @DisplayName("Test de recuperation d'une conversation par son id depuis le controller")
  void getConversationById() {
    when(conversationService.getConversationByConversationId(anyInt())).thenReturn(new Conversationdto());
    Conversationdto conversationdto = controller.findConversationByConversationId(anyInt());
    verify(conversationService, times(1)).getConversationByConversationId(anyInt());
    assertEquals(Conversationdto.class, conversationdto.getClass());
  }
}
