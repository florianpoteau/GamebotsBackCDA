package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.MessageConvert;
import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.entity.Message;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class MessageConvertTest {

    private static final MessageConvert messageConvert = MessageConvert.getInstance();

    private static final String content = "Hello World";

    private Message createSampleMessage() {

        Message message = new Message();

        message.setIdMessage(1);
        message.setContent(content);
        message.setCreationDate(new Date());
        message.setModificationDate(new Date());
        message.setConversation(new Conversation());

        return message;
    }

    private Message createSampleMessageWithNull() {

        Message message = new Message();

        message.setIdMessage(1);
        message.setContent(null);
        message.setCreationDate(null);
        message.setModificationDate(null);
        message.setConversation(null);

        return message;
    }

    private MessageDTO createSampleMessageDTO() {

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setIdMessage(1);
        messageDTO.setContent(content);
        messageDTO.setCreationDate(new Date());
        messageDTO.setModificationDate(new Date());
        messageDTO.setConversation(new Conversation());

        return messageDTO;
    }

    private MessageDTO createSampleMessageDTOWithNull() {

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setIdMessage(1);
        messageDTO.setContent(null);
        messageDTO.setCreationDate(null);
        messageDTO.setModificationDate(null);
        messageDTO.setConversation(null);

        return messageDTO;
    }

    @Test
    void testGetInstanceReturnsInstanceOfMessageConvert() {

        MessageConvert messageConvert = MessageConvert.getInstance();

        assertNotNull(messageConvert);
        assertInstanceOf(MessageConvert.class, messageConvert);
    }

    @Test
    void testConvertMessageToMessageDTO() {

        Message message = createSampleMessage();
        MessageDTO messageDTO = messageConvert.convertEntityToDto(message);

        assertSame(1, messageDTO.getIdMessage());
        assertSame(content, messageDTO.getContent());
        assertSame(message.getCreationDate(), messageDTO.getCreationDate());
        assertSame(message.getModificationDate(), messageDTO.getModificationDate());
        assertSame(message.getConversation(), messageDTO.getConversation());
    }

    @Test
    void testConvertMessageToMessageDTOWithNull() {

        Message message = createSampleMessageWithNull();
        MessageDTO messageDTO = messageConvert.convertEntityToDto(message);

        assertSame(1, messageDTO.getIdMessage());
        assertNull(messageDTO.getContent());
        assertNull(messageDTO.getCreationDate());
        assertNull(messageDTO.getModificationDate());
        assertNull(messageDTO.getConversation());
    }

    @Test
    void testConvertMessageDTOToMessage() {

        MessageDTO messageDTO = createSampleMessageDTO();
        Message message = messageConvert.convertDtoToEntity(messageDTO);

        assertSame(1, message.getIdMessage());
        assertSame(content, message.getContent());
        assertSame(messageDTO.getCreationDate(), message.getCreationDate());
        assertSame(messageDTO.getModificationDate(), message.getModificationDate());
        assertSame(messageDTO.getConversation(), message.getConversation());
    }

    @Test
    void testConvertMessageDTOToMessageWithNull() {

        MessageDTO messageDTO = createSampleMessageDTOWithNull();
        Message message = messageConvert.convertDtoToEntity(messageDTO);

        assertSame(1, message.getIdMessage());
        assertNull(message.getContent());
        assertNull(message.getCreationDate());
        assertNull(message.getModificationDate());
        assertNull(message.getConversation());
    }

    @Test
    void testConvertListMessageToListMessageDTO() {

        List<Message> messageList = List.of(createSampleMessage(), createSampleMessage());
        List<MessageDTO> messageDTOList = messageConvert.convertListEntityToListDto(messageList);

        assertSame(1, messageDTOList.get(0).getIdMessage());
        assertSame(1, messageDTOList.get(1).getIdMessage());
        assertSame(content, messageDTOList.get(0).getContent());
        assertSame(content, messageDTOList.get(1).getContent());
        assertSame(messageList.get(0).getCreationDate(), messageDTOList.get(0).getCreationDate());
        assertSame(messageList.get(1).getCreationDate(), messageDTOList.get(1).getCreationDate());
        assertSame(messageList.get(0).getModificationDate(), messageDTOList.get(0).getModificationDate());
        assertSame(messageList.get(1).getModificationDate(), messageDTOList.get(1).getModificationDate());
        assertSame(messageList.get(0).getConversation(), messageDTOList.get(0).getConversation());
        assertSame(messageList.get(1).getConversation(), messageDTOList.get(1).getConversation());
    }

    @Test
    void testConvertListMessageToListMessageDTOWithNull() {

        List<Message> messageList = List.of(createSampleMessageWithNull(), createSampleMessageWithNull());
        List<MessageDTO> messageDTOList = messageConvert.convertListEntityToListDto(messageList);

        assertSame(1, messageDTOList.get(0).getIdMessage());
        assertSame(1, messageDTOList.get(1).getIdMessage());
        assertNull(messageDTOList.get(0).getContent());
        assertNull(messageDTOList.get(1).getContent());
        assertNull(messageDTOList.get(0).getCreationDate());
        assertNull(messageDTOList.get(1).getCreationDate());
        assertNull(messageDTOList.get(0).getModificationDate());
        assertNull(messageDTOList.get(1).getModificationDate());
        assertNull(messageDTOList.get(0).getConversation());
        assertNull(messageDTOList.get(1).getConversation());
    }

    @Test
    void testConvertListMessageDTOToListMessage() {

        List<MessageDTO> messageDTOList = List.of(createSampleMessageDTO(), createSampleMessageDTO());
        List<Message> messageList = messageConvert.convertListDtoToListEntity(messageDTOList);

        assertSame(1, messageList.get(0).getIdMessage());
        assertSame(1, messageList.get(1).getIdMessage());
        assertSame(content, messageList.get(0).getContent());
        assertSame(content, messageList.get(1).getContent());
        assertSame(messageDTOList.get(0).getCreationDate(), messageList.get(0).getCreationDate());
        assertSame(messageDTOList.get(1).getCreationDate(), messageList.get(1).getCreationDate());
        assertSame(messageDTOList.get(0).getModificationDate(), messageList.get(0).getModificationDate());
        assertSame(messageDTOList.get(1).getModificationDate(), messageList.get(1).getModificationDate());
        assertSame(messageDTOList.get(0).getConversation(), messageList.get(0).getConversation());
        assertSame(messageDTOList.get(1).getConversation(), messageList.get(1).getConversation());
    }

    @Test
    void testConvertListMessageDTOToListMessageWithNull() {

        List<MessageDTO> messageDTOList = List.of(createSampleMessageDTOWithNull(), createSampleMessageDTOWithNull());
        List<Message> messageList = messageConvert.convertListDtoToListEntity(messageDTOList);

        assertSame(1, messageList.get(0).getIdMessage());
        assertSame(1, messageList.get(1).getIdMessage());
        assertNull(messageList.get(0).getContent());
        assertNull(messageList.get(1).getContent());
        assertNull(messageList.get(0).getCreationDate());
        assertNull(messageList.get(1).getCreationDate());
        assertNull(messageList.get(0).getModificationDate());
        assertNull(messageList.get(1).getModificationDate());
        assertNull(messageList.get(0).getConversation());
        assertNull(messageList.get(1).getConversation());
    }
}
