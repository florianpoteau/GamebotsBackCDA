package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class CreateConversationController {

    private final IConversationService conversationService;

    @Autowired
    public CreateConversationController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/conversations")
    public void createConversations(@RequestBody ConversationDTO conversationDTO) {
        conversationService.addNewConversation(conversationDTO);
    }

}
