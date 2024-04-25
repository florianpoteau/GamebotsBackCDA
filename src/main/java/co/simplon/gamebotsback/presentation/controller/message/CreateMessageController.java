/**
 * Controller class for creating a new message in the presentation layer.
 * This controller handles HTTP POST requests to create a new message using the provided MessageDTO object.
 */
package co.simplon.gamebotsback.presentation.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.business.service.message.Imessageservice;

@RestController
public class CreateMessageController {

  private final Imessageservice messageService;

  /**
   * Constructs a new CreateMessageController with the specified message service.
   *
   * @param messageService The message service used to add a new message.
   */
  @Autowired
  public CreateMessageController(Imessageservice messageService) {
    this.messageService = messageService;
  }

  /**
   * Handles HTTP POST requests to create a new message.
   *
   * @param messageDTO The MessageDTO object containing the details of the message
   *                   to be created.
   */
  @PostMapping("/messages")
  public void createMessage(@RequestBody Messagedto messageDTO) {
    messageService.addNewMessage(messageDTO);
  }

}
