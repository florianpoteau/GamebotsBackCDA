package co.simplon.gamebotsback.presentation.controller.conversation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class GetAllConversationByUserIdAndGameIdController {

    private final IConversationService conversationService;

    public GetAllConversationByUserIdAndGameIdController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/users/{user_id}/games/{game_id}/conversations")
    List<ConversationDTO> findAllConversationsByUserIdAndGameId(@PathVariable int user_id, @PathVariable int game_id) {
        return conversationService.getAllUserConversationByGameId(user_id, game_id);
    }

}
