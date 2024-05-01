package co.simplon.gamebotsback.presentation.controller.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.business.service.conversation.Iconversationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreateConversationController {

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
  public void createConversation(
      @RequestBody final Conversationdto conversationDto) {
    conversationService.addNewConversation(conversationDto);
  }

}
