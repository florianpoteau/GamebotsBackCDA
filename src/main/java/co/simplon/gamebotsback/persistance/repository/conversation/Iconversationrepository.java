package co.simplon.gamebotsback.persistance.repository.conversation;

import co.simplon.gamebotsback.persistance.entity.Conversation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for managing
 * Conversation entities in the persistence layer.
 * This interface extends JpaRepository, providing access
 * to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Conversation entities.
 */
public interface Iconversationrepository extends
    JpaRepository<Conversation, Integer> {

  /**
   * Retrieves all conversations associated with a specific user ID.
   *
   * @param idUser
   *     The ID of the user.
   *
   * @return A list of conversations associated with the specified user ID.
   */
  @Query(ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID)
  List<Conversation> getAllUserConversation(int idUser);

  /**
   * Retrieves all conversations associated with a specific user ID and game ID.
   *
   * @param idUser
   *     The ID of the user.
   * @param idGame
   *     The ID of the game.
   *
   * @return A list of conversations
   *     associated with the specified user ID and game ID.
   */
  @Query(ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID)
  List<Conversation> getAllUserConversationByGameId(int idUser, int idGame);

}
