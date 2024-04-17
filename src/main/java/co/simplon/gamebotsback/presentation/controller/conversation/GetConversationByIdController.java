package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class GetConversationByIdController {

    private final IConversationService conversationService;

    public GetConversationByIdController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/conversations/{id}")
    ConversationDTO findConversationById(@PathVariable int id) {
        return conversationService.getById(id);
    }

}
