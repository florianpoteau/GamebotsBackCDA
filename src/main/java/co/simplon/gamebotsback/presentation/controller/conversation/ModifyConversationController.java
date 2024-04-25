/**
 * Controller class for modifying a conversation in the presentation layer.
 * This controller handles HTTP PUT requests to update an existing conversation with the provided data.
 */
package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.IConversationService;

@RestController
public class ModifyConversationController {

  private final IConversationService conversationService;

  /**
   * Constructs a new ModifyConversationController with the specified conversation
   * service.
   *
   * @param conversationService The conversation service used to modify
   *                            conversations.
   */
  @Autowired
  public ModifyConversationController(IConversationService conversationService) {
    this.conversationService = conversationService;
  }

  /**
   * Handles HTTP PUT requests to update an existing conversation.
   *
   * @param id              The ID of the conversation to be modified.
   * @param conversationDTO The updated ConversationDTO object containing the
   *                        modified conversation data.
   */
  @PutMapping("/conversations/{id}")
  public void modifyConversation(@PathVariable int id, @RequestBody Conversationdto conversationDTO) {
    conversationService.modifyConversation(id, conversationDTO);
  }

}
