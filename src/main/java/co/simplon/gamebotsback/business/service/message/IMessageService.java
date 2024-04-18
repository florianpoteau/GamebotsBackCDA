/**
 * The <code>IMessageService</code> interface defines operations available for managing messages.
 */
package co.simplon.gamebotsback.business.service.message;

import co.simplon.gamebotsback.business.dto.MessageDTO;

import java.util.List;

/**
 * The <code>IMessageService</code> interface defines operations available for
 * managing messages.
 */
public interface IMessageService {

    /**
     * Retrieves all messages of a specific conversation.
     *
     * @param idConversation The ID of the conversation.
     * @return A list of messages of the specified conversation.
     */
    List<MessageDTO> getAllMessageConversation(int idConversation);

    /**
     * Adds a new message to a conversation.
     *
     * @param messageDTO The information of the new message to add.
     */
    void addNewMessage(final MessageDTO messageDTO);
}
