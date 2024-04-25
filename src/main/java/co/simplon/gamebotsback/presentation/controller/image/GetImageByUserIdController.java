/**
 * Controller class for retrieving an image by user ID in the presentation layer.
 * This controller handles HTTP GET requests to fetch an image associated with a specific user ID and returns it as an ImageDTO object.
 */
package co.simplon.gamebotsback.presentation.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageByUserIdController {

  private final IImageService imageService;

  /**
   * Constructs a new GetImageByUserIdController with the specified image service.
   *
   * @param imageService The image service used to retrieve an image by user ID.
   */
  @Autowired
  public GetImageByUserIdController(IImageService imageService) {
    this.imageService = imageService;
  }

  /**
   * Handles HTTP GET requests to fetch an image associated with a specific user
   * ID.
   *
   * @param id The ID of the user.
   * @return An ImageDTO object representing the image associated with the
   * specified user ID.
   */
  @GetMapping("/users/{id}/images")
  Imagedto findImageByUserId(@PathVariable int id) {
    return imageService.getImageByUserIdAndImageType(id);
  }

}
