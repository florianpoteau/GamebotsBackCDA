/**
 * Controller class for retrieving all messages by conversation ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all messages associated with a specific conversation ID.
 */
package co.simplon.gamebotsback.presentation.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.IMessageService;

@RestController
public class GetAllMessageByIdConversationController {

  private final IMessageService messageService;

  /**
   * Constructs a new GetAllMessageByIdConversationController with the specified
   * message service.
   *
   * @param messageService The message service used to retrieve all messages by
   *                       conversation ID.
   */
  @Autowired
  public GetAllMessageByIdConversationController(IMessageService messageService) {
    this.messageService = messageService;
  }

  /**
   * Handles HTTP GET requests to fetch all messages by conversation ID.
   *
   * @param id The ID of the conversation for which messages are to be retrieved.
   * @return A list of MessageDTO objects representing all messages associated
   * with the specified conversation ID.
   */
  @GetMapping("/conversations/{id}/messages")
  List<Messagedto> findAllMessagesByIdConversation(@PathVariable int id) {
    return messageService.getAllMessageConversation(id);
  }

}
