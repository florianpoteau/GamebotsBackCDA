/**
 * Controller class for retrieving conversations by user ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all conversations associated with a specific user ID.
 */
package co.simplon.gamebotsback.presentation.controller.conversation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

@RestController
public class GetAllConversationByUserIdController {

  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetAllConversationByUserIdController with the specified
   * conversation service.
   *
   * @param conversationService The conversation service to be used for retrieving
   *                            conversations.
   */
  @Autowired
  public GetAllConversationByUserIdController(Iconversationservice conversationService) {
    this.conversationService = conversationService;
  }

  /**
   * Handles HTTP GET requests to fetch all conversations associated with a
   * specific user ID.
   *
   * @param id The ID of the user.
   * @return A list of ConversationDTO objects representing conversations
   * associated with the specified user ID.
   */
  @GetMapping("/users/{id}/conversations")
  List<Conversationdto> findAllConversationsByUserId(@PathVariable int id) {
    return conversationService.getAllUserConversation(id);
  }

}
