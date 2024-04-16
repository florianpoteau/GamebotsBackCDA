package co.simplon.gamebotsback.persistance.repository.user;

public class UserQueries {

    private UserQueries() {
        throw new IllegalStateException("Utility class not meant to be instantiated");
    }

    public static final String FIND_BY_USERNAME = "SELECT u FROM User u WHERE u.username = :username";

}
