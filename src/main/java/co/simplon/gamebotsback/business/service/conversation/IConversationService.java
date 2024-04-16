package co.simplon.gamebotsback.business.service.conversation;

import java.util.List;

import co.simplon.gamebotsback.business.dto.ConversationDTO;

public interface IConversationService {

    void addNewConversation(final ConversationDTO conversationDTO);

    ConversationDTO getById(final int id);

    ConversationDTO modifyConversation(final int id, ConversationDTO conversationDTO);

    void deleteConversation(final int id);

    List<ConversationDTO> getAllUserConversation(final int idUser);

}
