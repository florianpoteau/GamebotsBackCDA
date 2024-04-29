/**
 * This class represents a unit test for the MessageRepository class.
 * It tests the functionality of finding messages by conversation ID.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Message;
import co.simplon.gamebotsback.persistance.repository.message.Imessagerepository;
import co.simplon.gamebotsback.persistance.repository.message.MessageQueries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageRepositoryTest {

  @Mock
  private Imessagerepository messageRepository;

  @Test
  @DisplayName("Test Find Message By Conversation")
  void testFindMessageByConversation() {

    when(messageRepository.getMessageByConversationId(1)).thenReturn(List.of(new Message()));

    List<Message> messages = messageRepository.getMessageByConversationId(1);

    verify(messageRepository, times(1)).getMessageByConversationId(1);

    assert messages.size() == 1;
    assert messages.get(0) != null;
  }

  @Test
  @DisplayName("Test that MessageQueries throws exception when instantiated")
  void testInstantiation() {
    try {
      instantiateMessageQueries();
      fail("Expected exception not thrown");
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      assertNotNull(cause);
      assertEquals("Utility class cannot be instantiated", cause.getMessage(), "Expected exception message to match");
    } catch (Exception e) {
      fail("Unexpected exception thrown: " + e.getClass().getSimpleName());
    }
  }

  private void instantiateMessageQueries() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<MessageQueries> constructor = MessageQueries.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    constructor.newInstance();
  }

  @Test
  @DisplayName("Test that FIND_MESSAGE_BY_CONVERSATION query is defined")
  void testFindMessageByConversationQuery() {

    assertNotNull(MessageQueries.FIND_MESSAGE_BY_CONVERSATION, "Expected FIND_MESSAGE_BY_CONVERSATION query to be defined");
    assertEquals("SELECT m FROM Message m JOIN m.conversation c WHERE c.idConversation = :conversationId", MessageQueries.FIND_MESSAGE_BY_CONVERSATION, "Expected FIND_MESSAGE_BY_CONVERSATION query to match");
  }
}
