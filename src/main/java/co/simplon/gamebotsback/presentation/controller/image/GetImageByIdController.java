/**
 * Controller class for retrieving an image by its ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch an image by its ID and returns it as an ImageDTO object.
 */
package co.simplon.gamebotsback.presentation.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageByIdController {

  private final IImageService imageService;

  /**
   * Constructs a new GetImageByIdController with the specified image service.
   *
   * @param imageService The image service used to retrieve an image by its ID.
   */
  @Autowired
  public GetImageByIdController(IImageService imageService) {
    this.imageService = imageService;
  }

  /**
   * Handles HTTP GET requests to fetch an image by its ID.
   *
   * @param id The ID of the image.
   * @return An ImageDTO object representing the image with the specified ID.
   */
  @GetMapping("/images/{id}")
  Imagedto findImageById(@PathVariable int id) {
    return imageService.getById(id);
  }

}
