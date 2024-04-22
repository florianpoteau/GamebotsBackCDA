/**
 * Controller class for retrieving all images associated with a specific game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all images by game ID and return them as a list of ImageDTO objects.
 */
package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetAllImagesByGameIdController {

    private final IImageService imageService;

    /**
     * Constructs a new GetAllImagesByGameIdController with the specified image
     * service.
     *
     * @param imageService The image service used to retrieve all images associated
     *                     with a specific game ID.
     */
    @Autowired
    public GetAllImagesByGameIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Handles HTTP GET requests to fetch all images by game ID.
     *
     * @param id The ID of the game.
     * @return A list of ImageDTO objects representing all images associated with
     *         the specified game ID.
     */
    @GetMapping("/games/{id}/images")
    public List<ImageDTO> findAllImagesByGameId(@PathVariable int id) {
        return imageService.getAllImagesByGameIdAndImageType("image_jeu", id);
    }

}
