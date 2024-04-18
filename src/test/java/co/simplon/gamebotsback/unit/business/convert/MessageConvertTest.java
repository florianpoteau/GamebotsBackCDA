package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.MessageConvert;
import co.simplon.gamebotsback.business.dto.MessageDTO;
import co.simplon.gamebotsback.persistance.entity.Message;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit test for the MessageConvert class.
 */
class MessageConvertTest {

    private static final MessageConvert messageConvert = MessageConvert.getInstance();

    /**
     * Tests the conversion of a Message entity to a MessageDTO.
     */
    @Test
    void testConvertMessageToMessageDTO() {
        Message message = new Message();
        message.setIdMessage(1);
        message.setContent("Hello World");
        Date creationDate = new Date();
        message.setCreationDate(creationDate);
        message.setModificationDate(null);
        message.setConversation(null);

        MessageDTO messageDTO = messageConvert.convertEntityToDto(message);

        assertSame(1, messageDTO.getIdMessage());
        assertSame("Hello World", messageDTO.getContent());
        assertSame(creationDate, messageDTO.getCreationDate());
        assertNull(messageDTO.getModificationDate());
        assertNull(messageDTO.getConversation());
    }

    /**
     * Tests the conversion of a MessageDTO to a Message entity.
     */
    @Test
    void testConvertMessageDTOToMessage() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setIdMessage(1);
        messageDTO.setContent("Hello World");
        Date creationDate = new Date();
        messageDTO.setCreationDate(creationDate);
        messageDTO.setModificationDate(null);
        messageDTO.setConversation(null);

        Message message = messageConvert.convertDtoToEntity(messageDTO);

        assertSame(1, message.getIdMessage());
        assertSame("Hello World", message.getContent());
        assertSame(creationDate, message.getCreationDate());
        assertNull(message.getModificationDate());
        assertNull(message.getConversation());
    }

    /**
     * Tests the conversion of a List Message entity to a List MessageDTO.
     */
    @Test
    void testConvertListMessageToListMessageDTO() {
        Message message = new Message();
        message.setIdMessage(1);
        message.setContent("Hello World");
        Date creationDate = new Date();
        message.setCreationDate(creationDate);
        message.setModificationDate(null);
        message.setConversation(null);

        Message message2 = new Message();
        message2.setIdMessage(2);
        message2.setContent("Code");
        Date creationDate2 = new Date();
        message2.setCreationDate(creationDate2);
        message2.setModificationDate(null);
        message2.setConversation(null);

        List<Message> messageList = List.of(message, message2);

        List<MessageDTO> messageDTOList = messageConvert.convertListEntityToListDto(messageList);

        assertSame(1, messageDTOList.get(0).getIdMessage());
        assertSame(2, messageDTOList.get(1).getIdMessage());
        assertSame("Hello World", messageDTOList.get(0).getContent());
        assertSame("Code", messageDTOList.get(1).getContent());
        assertSame(creationDate, messageDTOList.get(0).getCreationDate());
        assertSame(creationDate2, messageDTOList.get(1).getCreationDate());
        assertNull(messageDTOList.get(0).getModificationDate());
        assertNull(messageDTOList.get(1).getModificationDate());
        assertNull(messageDTOList.get(0).getConversation());
        assertNull(messageDTOList.get(1).getConversation());
    }

    /**
     * Tests the conversion of a List MessageDTO to a List Message entity.
     */
    @Test
    void testConvertListMessageDTOToListMessage() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setIdMessage(1);
        messageDTO.setContent("Hello World");
        Date creationDate = new Date();
        messageDTO.setCreationDate(creationDate);
        messageDTO.setModificationDate(null);
        messageDTO.setConversation(null);

        MessageDTO messageDTO2 = new MessageDTO();
        messageDTO2.setIdMessage(2);
        messageDTO2.setContent("Code");
        Date creationDate2 = new Date();
        messageDTO2.setCreationDate(creationDate2);
        messageDTO2.setModificationDate(null);
        messageDTO2.setConversation(null);

        List<MessageDTO> messageDTOList = List.of(messageDTO, messageDTO2);

        List<Message> messageList = messageConvert.convertListDtoToListEntity(messageDTOList);

        assertSame(1, messageList.get(0).getIdMessage());
        assertSame(2, messageList.get(1).getIdMessage());
        assertSame("Hello World", messageList.get(0).getContent());
        assertSame("Code", messageList.get(1).getContent());
        assertSame(creationDate, messageList.get(0).getCreationDate());
        assertSame(creationDate2, messageList.get(1).getCreationDate());
        assertNull(messageList.get(0).getModificationDate());
        assertNull(messageList.get(1).getModificationDate());
        assertNull(messageList.get(0).getConversation());
        assertNull(messageList.get(1).getConversation());
    }
}
