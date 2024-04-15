package co.simplon.gamebotsback.persistance.repository.conversation;

public class ConversationQueries {

    private ConversationQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_ALL_USER_BY_CONVERSATION = "SELECT u FROM User u JOIN u.conversation c WHERE c.idConversation = :conversationId";

}
