/**
 * This class represents a unit test for the ConversationRepository class.
 * It tests the functionality of finding all conversations by user ID.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.repository.conversation.IConversationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConversationRepositoryTest {

    @Mock
    private IConversationRepository conversationRepository;

    @Test
    @DisplayName("Test Find All Conversation By User Id")
    void testFindAllConversationByUserId() {

        when(conversationRepository.getAllUserConversation(1)).thenReturn(List.of(new Conversation()));

        List<Conversation> conversations = conversationRepository.getAllUserConversation(1);

        verify(conversationRepository, times(1)).getAllUserConversation(1);

        assert conversations.size() == 1;
        assert conversations.get(0) != null;
    }
}
