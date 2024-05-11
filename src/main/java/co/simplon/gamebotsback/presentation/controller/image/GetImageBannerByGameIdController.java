package co.simplon.gamebotsback.presentation.controller.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP requests
 * related to fetching a banner image by game ID.
 * This controller handles HTTP GET requests to retrieve
 * the banner image associated with a specific game ID.
 */
@RestController
public class GetImageBannerByGameIdController {

  /**
   * The image service used to retrieve the
   * banner image associated with a specific game ID.
   */
  private final Iimageservice imageService;

  /**
   * Constructs a new GetImageBannerByGameIdController
   * with the specified image service.
   *
   * @param serviceImage
   *     The image service used to retrieve
   *     the banner image associated with a specific game ID.
   */
  public GetImageBannerByGameIdController(final Iimageservice serviceImage) {
    this.imageService = serviceImage;
  }

  /**
   * Handles HTTP GET requests to fetch the banner image by game ID.
   *
   * @param gameId
   *     The ID of the game.
   *
   * @return A list of ImageDTO objects representing the
   *     banner image associated with the specified game ID.
   */
  @GetMapping("/games/{gameId}/banner")
  public List<Imagedto> findImageBannerByGameId(
      @PathVariable final int gameId) {
    return imageService.getAllImagesByGameIdAndImageType("banner", gameId);
  }
}
