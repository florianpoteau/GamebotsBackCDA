/**
 * The <code>IImageService</code> interface defines operations available for managing images.
 * This interface provides methods for retrieving information about images.
 */
package co.simplon.gamebotsback.business.service.image;

import java.util.List;

import co.simplon.gamebotsback.business.dto.ImageDTO;

public interface IImageService {

    /**
     * Retrieves all images.
     *
     * @return A list of all images.
     */
    List<ImageDTO> getAll();

    /**
     * Retrieves information about an image based on its ID.
     *
     * @param id The ID of the image.
     * @return Information about the image corresponding to the given ID.
     */
    ImageDTO getById(int id);

    /**
     * Retrieves the image associated with a user by user ID and image type.
     *
     * @param userId The ID of the user.
     * @return Information about the image associated with the specified user and image type.
     */
    ImageDTO getImagesByUserIdAndImageType(int userId);

    /**
     * Retrieves the banner image associated with a game by game ID and image type.
     *
     * @param gameId The ID of the game.
     * @return Information about the banner image associated with the specified game and image type.
     */
    ImageDTO getImagesBannerByGameIdAndImageType(int gameId);

    /**
     * Retrieves all images associated with a game by game ID and image type.
     *
     * @param gameId The ID of the game.
     * @return A list of all images associated with the specified game and image type.
     */
    List<ImageDTO> getAllImagesByGameId(int gameId);

}
