package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the ConversationConvert class.
 */
class ConversationConvertTest {

    private static final ConversationConvert conversationConvert = ConversationConvert.getInstance();

    /**
     * Tests the conversion of a Conversation entity to a ConversationDTO.
     */
    @Test
    void testConvertConversationToConversationDTO() {
        Conversation conversation = new Conversation();
        conversation.setIdConversation(1);
        conversation.setName("Comment tuer des mangeurs d'hommes ?");
        Date creationDate = new Date();
        conversation.setCreationDate(creationDate);
        conversation.setModificationDate(null);
        conversation.setGame(null);
        conversation.setUser(null);

        ConversationDTO conversationDTO = conversationConvert.convertEntityToDto(conversation);

        assertSame(1, conversationDTO.getIdConversation());
        assertSame("Comment tuer des mangeurs d'hommes ?", conversationDTO.getName());
        assertSame(creationDate, conversationDTO.getCreationDate());
        assertNull(conversationDTO.getModificationDate());
        assertNull(conversationDTO.getGame());
        assertNull(conversationDTO.getUser());
    }

    /**
     * Tests the conversion of a ConversationDTO to a Conversation entity.
     */
    @Test
    void testConvertConversationDTOToConversation() {
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setIdConversation(1);
        conversationDTO.setName("Comment tuer des mangeurs d'hommes ?");
        Date creationDate = new Date();
        conversationDTO.setCreationDate(creationDate);
        conversationDTO.setModificationDate(null);
        conversationDTO.setGame(null);
        conversationDTO.setUser(null);

        Conversation conversation = conversationConvert.convertDtoToEntity(conversationDTO);

        assertSame(1, conversation.getIdConversation());
        assertSame("Comment tuer des mangeurs d'hommes ?", conversation.getName());
        assertSame(creationDate, conversation.getCreationDate());
        assertNull(conversation.getModificationDate());
        assertNull(conversation.getGame());
        assertNull(conversation.getUser());
    }

    /**
     * Tests the conversion of a List Conversation entity to a List ConversationDTO.
     */
    @Test
    void testConvertListConversationToListConversationDTO() {
        Conversation conversation = new Conversation();
        conversation.setIdConversation(1);
        conversation.setName("Comment tuer des mangeurs d'hommes ?");
        Date creationDate = new Date();
        conversation.setCreationDate(creationDate);
        conversation.setModificationDate(null);
        conversation.setGame(null);
        conversation.setUser(null);

        Conversation conversation2 = new Conversation();
        conversation2.setIdConversation(2);
        conversation2.setName("Comment tuer des mangeuses d'hommes ?");
        Date creationDate2 = new Date();
        conversation2.setCreationDate(creationDate2);
        conversation2.setModificationDate(null);
        conversation2.setGame(null);
        conversation2.setUser(null);

        List<Conversation> conversationList = List.of(conversation, conversation2);

        List<ConversationDTO> conversationDTOList = conversationConvert.convertListEntityToListDto(conversationList);

        assertSame(ConversationDTO.class, conversationDTOList.get(0).getClass());
        assertSame(1, conversationDTOList.get(0).getIdConversation());
        assertSame(2, conversationDTOList.get(1).getIdConversation());
        assertSame("Comment tuer des mangeurs d'hommes ?", conversationDTOList.get(0).getName());
        assertSame("Comment tuer des mangeuses d'hommes ?", conversationDTOList.get(1).getName());
        assertSame(creationDate, conversationDTOList.get(0).getCreationDate());
        assertSame(creationDate2, conversationDTOList.get(1).getCreationDate());
        assertNull(conversationDTOList.get(0).getModificationDate());
        assertNull(conversationDTOList.get(1).getModificationDate());
        assertNull(conversationDTOList.get(0).getGame());
        assertNull(conversationDTOList.get(1).getGame());
        assertNull(conversationDTOList.get(0).getUser());
        assertNull(conversationDTOList.get(1).getUser());
    }


    /**
     * Tests the conversion of a List ConversationDTO to a List Conversation entity.
     */
    @Test
    void testConvertListConversationDTOToListConversation() {
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setIdConversation(1);
        conversationDTO.setName("Comment tuer des mangeurs d'hommes ?");
        Date creationDate = new Date();
        conversationDTO.setCreationDate(creationDate);
        conversationDTO.setModificationDate(null);
        conversationDTO.setGame(null);
        conversationDTO.setUser(null);

        ConversationDTO conversationDTO2 = new ConversationDTO();
        conversationDTO2.setIdConversation(2);
        conversationDTO2.setName("Comment tuer des mangeuses d'hommes ?");
        Date creationDate2 = new Date();
        conversationDTO2.setCreationDate(creationDate2);
        conversationDTO2.setModificationDate(null);
        conversationDTO2.setGame(null);
        conversationDTO2.setUser(null);

        List<ConversationDTO> conversationDTOList = List.of(conversationDTO, conversationDTO2);

        List<Conversation> conversationList = conversationConvert.convertListDtoToListEntity(conversationDTOList);

        assertSame(Conversation.class, conversationList.get(0).getClass());
        assertSame(1, conversationList.get(0).getIdConversation());
        assertSame(2, conversationList.get(1).getIdConversation());
        assertSame("Comment tuer des mangeurs d'hommes ?", conversationList.get(0).getName());
        assertSame("Comment tuer des mangeuses d'hommes ?", conversationList.get(1).getName());
        assertSame(creationDate, conversationList.get(0).getCreationDate());
        assertSame(creationDate2, conversationList.get(1).getCreationDate());
        assertNull(conversationList.get(0).getModificationDate());
        assertNull(conversationList.get(1).getModificationDate());
        assertNull(conversationList.get(0).getGame());
        assertNull(conversationList.get(1).getGame());
        assertNull(conversationList.get(0).getUser());
        assertNull(conversationList.get(1).getUser());
    }
}
