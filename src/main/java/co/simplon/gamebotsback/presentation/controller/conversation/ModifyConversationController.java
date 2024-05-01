package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for modifying a conversation in the presentation layer.
 * This controller handles HTTP PUT requests to update
 * an existing conversation with the provided data.
 */
@RestController
public class ModifyConversationController {

  private final Iconversationservice conversationService;

  /**
   * Constructs a new ModifyConversationController
   * with the specified conversation
   * service.
   *
   * @param serviceConversation
   *     The conversation
   *     service used to modify conversations.
   */
  @Autowired
  public ModifyConversationController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP PUT requests to update an existing conversation.
   *
   * @param id
   *     The ID of the conversation to be modified.
   * @param conversationDto
   *     The updated ConversationDTO object containing the
   *     modified conversation data.
   */
  @PutMapping("/conversations/{id}")
  public void modifyConversation(
      @PathVariable final int id,
      @RequestBody final Conversationdto conversationDto) {
    conversationService.modifyConversation(id, conversationDto);
  }

}
