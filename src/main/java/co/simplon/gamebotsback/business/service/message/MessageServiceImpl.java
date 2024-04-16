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

    @Autowired
    public void setMessageRepo(IMessageRepository messageRepo) { this.messageRepo = messageRepo; }

    private IMessageRepository messageRepo;


    @Override
    public List<MessageDTO> getAllMessageConversation() {
        final List<Message> result = messageRepo.findAll();
        return MessageConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public void addNewMessage(MessageDTO message) {
        messageRepo.save(MessageConvert.getInstance().convertDtoToEntity(message));
    }
}
