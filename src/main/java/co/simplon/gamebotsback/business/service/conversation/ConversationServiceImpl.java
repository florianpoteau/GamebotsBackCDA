/**
 * Implementation of the <code>IConversationService</code> interface providing functionalities for managing conversations.
 * This includes adding, retrieving, modifying, and deleting conversations, as well as retrieving all conversations associated with a specific user.
 */
package co.simplon.gamebotsback.business.service.conversation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.conversation.IConversationRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * Implementation of the <code>IConversationService</code> interface providing
 * functionalities for managing conversations.
 */
@Service
public class ConversationServiceImpl implements IConversationService {

    private final IConversationRepository conversationRepository;

    private static final String ERRORMESSAGE = "The conversation with the specified ID does not exist:";

    /**
     * Constructor for <code>ConversationServiceImpl</code>.
     *
     * @param conversationRepository The repository used to access conversation
     *                               data.
     */
    @Autowired
    public ConversationServiceImpl(IConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    /**
     * Adds a new conversation.
     *
     * @param conversationDTO The information of the new conversation to add.
     */
    @Override
    public void addNewConversation(ConversationDTO conversationDTO) {
        conversationRepository.save(ConversationConvert.getInstance().convertDtoToEntity(conversationDTO));
    }

    /**
     * Retrieves information about a conversation based on its ID.
     *
     * @param id The ID of the conversation.
     * @return The information of the conversation corresponding to the given ID.
     * @throws EntityNotFoundException if the conversation with the specified ID
     *                                 does not exist.
     */
    @Override
    public ConversationDTO getById(int id) {
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
     * @param id              The ID of the conversation to modify.
     * @param conversationDTO The new information to associate with the
     *                        conversation.
     * @return The updated information of the conversation.
     * @throws EntityNotFoundException if the conversation with the specified ID
     *                                 does not exist.
     */
    @Override
    public ConversationDTO modifyConversation(int id, ConversationDTO conversationDTO) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(id);
        if (optionalConversation.isPresent()) {
            Conversation existingConversation = optionalConversation.get();

            // Récupérer l'utilisateur existant et réattribuer à la conversation existante
            User existingUser = existingConversation.getUser();
            conversationDTO.setUser(existingUser);

            // Récupérer le jeu existant et réattribuer à la conversation existante
            Game existingGame = existingConversation.getGame();
            conversationDTO.setGame(existingGame);

            existingConversation.setName(conversationDTO.getName());
            existingConversation.setCreationDate(conversationDTO.getCreationDate());
            existingConversation.setModificationDate(conversationDTO.getModificationDate());

            Conversation updatedConversation = conversationRepository.save(existingConversation);

            return ConversationConvert.getInstance().convertEntityToDto(updatedConversation);
        } else {
            throw new EntityNotFoundException(ERRORMESSAGE + id);
        }
    }

    /**
     * Deletes an existing conversation.
     *
     * @param id The ID of the conversation to delete.
     * @throws EntityNotFoundException if the conversation with the specified ID
     *                                 does not exist.
     */
    @Override
    public void deleteConversation(int id) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(id);
        if (optionalConversation.isPresent()) {
            conversationRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(ERRORMESSAGE + id);
        }
    }

    /**
     * Retrieves all conversations of a specific user.
     *
     * @param idUser The ID of the user.
     * @return A list of conversations of the specified user.
     */
    @Override
    public List<ConversationDTO> getAllUserConversation(int idUser) {
        final List<Conversation> result = conversationRepository.getAllUserConversation(idUser);
        return ConversationConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public List<ConversationDTO> getAllUserConversationByGameId(int idUser, int idGame) {
        final List<Conversation> result = conversationRepository.getAllUserConversationByGameId(idUser, idGame);
        return ConversationConvert.getInstance().convertListEntityToListDto(result);
    }

}
