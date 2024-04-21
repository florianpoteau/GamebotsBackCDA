    package co.simplon.gamebotsback.persistance.repository.user;

    /**
     * Utility class containing named queries for User entities.
     */
    public class UserQueries {

        /**
         * Private constructor to prevent instantiation of this utility class.
         * Throws an exception if an attempt is made to instantiate it.
         */
        private UserQueries() {
            throw new IllegalStateException("Utility class cannot be instantiated");
        }

        /**
         * Named query to find a user by username.
         */
        public static final String FIND_BY_USERNAME = "SELECT u FROM User u WHERE u.username = :username";

    }
