package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP requests related to fetching
 * a conversation by its ID.
 * This controller handles HTTP GET
 * requests to retrieve a conversation by its ID.
 */
@RestController
public class GetConversationByConversationIdController {

  /**
   * The conversation service used for conversation-related operations.
   */
  private final Iconversationservice conversationService;

  /**
   * Constructs a new GetConversationByIdController
   * with the specified conversation service.
   *
   * @param serviceConversation
   *     The conversation service to be used for retrieving
   *     the conversation by ID.
   */
  @Autowired
  public GetConversationByConversationIdController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP GET requests to fetch a conversation by its ID.
   *
   * @param conversationId
   *     The ID of the conversation to retrieve.
   *
   * @return A ConversationDTO object representing
   *     the conversation with the specified ID.
   */
  @GetMapping("/conversations/{conversationId}")
  public Conversationdto findConversationByConversationId(
      @PathVariable final int conversationId) {
    return conversationService.getConversationByConversationId(conversationId);
  }

}
