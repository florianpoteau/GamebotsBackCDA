package co.simplon.gamebotsback.unit.presentation.controllers.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import co.simplon.gamebotsback.presentation.controller.conversation.GetAllConversationsByUserIdAndGameIdController;
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
class GetAllConversationsByUserIdAndGameIdControllerTest {

  @InjectMocks
  private GetAllConversationsByUserIdAndGameIdController controller;

  @Mock
  private Iconversationservice conversationService;

  @Test
  @DisplayName("Test de recuperation de toutes les conversations par l'id de l'utilisateur et l'id du jeu depuis le controller")
  void getAllConversationByUserIdAndGameId() {
    when(conversationService.getAllUserConversationsByGameId(anyInt(), anyInt())).thenReturn(List.of(new Conversationdto()));
    controller.findAllConversationsByUserIdAndGameId(anyInt(), anyInt());
    verify(conversationService, times(1)).getAllUserConversationsByGameId(anyInt(), anyInt());
  }
}
