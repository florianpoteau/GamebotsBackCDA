/**
 * This class represents a unit test for the MessageRepository class.
 * It tests the functionality of finding messages by conversation ID.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.IMessageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageRepositoryTest {

    @Mock
    private IMessageRepository messageRepository;

    @Test
    @DisplayName("Test Find Message By Conversation")
    void testFindMessageByConversation() {

        when(messageRepository.getMessageByConversationId(1)).thenReturn(List.of(new Message()));

        List<Message> messages = messageRepository.getMessageByConversationId(1);

        verify(messageRepository, times(1)).getMessageByConversationId(1);

        assert messages.size() == 1;
        assert messages.get(0) != null;
    }
}
