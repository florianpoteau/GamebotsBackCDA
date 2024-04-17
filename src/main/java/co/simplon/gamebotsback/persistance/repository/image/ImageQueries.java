package co.simplon.gamebotsback.persistance.repository.image;

public class ImageQueries {

    private ImageQueries() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static final String FIND_IMAGE_BY_USERID = "SELECT i FROM User u JOIN u.image i JOIN i.typeImage ti WHERE ti.name = 'avatar' AND u.id = :userId";

}
