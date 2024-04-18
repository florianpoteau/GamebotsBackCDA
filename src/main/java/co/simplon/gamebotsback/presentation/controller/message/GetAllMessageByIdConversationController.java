package co.simplon.gamebotsback.presentation.controller.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.business.service.message.IMessageService;

@RestController
public class GetAllMessageByIdConversationController {

    private final IMessageService messageService;

    @Autowired
    public GetAllMessageByIdConversationController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/conversations/{id}/messages")
    List<MessageDTO> findAllMessageByIdConversation(@PathVariable int id) {
        return messageService.getAllMessageConversation(id);
    }

}
