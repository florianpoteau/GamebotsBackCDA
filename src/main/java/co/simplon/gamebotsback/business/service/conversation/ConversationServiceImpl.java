package co.simplon.gamebotsback.business.service.conversation;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.conversation.Iconversationrepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the <code>IConversationService</code> interface providing
 * functionalities for managing conversations.
 */
@Service
public class ConversationServiceImpl implements Iconversationservice {

  /**
   * Standard error message indicating that a conversation
   * with the specified ID does not exist.
   * Used for exceptions thrown when the
   * operation cannot be performed due to the absence
   * of the corresponding conversation.
   */
  public static final String ERRORMESSAGE = "The conversation with the "
      + "specified ID does not exist:";

  /**
   * The repository used to access conversation data.
   */
  private final Iconversationrepository conversationRepository;

  /**
   * Constructor for <code>ConversationServiceImpl</code>.
   *
   * @param repositoryConversation
   *     The repository used to access conversation
   *     data.
   */
  @Autowired
  public ConversationServiceImpl(
      final Iconversationrepository repositoryConversation) {
    this.conversationRepository = repositoryConversation;
  }

  /**
   * Adds a new conversation.
   *
   * @param conversationDto
   *     The information of the new conversation to add.
   */
  @Override
  public Conversationdto addNewConversation(final Conversationdto conversationDto) {
    conversationDto.setCreationDate(new Date());
    Conversation savedConversationEntity = conversationRepository.save(
        ConversationConvert.getInstance().convertDtoToEntity(conversationDto));

    conversationDto.setIdConversation(savedConversationEntity.getIdConversation());
    return conversationDto;
  }

  /**
   * Retrieves information about a conversation based on its ID.
   *
   * @param conversationId
   *     The ID of the conversation.
   *
   * @return The information of the conversation corresponding to the given ID.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public Conversationdto getConversationByConversationId(
      final int conversationId) {
    Optional<Conversation> optionalGame = conversationRepository.findById(
        conversationId);
    if (optionalGame.isPresent()) {
      Conversation conversation = optionalGame.get();
      return ConversationConvert.getInstance().convertEntityToDto(conversation);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + conversationId);
    }
  }

  /**
   * Modifies information of an existing conversation.
   *
   * @param conversationId
   *     The ID of the conversation to modify.
   * @param conversationDto
   *     The new information to associate with the
   *     conversation.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public void modifyConversation(
      final int conversationId, final Conversationdto conversationDto) {
    Optional<Conversation> optionalConversation =
        conversationRepository.findById(conversationId);
    if (optionalConversation.isPresent()) {
      Conversation existingConversation = optionalConversation.get();

      User existingUser = existingConversation.getUser();
      conversationDto.setUser(existingUser);

      Game existingGame = existingConversation.getGame();
      conversationDto.setGame(existingGame);

      existingConversation.setName(conversationDto.getName());
      existingConversation.setModificationDate(
          new Date());

      conversationRepository.save(existingConversation);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + conversationId);
    }
  }

  /**
   * Deletes an existing conversation.
   *
   * @param conversationId
   *     The ID of the conversation to delete.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public void deleteConversation(final int conversationId) {
    Optional<Conversation> optionalConversation =
        conversationRepository.findById(conversationId);
    if (optionalConversation.isPresent()) {
      conversationRepository.deleteById(conversationId);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + conversationId);
    }
  }

  /**
   * Retrieves all conversations of a specific user.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return A list of conversations of the specified user.
   */
  @Override
  public List<Conversationdto> getAllUserConversations(
      final int userId) {
    final List<Conversation> result =
        conversationRepository.getAllUserConversation(userId);
    return ConversationConvert.getInstance().convertListEntityToListDto(result);
  }

  /**
   * Retrieves all conversations associated with
   * a specific user and a specific game.
   *
   * @param userId
   *     The ID of the user.
   * @param gameId
   *     The ID of the game.
   *
   * @return A list of conversations associated with
   *     the specified user and game.
   */
  @Override
  public List<Conversationdto> getAllUserConversationsByGameId(
      final int userId, final int gameId) {
    final List<Conversation> result =
        conversationRepository.getAllUserConversationByGameId(userId, gameId);
    return ConversationConvert.getInstance().convertListEntityToListDto(result);
  }

}
