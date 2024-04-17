package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ConversationConvert;
import co.simplon.gamebotsback.business.dto.ConversationDTO;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        // Creating a mock Conversation object for the test
        Conversation conversation = new Conversation();
        conversation.setIdConversation(1);
        conversation.setName("Comment tuer des mangeurs d'homme ?");
        Date creationDate = new Date();
        conversation.setCreationDate(creationDate);
        conversation.setModificationDate(null); // ModificationDate should be null by default
        conversation.setGame(null); // Associated game should be null
        conversation.setUser(null); // Associated user should be null

        // Converting the Conversation object to a ConversationDTO
        ConversationDTO conversationDTO = conversationConvert.convertEntityToDto(conversation);

        // Verifying the properties of the converted DTO
        assertEquals(1, conversationDTO.getIdConversation());
        assertEquals("Comment tuer des mangeurs d'homme ?", conversationDTO.getName());
        assertEquals(creationDate, conversationDTO.getCreationDate());
        assertNull(conversationDTO.getModificationDate()); // ModificationDate should be null
        assertNull(conversationDTO.getGame()); // Associated game should be null
        assertNull(conversationDTO.getUser()); // Associated user should be null
    }
}
