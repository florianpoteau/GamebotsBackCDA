package co.simplon.gamebotsback.persistance.repository.image;

/**
 * Utility class containing named queries for Image entities.
 * These queries are used by the IImageRepository interface to retrieve specific
 * types of images.
 */
public final class ImageQueries {

  /**
   * Query to find the image associated with a user by user ID.
   */
  public static final String FIND_IMAGE_BY_USERID = "SELECT i FROM User u JOIN u.image i JOIN i.typeImage ti WHERE ti.name ="
      + " 'avatar' AND u.id = :userId";
  /**
   * Query to find all images associated with a game by game ID.
   */
  public static final String FIND_ALL_IMAGES_BY_GAMEID = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name ="
      + " :typeImage AND g.idGame = :gameId";

  public static final String FIND_ALL_IMAGES_GAMES = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name ="
      + " :typeImage";

  public static final String FIND_ALL_IMAGES_BANNER = "SELECT i FROM Image i JOIN i.typeImage ti WHERE ti.name = :typeImage";

  /**
   * Private constructor to prevent instantiation of this utility class.
   * Throws an exception if an attempt is made to instantiate it.
   */
  private ImageQueries() {
    throw new IllegalStateException("Utility class cannot be instantiated");
  }
}
