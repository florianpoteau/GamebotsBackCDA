package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageConvert {

    private static MessageConvert instance;

    private MessageConvert() {

    }

    public static MessageConvert getInstance() {
        if (instance == null)
            instance = new MessageConvert();
        return instance;
    }

    public MessageDTO convertEntitytoDto(final Message entity) {
        final MessageDTO dto = new MessageDTO();
        dto.setIdMessage(entity.getIdMessage());
        dto.setContent(entity.getContent());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());
        dto.setConversation(entity.getConversation());

        return dto;
    }

    public Message convertDtotoEntity(final MessageDTO dto) {
        final Message entity = new Message();
        entity.setIdMessage(dto.getIdMessage());
        entity.setContent(dto.getContent());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        entity.setConversation(dto.getConversation());

        return entity;
    }

    public List<Message> convertListDtotoListEntity(final List<MessageDTO> dtoList) {
        final List<Message> entityList = new ArrayList<>();
        for (MessageDTO dto : dtoList) {
            entityList.add(convertDtotoEntity(dto));
        }

        return entityList;
    }

    public List<MessageDTO> convertListEntitytoListDto(final List<Message> entityList) {
        final List<MessageDTO> dtoList = new ArrayList<>();
        for (Message entity : entityList) {
            dtoList.add(convertEntitytoDto(entity));
        }

        return dtoList;
    }
}
