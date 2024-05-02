package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.GetConversationByIdController;
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
class GetConversationByIdControllerTest {

  @InjectMocks
  private GetConversationByIdController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  void getConversationById() {
    when(conversationService.getById(anyInt())).thenReturn(new Conversationdto());
    Conversationdto conversationdto = controller.findConversationById(anyInt());
    verify(conversationService, times(1)).getById(anyInt());
    assertEquals(Conversationdto.class, conversationdto.getClass());
  }
}
