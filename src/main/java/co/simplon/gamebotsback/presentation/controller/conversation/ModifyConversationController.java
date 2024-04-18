package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class ModifyConversationController {

    private final IConversationService conversationService;

    @Autowired
    public ModifyConversationController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PutMapping("/conversations/{id}")
    public void modifyConversation(@PathVariable int id, @RequestBody ConversationDTO conversationDTO) {
        conversationService.modifyConversation(id, conversationDTO);
    }

}
