package co.simplon.gamebotsback.presentation.controller.message;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.Imessageservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling
 * HTTP requests related to retrieving all messages by conversation ID.
 * This controller handles HTTP GET requests to
 * fetch all messages associated with a specific conversation ID.
 */
@RestController
public class GetAllMessageByIdConversationController {

  /**
   * The message service used to retrieve all messages by conversation ID.
   */
  private final Imessageservice messageService;

  /**
   * Constructs a new GetAllMessageByIdConversationController
   * with the specified message service.
   *
   * @param serviceMessage
   *     The message service used to retrieve all messages by conversation ID.
   */
  @Autowired
  public GetAllMessageByIdConversationController(
      final Imessageservice serviceMessage) {
    this.messageService = serviceMessage;
  }

  /**
   * Handles HTTP GET requests to fetch all messages by conversation ID.
   *
   * @param id
   *     The ID of the conversation for which messages are to be retrieved.
   *
   * @return A list of Messagedto objects representing all
   *     messages associated with the specified conversation ID.
   */
  @GetMapping("/conversations/{id}/messages")
  List<Messagedto> findAllMessagesByIdConversation(@PathVariable final int id) {
    return messageService.getAllMessageConversation(id);
  }

}
