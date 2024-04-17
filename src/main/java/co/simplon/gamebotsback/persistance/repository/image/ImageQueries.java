package co.simplon.gamebotsback.persistance.repository.image;

/**
 * Utility class containing named queries for Image entities.
 * These queries are used by the IImageRepository interface to retrieve specific types of images.
 */
public class ImageQueries {

    /**
     * Private constructor to prevent instantiation of this utility class.
     * Throws an exception if an attempt is made to instantiate it.
     */
    private ImageQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    /** Query to find the image associated with a user by user ID. */
    public static final String FIND_IMAGE_BY_USERID = "SELECT i FROM User u JOIN u.image i JOIN i.typeImage ti WHERE ti.name = 'avatar' AND u.id = :userId";

    /** Query to find the banner image associated with a game by game ID. */
    public static final String FIND_IMAGE_BANNER_BY_GAMEID = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name = 'banner' AND g.idGame = :gameId";

    /** Query to find all images associated with a game by game ID. */
    public static final String FIND_ALL_IMAGES_BY_GAMEID = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name = 'images game' AND g.idGame = :gameId";
}
