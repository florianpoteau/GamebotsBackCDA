/**
 * Controller class for retrieving the banner image associated with a specific game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch the banner image by game ID and return it as a list of ImageDTO objects.
 */
package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageBannerByGameIdController {

    private final IImageService imageService;

    /**
     * Constructs a new GetImageBannerByGameIdController with the specified image
     * service.
     *
     * @param imageService The image service used to retrieve the banner image
     *                     associated with a specific game ID.
     */
    public GetImageBannerByGameIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Handles HTTP GET requests to fetch the banner image by game ID.
     *
     * @param id The ID of the game.
     * @return A list of ImageDTO objects representing the banner image associated
     *         with the specified game ID.
     */
    @GetMapping("/games/{id}/banner")
    List<ImageDTO> findImageBannerByGameId(@PathVariable int id) {
        return imageService.getAllImagesByGameIdAndImageType("banner", id);
    }

}
