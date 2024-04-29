package co.simplon.gamebotsback.persistance.repository.conversation;

/**
 * Utility class containing named queries for Conversation entities.
 */
public final class ConversationQueries {

  /**
   * Named query to find all conversations by user ID.
   */
  public static final String FIND_ALL_CONVERSATION_BY_USERID =
      "SELECT c FROM Conversation c WHERE c.user.id = :idUser";
  /**
   * Named query to find all conversations by user ID and game ID.
   */
  public static final String FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID =
      "SELECT c FROM Conversation c WHERE c.user.id = "
          + ":idUser AND c.game.id = :idGame";

  /**
   * Private constructor to prevent instantiation of this utility class.
   * Throws an exception if an attempt is made to instantiate it.
   */
  private ConversationQueries() {
    throw new IllegalStateException(
        "Utility class cannot be instantiated");
  }

}
