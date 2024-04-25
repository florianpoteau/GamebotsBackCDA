/**
 * The <code>IConversationService</code> interface provides methods for managing conversations.
 * This includes adding, retrieving, modifying, and deleting conversations, as well as
 * retrieving all conversations associated with a specific user.
 */
package co.simplon.gamebotsback.business.service.conversation;

import java.util.List;

import co.simplon.gamebotsback.business.dto.Conversationdto;

public interface IConversationService {

  /**
   * Adds a new conversation.
   *
   * @param conversationDTO The conversation DTO object containing information
   *                        about the conversation.
   */
  void addNewConversation(final Conversationdto conversationDTO);

  /**
   * Retrieves a conversation by its ID.
   *
   * @param id The ID of the conversation to retrieve.
   * @return The conversation DTO object corresponding to the provided ID, or null
   * if not found.
   */
  Conversationdto getById(final int id);

  /**
   * Modifies an existing conversation.
   *
   * @param id              The ID of the conversation to modify.
   * @param conversationDTO The modified conversation DTO object.
   * @return The modified conversation DTO object.
   */
  Conversationdto modifyConversation(final int id, Conversationdto conversationDTO);

  /**
   * Deletes a conversation by its ID.
   *
   * @param id The ID of the conversation to delete.
   */
  void deleteConversation(final int id);

  /**
   * Retrieves all conversations associated with a specific user.
   *
   * @param idUser The ID of the user whose conversations are to be retrieved.
   * @return A list of conversation DTO objects associated with the specified
   * user.
   */
  List<Conversationdto> getAllUserConversation(final int idUser);

  List<Conversationdto> getAllUserConversationByGameId(final int idUser, final int idGame);
}
