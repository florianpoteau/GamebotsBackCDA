package co.simplon.gamebotsback.persistance.repository.message;

/**
 * Utility class containing named queries for Message entities.
 */
public final class MessageQueries {

  /**
   * Named query to find messages by conversation ID.
   */
  public static final String FIND_MESSAGES_BY_CONVERSATION =
      "SELECT m FROM Message m JOIN m.conversation c WHERE c.idConversation ="
          + " :conversationId";

  /**
   * Private constructor to prevent instantiation of this utility class.
   * Throws an exception if an attempt is made to instantiate it.
   */
  private MessageQueries() {
    throw new IllegalStateException("Utility class cannot be instantiated");
  }

}
