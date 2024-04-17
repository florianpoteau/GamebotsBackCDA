package co.simplon.gamebotsback.persistance.repository.message;

/**
 * Utility class containing named queries for Message entities.
 */
public class MessageQueries {

    private MessageQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    /**
     * Named query to find messages by conversation ID.
     */
    public static final String FIND_MESSAGE_BY_CONVERSATION = "SELECT m FROM Message m JOIN m.conversation c WHERE c.idConversation = :conversationId";

}
