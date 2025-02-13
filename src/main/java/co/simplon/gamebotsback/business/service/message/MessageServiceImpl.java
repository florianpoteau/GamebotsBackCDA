package co.simplon.gamebotsback.business.service.message;

import co.simplon.gamebotsback.business.convert.MessageConvert;
import co.simplon.gamebotsback.business.dto.Messagedto;
import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.Imessagerepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the <code>IMessageService</code> interface
 * providing functionalities for managing messages.
 */
@Service
public class MessageServiceImpl implements Imessageservice {

  /**
   * The repository used to access message data.
   */
  private final Imessagerepository messageRepository;

  /**
   * Constructor for <code>MessageServiceImpl</code>.
   *
   * @param repositoryMessage
   *     The repository used to access message data.
   */
  @Autowired
  public MessageServiceImpl(final Imessagerepository repositoryMessage) {
    this.messageRepository = repositoryMessage;
  }

  /**
   * Retrieves all messages of a specific conversation.
   *
   * @param idConversation
   *     The ID of the conversation.
   *
   * @return A list of messages of the specified conversation.
   */
  @Override
  public List<Messagedto> getAllMessagesConversation(final int idConversation, final int idUser) {
    final List<Message> result = messageRepository.getMessagesByConversationIdAndUserId(idConversation, idUser);
    
    return MessageConvert.getInstance().convertListEntityToListDto(result);
  }

  /**
   * Adds a new message to a conversation.
   *
   * @param messageDto
   *     The information of the new message to add.
   */
  @Override
  public void addNewMessage(final Messagedto messageDto) {
    messageDto.setCreationDate(new Date());
    messageRepository.save(
        MessageConvert.getInstance().convertDtoToEntity(messageDto));
  }
}
