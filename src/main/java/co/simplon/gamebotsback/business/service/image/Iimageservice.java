package co.simplon.gamebotsback.business.service.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import java.util.List;

/**
 * The <code>IImageService</code> interface defines
 * operations available for managing images.
 * This interface provides methods for retrieving information about images.
 */
public interface Iimageservice {

  /**
   * Retrieves all images.
   *
   * @return A list of all images.
   */
  List<Imagedto> getAllImages();

  /**
   * Retrieves information about an image based on its ID.
   *
   * @param imageId
   *     The ID of the image.
   *
   * @return Information about the image corresponding to the given ID.
   */
  Imagedto getImageByImageId(int imageId);

  /**
   * Retrieves the image associated with a user by user ID and image type.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return Information about the image associated with the specified user and
   *     image type.
   */
  Imagedto getImageByUserIdAndImageType(int userId);

  /**
   * Retrieves all images associated with a game by game ID and image type.
   *
   * @param typeImage
   *     The type of the image.
   * @param gameId
   *     The ID of the game.
   *
   * @return A list of all images associated with the specified game and image
   *     type.
   */
  List<Imagedto> getAllImagesByGameIdAndImageType(
      String typeImage, int gameId);

}
