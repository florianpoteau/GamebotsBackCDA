package co.simplon.gamebotsback.business.service.conversation;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import java.util.List;

/**
 * The <code>IConversationService</code> interface provides methods for
 * managing conversations.
 * This includes adding, retrieving, modifying, and
 * deleting conversations, as well as
 * retrieving all conversations associated with a specific user.
 */
public interface Iconversationservice {

  /**
   * Adds a new conversation.
   *
   * @param conversationDto
   *     The conversation DTO object containing information
   *     about the conversation.
   */
  Conversationdto addNewConversation(Conversationdto conversationDto);

  /**
   * Retrieves a conversation by its ID.
   *
   * @param conversationId
   *     The ID of the conversation to retrieve.
   *
   * @return The conversation DTO object corresponding to the provided ID,
   *     or null
   *     if not found.
   */
  Conversationdto getConversationByConversationId(int conversationId);

  /**
   * Modifies an existing conversation.
   *
   * @param conversationId
   *     The ID of the conversation to modify.
   * @param conversationDto
   *     The modified conversation DTO object.
   */
  void modifyConversation(int conversationId, Conversationdto conversationDto);

  /**
   * Deletes a conversation by its ID.
   *
   * @param conversationId
   *     The ID of the conversation to delete.
   */
  void deleteConversation(int conversationId);

  /**
   * Retrieves all conversations associated with a specific user.
   *
   * @param userId
   *     The ID of the user whose conversations are to be retrieved.
   *
   * @return A list of conversation DTO objects associated with the specified
   *     user.
   */
  List<Conversationdto> getAllUserConversations(int userId);

  /**
   * Retrieves all conversations associated with a specific user and game.
   *
   * @param userId
   *     The ID of the user whose conversations are to be retrieved.
   * @param gameId
   *     The ID of the game associated with the conversations.
   *
   * @return A list of conversation DTO objects associated with the specified
   *     user and game.
   */
  List<Conversationdto> getAllUserConversationsByGameId(int userId, int gameId);
}
