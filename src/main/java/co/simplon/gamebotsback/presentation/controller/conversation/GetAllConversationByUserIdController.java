package co.simplon.gamebotsback.presentation.controller.conversation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class GetAllConversationByUserIdController {

    private final IConversationService conversationService;

    @Autowired
    public GetAllConversationByUserIdController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/users/{id}/conversations")
    List<ConversationDTO> findAllConversationByUserId(@PathVariable int id) {
        return conversationService.getAllUserConversation(id);
    }

}
