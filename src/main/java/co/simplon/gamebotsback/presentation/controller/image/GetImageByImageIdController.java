package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests related to fetching an image by its ID.
 * This controller handles HTTP GET requests to retrieve an image by its ID.
 */
@RestController
public class GetImageByImageIdController {

  /**
   * The image service used to retrieve an image by its ID.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetImageByIdController with the specified image service.
   *
   * @param serviceImage
   *     The image service used to retrieve an image by its ID.
   */
  @Autowired
  public GetImageByImageIdController(final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles HTTP GET requests to fetch an image by its ID.
   *
   * @param imageId
   *     The ID of the image.
   *
   * @return An ImageDTO object representing the image with the specified ID.
   */
  @GetMapping("/images/{imageId}")
  public Imagedto findImageByImageId(@PathVariable final int imageId) {
    return imageService.getImageByImageId(imageId);
  }

}
