package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversationConvertTest {

    private static final ConversationConvert conversationConvert = ConversationConvert.getInstance();

    private static final String NameConversation = "Comment tuer des mangeurs d'hommes ?";

    private Conversation createSampleConversation() {
        Conversation conversation = new Conversation();
        conversation.setIdConversation(1);
        conversation.setName(NameConversation);
        conversation.setCreationDate(new Date());
        conversation.setModificationDate(new Date());
        conversation.setGame(new Game());
        conversation.setUser(new User());
        return conversation;
    }

    private Conversation createSampleConversationWithNull() {
        Conversation conversation = new Conversation();
        conversation.setIdConversation(1);
        conversation.setName(null);
        conversation.setCreationDate(null);
        conversation.setModificationDate(null);
        conversation.setGame(null);
        conversation.setUser(null);
        return conversation;
    }

    private ConversationDTO createSampleConversationDTO() {
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setIdConversation(1);
        conversationDTO.setName(NameConversation);
        conversationDTO.setCreationDate(new Date());
        conversationDTO.setModificationDate(new Date());
        conversationDTO.setGame(new Game());
        conversationDTO.setUser(new User());
        return conversationDTO;
    }

    private ConversationDTO createSampleConversationDTOWithNull() {
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setIdConversation(1);
        conversationDTO.setName(null);
        conversationDTO.setCreationDate(null);
        conversationDTO.setModificationDate(null);
        conversationDTO.setGame(null);
        conversationDTO.setUser(null);
        return conversationDTO;
    }

    @Test
    void testConvertConversationToConversationDTO() {

        Conversation conversation = createSampleConversation();
        ConversationDTO conversationDTO = conversationConvert.convertEntityToDto(conversation);

        assertEquals(1, conversationDTO.getIdConversation());
        assertEquals(NameConversation, conversationDTO.getName());
        assertEquals(conversation.getCreationDate(), conversationDTO.getCreationDate());
        assertEquals(conversation.getModificationDate(), conversationDTO.getModificationDate());
        assertEquals(conversation.getGame(), conversationDTO.getGame());
        assertEquals(conversation.getUser(),conversationDTO.getUser());
    }

    @Test
    void testConvertConversationToConversationDTOWithNull() {

        Conversation conversation = createSampleConversationWithNull();
        ConversationDTO conversationDTO = conversationConvert.convertEntityToDto(conversation);

        assertEquals(1, conversationDTO.getIdConversation());
        assertNull(conversationDTO.getName());
        assertNull(conversationDTO.getCreationDate());
        assertNull(conversationDTO.getModificationDate());
        assertNull(conversationDTO.getGame());
        assertNull(conversationDTO.getUser());
    }

    @Test
    void testConvertConversationDTOToConversation() {

        ConversationDTO conversationDTO = createSampleConversationDTO();
        Conversation conversation = conversationConvert.convertDtoToEntity(conversationDTO);

        assertEquals(1, conversation.getIdConversation());
        assertEquals(NameConversation, conversation.getName());
        assertEquals(conversationDTO.getCreationDate(), conversation.getCreationDate());
        assertEquals(conversationDTO.getModificationDate() ,conversation.getModificationDate());
        assertEquals(conversationDTO.getGame(), conversation.getGame());
        assertEquals(conversationDTO.getUser(), conversation.getUser());
    }

    @Test
    void testConvertConversationDTOToConversationWithNull() {

        ConversationDTO conversationDTO = createSampleConversationDTOWithNull();
        Conversation conversation = conversationConvert.convertDtoToEntity(conversationDTO);

        assertEquals(1, conversation.getIdConversation());
        assertNull(conversation.getName());
        assertNull(conversation.getCreationDate());
        assertNull(conversation.getModificationDate());
        assertNull(conversation.getGame());
        assertNull(conversation.getUser());
    }

    @Test
    void testConvertListConversationToListConversationDTO() {

        List<Conversation> conversationList = List.of(createSampleConversation(), createSampleConversation());
        List<ConversationDTO> conversationDTOList = conversationConvert.convertListEntityToListDto(conversationList);

        assertEquals(ConversationDTO.class, conversationDTOList.get(0).getClass());
        assertEquals(1, conversationDTOList.get(0).getIdConversation());
        assertEquals(1, conversationDTOList.get(1).getIdConversation());
        assertEquals(NameConversation, conversationDTOList.get(0).getName());
        assertEquals(NameConversation, conversationDTOList.get(1).getName());
        assertEquals(conversationList.get(0).getCreationDate(), conversationDTOList.get(0).getCreationDate());
        assertEquals(conversationList.get(1).getCreationDate(), conversationDTOList.get(1).getCreationDate());
        assertEquals(conversationList.get(0).getModificationDate(), conversationDTOList.get(0).getModificationDate());
        assertEquals(conversationList.get(1).getModificationDate(), conversationDTOList.get(1).getModificationDate());
        assertEquals(conversationList.get(0).getGame(), conversationDTOList.get(0).getGame());
        assertEquals(conversationList.get(1).getGame(), conversationDTOList.get(1).getGame());
        assertEquals(conversationList.get(0).getUser(), conversationDTOList.get(0).getUser());
        assertEquals(conversationList.get(1).getUser(), conversationDTOList.get(1).getUser());
    }

    @Test
    void testConvertListConversationToListConversationDTOWithNull() {

        List<Conversation> conversationList = List.of(createSampleConversationWithNull(), createSampleConversationWithNull());
        List<ConversationDTO> conversationDTOList = conversationConvert.convertListEntityToListDto(conversationList);

        assertEquals(ConversationDTO.class, conversationDTOList.get(0).getClass());
        assertEquals(1, conversationDTOList.get(0).getIdConversation());
        assertEquals(1, conversationDTOList.get(1).getIdConversation());
        assertNull(conversationDTOList.get(0).getName());
        assertNull(conversationDTOList.get(1).getName());
        assertNull(conversationList.get(0).getCreationDate());
        assertNull(conversationList.get(1).getCreationDate());
        assertNull(conversationList.get(0).getModificationDate());
        assertNull(conversationList.get(1).getModificationDate());
        assertNull(conversationList.get(0).getGame());
        assertNull(conversationList.get(1).getGame());
        assertNull(conversationList.get(0).getUser());
        assertNull(conversationList.get(1).getUser());
    }

    @Test
    void testConvertListConversationDTOToListConversation() {

        List<ConversationDTO> conversationDTOList = List.of(createSampleConversationDTO(), createSampleConversationDTO());

        List<Conversation> conversationList = conversationConvert.convertListDtoToListEntity(conversationDTOList);

        assertEquals(Conversation.class, conversationList.get(0).getClass());
        assertEquals(1, conversationList.get(0).getIdConversation());
        assertEquals(1, conversationList.get(1).getIdConversation());
        assertEquals(NameConversation, conversationList.get(0).getName());
        assertEquals(NameConversation, conversationList.get(1).getName());
        assertEquals(conversationDTOList.get(0).getCreationDate(), conversationList.get(0).getCreationDate());
        assertEquals(conversationDTOList.get(1).getCreationDate(), conversationList.get(1).getCreationDate());
        assertEquals(conversationDTOList.get(0).getModificationDate(), conversationList.get(0).getModificationDate());
        assertEquals(conversationDTOList.get(1).getModificationDate(), conversationList.get(1).getModificationDate());
        assertEquals(conversationDTOList.get(0).getGame(), conversationList.get(0).getGame());
        assertEquals(conversationDTOList.get(1).getGame(), conversationList.get(1).getGame());
        assertEquals(conversationDTOList.get(0).getUser(), conversationList.get(0).getUser());
        assertEquals(conversationDTOList.get(1).getUser(), conversationList.get(1).getUser());
    }

    @Test
    void testConvertListConversationDTOToListConversationWithNull() {

        List<ConversationDTO> conversationDTOList = List.of(createSampleConversationDTOWithNull(), createSampleConversationDTOWithNull());

        List<Conversation> conversationList = conversationConvert.convertListDtoToListEntity(conversationDTOList);

        assertEquals(Conversation.class, conversationList.get(0).getClass());
        assertEquals(1, conversationList.get(0).getIdConversation());
        assertEquals(1, conversationList.get(1).getIdConversation());
        assertNull(conversationList.get(0).getName());
        assertNull(conversationList.get(1).getName());
        assertNull(conversationDTOList.get(0).getCreationDate());
        assertNull(conversationDTOList.get(1).getCreationDate());
        assertNull(conversationDTOList.get(0).getModificationDate());
        assertNull(conversationDTOList.get(1).getModificationDate());
        assertNull(conversationDTOList.get(0).getGame());
        assertNull(conversationDTOList.get(1).getGame());
        assertNull(conversationDTOList.get(0).getUser());
        assertNull(conversationDTOList.get(1).getUser());
    }
}
