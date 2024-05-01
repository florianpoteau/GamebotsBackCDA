package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling
 * HTTP requests related to retrieving all images.
 * This controller handles HTTP GET requests
 * to fetch all images from the system.
 */
@RestController
public class GetAllImagesController {

  /**
   * The image service used to retrieve all images.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetAllImagesController with the specified image service.
   *
   * @param serviceImage
   *     The image service used to retrieve all images.
   */
  @Autowired
  public GetAllImagesController(final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles HTTP GET requests to fetch all images.
   *
   * @return A list of Imagedto objects representing all images.
   */
  @GetMapping("/images")
  public List<Imagedto> findAllImages() {
    return imageService.getAll();
  }

}
