package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for retrieving conversations
 * by user ID in the presentation layer.
 * This controller handles HTTP GET requests
 * to fetch all conversations associated with a specific user ID.
 */
@RestController
public class GetAllConversationByUserIdController {

  /**
   * The conversation service used to retrieve conversations.
   */
  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetAllConversationByUserIdController
   * with the specified conversation service.
   *
   * @param serviceConversation
   *     The conversation service to be
   *     used for retrieving conversations.
   */
  @Autowired
  public GetAllConversationByUserIdController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP GET requests to fetch all
   * conversations associated with a specific user ID.
   *
   * @param id
   *     The ID of the user.
   *
   * @return A list of ConversationDTO objects representing conversations
   *     associated with the specified user ID.
   */
  @GetMapping("/users/{id}/conversations")
  public List<Conversationdto> findAllConversationsByUserId(
      @PathVariable final int id) {
    return conversationService.getAllUserConversations(id);
  }

}
