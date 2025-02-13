package co.simplon.gamebotsback.presentation.controller.message;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.Imessageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for creating a new message in the presentation layer.
 * This controller handles HTTP POST requests
 * to create a new message using the provided MessageDTO object.
 */
@RestController
public class CreateMessageController {

  /**
   * The service used to manage messages.
   */
  private final Imessageservice messageService;

  /**
   * Constructs a new CreateMessageController
   * with the specified message service.
   *
   * @param serviceMessage The message service used to add a new message.
   */
  @Autowired
  public CreateMessageController(final Imessageservice serviceMessage) {
    this.messageService = serviceMessage;
  }

  /**
   * Handles HTTP POST requests to create a new message.
   *
   * @param messageDto The MessageDTO object containing
   *                   the details of the message to be created.
   */
  @PostMapping("/messages")
  public void createMessage(@RequestBody final Messagedto messageDto) {
    messageService.addNewMessage(messageDto);
  }

}
