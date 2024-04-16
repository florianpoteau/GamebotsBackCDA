package co.simplon.gamebotsback.persistance.repository.message;

public class MessageQueries {

    private MessageQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_MESSAGE_BY_CONVERSATION = "SELECT m FROM Message m JOIN m.conversation c WHERE c.idConversation = :conversationId";

}
