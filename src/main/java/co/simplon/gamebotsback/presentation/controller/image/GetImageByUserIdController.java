package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests to retrieve images by user ID.
 */
@RestController
public class GetImageByUserIdController {

  /**
   * The image service used to retrieve an image by user ID.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetImageByUserIdController
   * with the specified image service.
   *
   * @param serviceImage
   *     The image service used to retrieve an image by user ID.
   */
  @Autowired
  public GetImageByUserIdController(final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles HTTP GET requests to fetch an image associated with a specific user
   * ID.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return An ImageDTO object representing the image associated with the
   *     specified user ID.
   */
  @GetMapping("/users/{userId}/images")
  public Imagedto findImageByUserId(@PathVariable final int userId) {
    return imageService.getImageByUserIdAndImageType(userId);
  }

}
