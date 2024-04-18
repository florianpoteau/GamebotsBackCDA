package co.simplon.gamebotsback.persistance.repository.conversation;

/**
 * Utility class containing named queries for Conversation entities.
 */
public class ConversationQueries {

    private ConversationQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    /**
     * Named query to find all conversations by user ID.
     */
    public static final String FIND_ALL_CONVERSATION_BY_USERID = "SELECT c FROM Conversation c WHERE c.user.id = :idUser";
    public static final String FIND_ALL_CONVERSATION_BY_USERID_AND_GAMEID = "SELECT c FROM Conversation c WHERE c.user.id = :idUser AND c.game.id = :idGame";

}
