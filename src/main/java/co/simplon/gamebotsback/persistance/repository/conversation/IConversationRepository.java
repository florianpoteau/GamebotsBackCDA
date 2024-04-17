/**
 * Repository interface for managing Conversation entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Conversation entities.
 *
 * @param <Conversation> The type of entity managed by this repository, which is Conversation.
 * @param <Integer>      The type of the identifier property of the Conversation entity, which is Integer.
 *                       This represents the type of the primary key.
 */
package co.simplon.gamebotsback.persistance.repository.conversation;

import co.simplon.gamebotsback.persistance.entity.Conversation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IConversationRepository extends JpaRepository<Conversation, Integer> {

    /**
     * Retrieves all conversations associated with a specific user ID.
     *
     * @param idUser The ID of the user.
     * @return A list of conversations associated with the specified user ID.
     */
    @Query(ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID)
    List<Conversation> getAllUserConversation(final int idUser);

}
