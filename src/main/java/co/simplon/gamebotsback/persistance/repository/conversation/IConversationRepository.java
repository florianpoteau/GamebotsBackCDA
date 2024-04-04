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
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConversationRepository extends JpaRepository<Conversation, Integer> {
}
