package co.simplon.gamebotsback.presentation.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.business.service.message.IMessageService;

@RestController
public class CreateMessageController {

    private final IMessageService messageService;

    @Autowired
    public CreateMessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public void createMessage(@RequestBody MessageDTO messageDTO) {
        messageService.addNewMessage(messageDTO);
    }

}
