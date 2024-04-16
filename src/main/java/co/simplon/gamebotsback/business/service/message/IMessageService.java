package co.simplon.gamebotsback.business.service.message;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;

import java.util.List;

public interface IMessageService {

    List<MessageDTO> getAllMessageConversation();

    void addNewMessage(final MessageDTO messageDTO);
}
