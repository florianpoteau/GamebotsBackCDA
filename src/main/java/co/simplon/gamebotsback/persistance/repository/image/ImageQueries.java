package co.simplon.gamebotsback.persistance.repository.image;

public class ImageQueries {

    private ImageQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_IMAGE_BY_USERID = "SELECT i FROM User u JOIN u.image i JOIN i.typeImage ti WHERE ti.name = 'avatar' AND u.id = :userId";
    public static final String FIND_IMAGE_BANNER_BY_GAMEID = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name = 'banner' AND g.idGame = :gameId";
    public static final String FIND_ALL_IMAGES_BY_GAMEID = "SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name = 'images game' AND g.idGame = :gameId";
}