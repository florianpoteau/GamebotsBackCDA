package co.simplon.gamebotsback.persistance.repository.message;

import co.simplon.gamebotsback.persistance.entity.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for managing Message entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic
 * CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Message entities.
 */
public interface Imessagerepository extends JpaRepository<Message, Integer> {

  /**
   * Retrieves all messages associated with a specific conversation ID.
   *
   * @param conversationId
   *     The ID of the conversation.
   *
   * @return A list of messages associated with the specified conversation ID.
   */
  @Query(MessageQueries.FIND_MESSAGES_BY_CONVERSATION)
  List<Message> getMessagesByConversationId(int conversationId);

}
