package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class DeleteConversationController {

    private final IConversationService conversationService;

    @Autowired
    public DeleteConversationController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @DeleteMapping("/conversations/{id}")
    public void deleteConversationByID(@PathVariable final int id) {
        conversationService.deleteConversation(id);
    }

}
