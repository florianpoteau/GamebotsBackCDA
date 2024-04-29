/**
 * Controller class for retrieving a conversation by its ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch a conversation with a specific ID.
 */
package co.simplon.gamebotsback.presentation.controller.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

@RestController
public class GetConversationByIdController {

  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetConversationByIdController with the specified
   * conversation service.
   *
   * @param conversationService The conversation service to be used for retrieving
   *                            the conversation by ID.
   */
  @Autowired
  public GetConversationByIdController(Iconversationservice conversationService) {
    this.conversationService = conversationService;
  }

  /**
   * Handles HTTP GET requests to fetch a conversation by its ID.
   *
   * @param id The ID of the conversation to retrieve.
   * @return A ConversationDTO object representing the conversation with the
   * specified ID.
   */
  @GetMapping("/conversations/{id}")
  Conversationdto findConversationById(@PathVariable int id) {
    return conversationService.getById(id);
  }

}
