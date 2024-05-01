package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for retrieving conversations by user
 * ID and game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch
 * all conversations associated with a specific user ID and game ID.
 */
@RestController
public class GetAllConversationByUserIdAndGameIdController {

  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetAllConversationByUserIdAndGameIdController with the
   * specified conversation service.
   *
   * @param serviceConversation
   *     The conversation service
   *     to be used for retrieving conversations.
   */
  public GetAllConversationByUserIdAndGameIdController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP GET requests to fetch all conversations associated with a
   * specific user ID and game ID.
   */
  @GetMapping("/users/{userid}/games/{gameid}/conversations")
  List<Conversationdto> findAllConversationsByUserIdAndGameId(
      @PathVariable final int userid, @PathVariable final int gameid) {
    return conversationService.getAllUserConversationByGameId(userid, gameid);
  }

}
