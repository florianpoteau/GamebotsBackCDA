package co.simplon.gamebotsback.business.service.message;

import co.simplon.gamebotsback.business.convert.MessageConvert;
import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    private IMessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageDTO> getAllMessageConversation(int idConversation) {
        final List<Message> result = messageRepository.getMessageByConversationId(idConversation);
        return MessageConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public void addNewMessage(MessageDTO messageDTO) {
        messageRepository.save(MessageConvert.getInstance().convertDtoToEntity(messageDTO));
    }
}
