/**
 * Implementation of the <code>IMessageService</code> interface providing functionalities for managing messages.
 */
package co.simplon.gamebotsback.business.service.message;

import co.simplon.gamebotsback.business.convert.MessageConvert;
import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the <code>IMessageService</code> interface providing functionalities for managing messages.
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private final IMessageRepository messageRepository;

    /**
     * Constructor for <code>MessageServiceImpl</code>.
     *
     * @param messageRepository The repository used to access message data.
     */
    @Autowired
    public MessageServiceImpl(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Retrieves all messages of a specific conversation.
     *
     * @param idConversation The ID of the conversation.
     * @return A list of messages of the specified conversation.
     */
    @Override
    public List<MessageDTO> getAllMessageConversation(int idConversation) {
        final List<Message> result = messageRepository.getMessageByConversationId(idConversation);
        return MessageConvert.getInstance().convertListEntityToListDto(result);
    }

    /**
     * Adds a new message to a conversation.
     *
     * @param messageDTO The information of the new message to add.
     */
    @Override
    public void addNewMessage(MessageDTO messageDTO) {
        messageRepository.save(MessageConvert.getInstance().convertDtoToEntity(messageDTO));
    }
}
