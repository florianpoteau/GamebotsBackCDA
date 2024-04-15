/**
 * This class provides methods to convert between ConversationDTO objects and Conversation entities.
 */
package co.simplon.gamebotsback.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;

public class ConversationConvert {

    private static ConversationConvert instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private ConversationConvert() {
    }

    /**
     * Returns the singleton instance of ConversationConvert.
     *
     * @return the singleton instance of ConversationConvert
     */
    public static ConversationConvert getInstance() {
        if (instance == null)
            instance = new ConversationConvert();
        return instance;
    }

    /**
     * Converts a Conversation entity to a ConversationDTO.
     *
     * @param entity the Conversation entity to convert
     * @return the converted ConversationDTO
     */
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

    /**
     * Converts a ConversationDTO to a Conversation entity.
     *
     * @param dto the ConversationDTO to convert
     * @return the converted Conversation entity
     */
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

    /**
     * Converts a list of ConversationDTO objects to a list of Conversation
     * entities.
     *
     * @param dtoList the list of ConversationDTO objects to convert
     * @return the list of converted Conversation entities
     */
    public List<Conversation> convertListDtoToListEntity(final List<ConversationDTO> dtoList) {
        final List<Conversation> entityList = new ArrayList<>();
        for (ConversationDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    /**
     * Converts a list of Conversation entities to a list of ConversationDTO
     * objects.
     *
     * @param entityList the list of Conversation entities to convert
     * @return the list of converted ConversationDTO objects
     */
    public List<ConversationDTO> convertListEntityToListDto(final List<Conversation> entityList) {
        final List<ConversationDTO> dtoList = new ArrayList<>();
        for (Conversation entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }
}