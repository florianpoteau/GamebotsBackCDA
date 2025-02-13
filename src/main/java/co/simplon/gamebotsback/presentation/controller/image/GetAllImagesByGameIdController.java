package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for retrieving all images
 * associated with a specific game ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch all images by game
 * ID and return them as a list of ImageDTO
 * objects.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GetAllImagesByGameIdController {

  /**
   * The image service used for image-related operations.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetAllImagesByGameIdController with the specified image
   * service.
   *
   * @param serviceImage
   *     The image service used to retrieve all images associated
   *     with a specific game ID.
   */
  @Autowired
  public GetAllImagesByGameIdController(
      final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles HTTP GET requests to fetch all images by game ID.
   *
   * @param gameId
   *     The ID of the game.
   *
   * @return A list of ImageDTO objects representing all images associated with
   *     the specified game ID.
   */
  @GetMapping("/games/{gameId}/images")
  public List<Imagedto> findAllImagesByGameId(
      @PathVariable final int gameId) {
    return imageService.getAllImagesByGameIdAndImageType("image_jeu", gameId);
  }

}
