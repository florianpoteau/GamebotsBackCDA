package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for retrieving conversations by user
 * ID and game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all
 * conversations associated with a specific user ID and game ID.
 */
@RestController
public class GetAllConversationsByUserIdAndGameIdController {

  /**
   * The conversation service used to retrieve conversations.
   */
  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetAllConversationByUserIdAndGameIdController
   * with the specified conversation service.
   *
   * @param serviceConversation
   *     The conversation service to be used for retrieving conversations.
   */
  @Autowired
  public GetAllConversationsByUserIdAndGameIdController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP GET requests to fetch all conversations
   * associated with a specific user ID and game ID.
   *
   * @param userId
   *     The ID of the user whose conversations are to be retrieved.
   * @param gameId
   *     The ID of the game associated with the conversations.
   *
   * @return A list of Conversationdto objects
   *     representing the retrieved conversations.
   */
  @GetMapping("/users/{userId}/games/{gameId}/conversations")
  public List<Conversationdto> findAllConversationsByUserIdAndGameId(
      @PathVariable final int userId, @PathVariable final int gameId) {
    return conversationService.getAllUserConversationsByGameId(userId, gameId);
  }
}
