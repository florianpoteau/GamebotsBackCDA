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
  public void addNewConversation(final Conversationdto conversationDto) {
    conversationDto.setCreationDate(new Date());
    conversationRepository.save(
        ConversationConvert.getInstance().convertDtoToEntity(conversationDto));
  }

  /**
   * Retrieves information about a conversation based on its ID.
   *
   * @param id
   *     The ID of the conversation.
   *
   * @return The information of the conversation corresponding to the given ID.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public Conversationdto getById(final int id) {
    Optional<Conversation> optionalGame = conversationRepository.findById(id);
    if (optionalGame.isPresent()) {
      Conversation conversation = optionalGame.get();
      return ConversationConvert.getInstance().convertEntityToDto(conversation);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

  /**
   * Modifies information of an existing conversation.
   *
   * @param id
   *     The ID of the conversation to modify.
   * @param conversationDto
   *     The new information to associate with the
   *     conversation.
   *
   * @return The updated information of the conversation.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public Conversationdto modifyConversation(
      final int id, final Conversationdto conversationDto) {
    Optional<Conversation> optionalConversation =
        conversationRepository.findById(id);
    if (optionalConversation.isPresent()) {
      Conversation existingConversation = optionalConversation.get();

      User existingUser = existingConversation.getUser();
      conversationDto.setUser(existingUser);

      Game existingGame = existingConversation.getGame();
      conversationDto.setGame(existingGame);

      existingConversation.setName(conversationDto.getName());
      existingConversation.setModificationDate(
          new Date());

      Conversation updatedConversation =
          conversationRepository.save(existingConversation);

      return ConversationConvert.getInstance().convertEntityToDto(
          updatedConversation);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

  /**
   * Deletes an existing conversation.
   *
   * @param id
   *     The ID of the conversation to delete.
   *
   * @throws EntityNotFoundException
   *     if the conversation with the specified ID
   *     does not exist.
   */
  @Override
  public void deleteConversation(final int id) {
    Optional<Conversation> optionalConversation =
        conversationRepository.findById(id);
    if (optionalConversation.isPresent()) {
      conversationRepository.deleteById(id);
    } else {
      throw new EntityNotFoundException(ERRORMESSAGE + id);
    }
  }

  /**
   * Retrieves all conversations of a specific user.
   *
   * @param idUser
   *     The ID of the user.
   *
   * @return A list of conversations of the specified user.
   */
  @Override
  public List<Conversationdto> getAllUserConversation(
      final int idUser) {
    final List<Conversation> result =
        conversationRepository.getAllUserConversation(idUser);
    return ConversationConvert.getInstance().convertListEntityToListDto(result);
  }

  /**
   * Retrieves all conversations associated with
   * a specific user and a specific game.
   *
   * @param idUser
   *     The ID of the user.
   * @param idGame
   *     The ID of the game.
   *
   * @return A list of conversations associated with
   *     the specified user and game.
   */
  @Override
  public List<Conversationdto> getAllUserConversationByGameId(
      final int idUser, final int idGame) {
    final List<Conversation> result =
        conversationRepository.getAllUserConversationByGameId(idUser, idGame);
    return ConversationConvert.getInstance().convertListEntityToListDto(result);
  }

}
