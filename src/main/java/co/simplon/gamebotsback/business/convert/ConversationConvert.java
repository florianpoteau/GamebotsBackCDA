package co.simplon.gamebotsback.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;

public class ConversationConvert {

    private static ConversationConvert instance;

    private ConversationConvert() {

    }

    public static ConversationConvert getInstance() {
        if (instance == null)
            instance = new ConversationConvert();
        return instance;
    }

    public ConversationDTO convertEntityToDto(final Conversation entity) {
        final ConversationDTO dto = new ConversationDTO();
        dto.setIdConversation(entity.getIdConversation());
        dto.setName(entity.getName());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());
        dto.setGame(entity.getGame());
        dto.setUser(entity.getUser());

        return dto;
    }

    public Conversation convertDtoToEntity(final ConversationDTO dto) {
        final Conversation entity = new Conversation();
        entity.setIdConversation(dto.getIdConversation());
        entity.setName(dto.getName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        entity.setGame(dto.getGame());
        entity.setUser(dto.getUser());
        return entity;
    }

    public List<Conversation> convertListDtotoListEntity(final List<ConversationDTO> dtoList) {
        final List<Conversation> entityList = new ArrayList<>();
        for (ConversationDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<ConversationDTO> convertListEntitytoListDto(final List<Conversation> entityList) {
        final List<ConversationDTO> dtoList = new ArrayList<>();
        for (Conversation entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }

}
