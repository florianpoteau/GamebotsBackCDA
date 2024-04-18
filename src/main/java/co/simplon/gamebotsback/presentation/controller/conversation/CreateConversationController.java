/**
 * Controller class for creating conversations in the presentation layer.
 * This controller handles HTTP POST requests to create new conversations.
 */
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

    /**
     * Constructs a new CreateConversationController with the specified conversation
     * service.
     *
     * @param conversationService The conversation service to be used for creating
     *                            conversations.
     */
    @Autowired
    public CreateConversationController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    /**
     * Handles HTTP POST requests to create a new conversation.
     *
     * @param conversationDTO The data transfer object containing information about
     *                        the conversation to be created.
     */
    @PostMapping("/conversations")
    public void createConversation(@RequestBody ConversationDTO conversationDTO) {
        conversationService.addNewConversation(conversationDTO);
    }

}
