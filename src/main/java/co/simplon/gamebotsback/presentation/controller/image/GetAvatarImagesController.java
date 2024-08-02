package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling
 * HTTP requests related to fetching Avatar images.
 */
@RestController
public class GetAvatarImagesController {

  /**
   * The image service used to retrieve all images.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetAvatarImagesController
   * with the specified image service.
   * This constructor is annotated with
   *
   * @param serviceImage
   *     The image service used to retrieve Avatar images.
   *
   * @Autowired to enable dependency injection.
   */
  @Autowired
  public GetAvatarImagesController(final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles a GET request to fetch all Avatar images.
   *
   * @return A list of ImageDTO objects representing all Avatar images.
   */
  @GetMapping("/images/avatars")
  public List<Imagedto> getAvatarImages() {
    return imageService.getImagesByAvatarType();
  }
}
