/**
 * This class provides methods to convert between MessageDTO objects and Message entities.
 */
package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageConvert {

    private static MessageConvert instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private MessageConvert() {
    }

    /**
     * Returns the singleton instance of MessageConvert.
     *
     * @return the singleton instance of MessageConvert
     */
    public static MessageConvert getInstance() {
        if (instance == null)
            instance = new MessageConvert();
        return instance;
    }

    /**
     * Converts a Message entity to a MessageDTO.
     *
     * @param entity the Message entity to convert
     * @return the converted MessageDTO
     */
    public MessageDTO convertEntityToDto(final Message entity) {
        final MessageDTO dto = new MessageDTO();
        dto.setIdMessage(entity.getIdMessage());
        dto.setContent(entity.getContent());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());
        dto.setConversation(entity.getConversation());

        return dto;
    }

    /**
     * Converts a MessageDTO to a Message entity.
     *
     * @param dto the MessageDTO to convert
     * @return the converted Message entity
     */
    public Message convertDtoToEntity(final MessageDTO dto) {
        final Message entity = new Message();
        entity.setIdMessage(dto.getIdMessage());
        entity.setContent(dto.getContent());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        entity.setConversation(dto.getConversation());

        return entity;
    }

    /**
     * Converts a list of MessageDTO objects to a list of Message entities.
     *
     * @param dtoList the list of MessageDTO objects to convert
     * @return the list of converted Message entities
     */
    public List<Message> convertListDtoToListEntity(final List<MessageDTO> dtoList) {
        final List<Message> entityList = new ArrayList<>();
        for (MessageDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }

        return entityList;
    }

    /**
     * Converts a list of Message entities to a list of MessageDTO objects.
     *
     * @param entityList the list of Message entities to convert
     * @return the list of converted MessageDTO objects
     */
    public List<MessageDTO> convertListEntityToListDto(final List<Message> entityList) {
        final List<MessageDTO> dtoList = new ArrayList<>();
        for (Message entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }

        return dtoList;
    }
}