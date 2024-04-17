/**
 * The <code>IImageService</code> interface defines operations available for managing images.
 */
package co.simplon.gamebotsback.business.service.image;

import java.util.List;

import co.simplon.gamebotsback.business.dto.ImageDTO;

/**
 * The <code>IImageService</code> interface defines operations available for managing images.
 */
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

}
