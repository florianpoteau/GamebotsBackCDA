package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.ModifyConversationController;
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
class ModifyConversationControllerTest {

  @InjectMocks
  private ModifyConversationController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  void modifyConversation() {
    doNothing().when(conversationService).modifyConversation(anyInt(), any(Conversationdto.class));
    controller.modifyConversation(1, new Conversationdto());
    verify(conversationService, times(1)).modifyConversation(anyInt(), any(Conversationdto.class));
  }
}
