package co.simplon.gamebotsback.business.service.conversation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.repository.conversation.IConversationRepository;
import jakarta.persistence.EntityNotFoundException;

public class ConversationServiceImpl implements IConversationService {

    private IConversationRepository conversationRepository;

    @Autowired
    public ConversationServiceImpl(IConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public void addNewConversation(ConversationDTO conversationDTO) {
        conversationRepository.save(ConversationConvert.getInstance().convertDtoToEntity(conversationDTO));
    }

    @Override
    public ConversationDTO getById(int id) {
        Optional<Conversation> optionalGame = conversationRepository.findById(id);
        Conversation conversation = optionalGame.get();
        return ConversationConvert.getInstance().convertEntityToDto(conversation);
    }

    @Override
    public ConversationDTO modifyConversation(int id, ConversationDTO conversationDTO) {
        Optional<Conversation> optionalUser = conversationRepository.findById(id);
        if (optionalUser.isPresent()) {
            Conversation existingConversation = optionalUser.get();
            existingConversation.setName(conversationDTO.getName());
            existingConversation.setGame(conversationDTO.getGame());
            existingConversation.setUser(conversationDTO.getUser());
            existingConversation.setCreationDate(conversationDTO.getCreationDate());
            existingConversation.setModificationDate(conversationDTO.getModificationDate());

            Conversation updatedConversation = conversationRepository.save(existingConversation);

            return ConversationConvert.getInstance().convertEntityToDto(updatedConversation);
        } else {
            throw new EntityNotFoundException("The conversation does not exist: " + id);
        }
    }

    @Override
    public void deleteConversation(int id) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(id);
        if (optionalConversation.isPresent()) {
            conversationRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("La conversation n'existe pas " + id);
        }
    }

    @Override
    public List<ConversationDTO> getAllUserConversation(int idUser) {
        final List<Conversation> result = conversationRepository.getAllUserConversation(idUser);
        return ConversationConvert.getInstance().convertListEntityToListDto(result);
    }

}
