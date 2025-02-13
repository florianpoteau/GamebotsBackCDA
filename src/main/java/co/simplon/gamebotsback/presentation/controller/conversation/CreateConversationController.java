package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller responsible for creating
 * new conversations via HTTP POST requests.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CreateConversationController {

  /**
   * The service responsible for managing conversations.
   */
  private final Iconversationservice conversationService;

  /**
   * Constructs a new CreateConversationController
   * with the specified conversation
   * service.
   *
   * @param serviceConversation
   *     The conversation service to be used for creating
   *     conversations.
   */
  @Autowired
  public CreateConversationController(
      final Iconversationservice serviceConversation) {
    this.conversationService = serviceConversation;
  }

  /**
   * Handles HTTP POST requests to create a new conversation.
   *
   * @param conversationDto
   *     The data transfer object containing information about
   *     the conversation to be created.
   */
  @PostMapping("/conversations")
  public Conversationdto createConversation(
      @RequestBody final Conversationdto conversationDto) {
    conversationService.addNewConversation(conversationDto);
    return conversationDto;
  }

}
