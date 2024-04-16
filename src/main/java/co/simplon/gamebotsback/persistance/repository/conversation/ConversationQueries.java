package co.simplon.gamebotsback.persistance.repository.conversation;

public class ConversationQueries {

    private ConversationQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_ALL_CONVERSATION_BY_USERID = "SELECT c FROM Conversation c WHERE c.user.id = :idUser";

}
