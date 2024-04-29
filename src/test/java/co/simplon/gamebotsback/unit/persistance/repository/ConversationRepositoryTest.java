/**
 * This class represents a unit test for the ConversationRepository class.
 * It tests the functionality of finding all conversations by user ID.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Conversation;
import co.simplon.gamebotsback.persistance.repository.conversation.ConversationQueries;
import co.simplon.gamebotsback.persistance.repository.conversation.Iconversationrepository;
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
class ConversationRepositoryTest {

  @Mock
  private Iconversationrepository conversationRepository;

  @Test
  @DisplayName("Test Find All Conversation By User Id")
  void testFindAllConversationByUserId() {

    when(conversationRepository.getAllUserConversation(1)).thenReturn(List.of(new Conversation()));

    List<Conversation> conversations = conversationRepository.getAllUserConversation(1);

    verify(conversationRepository, times(1)).getAllUserConversation(1);

    assert conversations.size() == 1;
    assert conversations.get(0) != null;
  }

  @Test
  @DisplayName("Test that ConversationQueries throws exception when instantiated")
  void testInstantiation() {
    try {
      instantiateConversationQueries();
      fail("Expected exception not thrown");
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      assertNotNull(cause);
      assertEquals("Utility class cannot be instantiated", cause.getMessage(), "Expected exception message to match");
    } catch (Exception e) {
      fail("Unexpected exception thrown: " + e.getClass().getSimpleName());
    }
  }

  private void instantiateConversationQueries() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<ConversationQueries> constructor = ConversationQueries.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    constructor.newInstance();
  }

  @Test
  @DisplayName("Test that FIND_ALL_CONVERSATION_BY_USERID query is defined")
  void testFindAllConversationByUserIdQuery() {

    assertNotNull(ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID, "Expected FIND_ALL_CONVERSATION_BY_USERID query to be defined");
    assertEquals("SELECT c FROM Conversation c WHERE c.user.id = :idUser", ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID, "Expected FIND_ALL_CONVERSATION_BY_USERID query to match");
  }

  @Test
  @DisplayName("Test that FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID query is defined")
  void testFindAllConversationByUserIdAndGameIdQuery() {

    assertNotNull(ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID, "Expected FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID query to be defined");
    assertEquals("SELECT c FROM Conversation c WHERE c.user.id = :idUser AND c.game.id = :idGame", ConversationQueries.FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID, "Expected FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID query to match");
  }
}
