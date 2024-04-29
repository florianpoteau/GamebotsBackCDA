/**
 * Controller class for retrieving conversations by user ID and game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all conversations associated with a specific user ID and game ID.
 */
package co.simplon.gamebotsback.presentation.controller.conversation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

@RestController
public class GetAllConversationByUserIdAndGameIdController {

  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetAllConversationByUserIdAndGameIdController with the
   * specified conversation service.
   *
   * @param conversationService The conversation service to be used for retrieving
   *                            conversations.
   */
  public GetAllConversationByUserIdAndGameIdController(Iconversationservice conversationService) {
    this.conversationService = conversationService;
  }

  /**
   * Handles HTTP GET requests to fetch all conversations associated with a
   * specific user ID and game ID
   */
  @GetMapping("/users/{user_id}/games/{game_id}/conversations")
  List<Conversationdto> findAllConversationsByUserIdAndGameId(@PathVariable int user_id, @PathVariable int game_id) {
    return conversationService.getAllUserConversationByGameId(user_id, game_id);
  }

}
