package co.simplon.gamebotsback.business.service.image;

import co.simplon.gamebotsback.business.convert.ImageConvert;
import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.Iimagerepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of the <code>IImageService</code> interface
 * providing functionalities for managing images.
 * This service class retrieves image data from the repository,
 * converts it into DTOs (Data Transfer Objects),
 * and provides methods to interact with images.
 */
@Service
public class ImageServiceImpl implements Iimageservice {

  /**
   * The repository used to access image data.
   */
  private final Iimagerepository imageRepository;

  /**
   * Constructor for <code>ImageServiceImpl</code>.
   *
   * @param repositoryImage
   *     The repository used to access image data.
   */
  @Autowired
  public ImageServiceImpl(final Iimagerepository repositoryImage) {
    this.imageRepository = repositoryImage;
  }

  /**
   * Retrieves all images.
   *
   * @return A list of all images.
   */
  @Override
  public List<Imagedto> getAllImages() {
    final List<Image> result = imageRepository.findAll();
    return ImageConvert.getInstance().convertListEntityToListDto(result);
  }

  /**
   * Retrieves information about an image based on its ID.
   *
   * @param imageId
   *     The ID of the image.
   *
   * @return Information about the image corresponding to the given ID.
   */
  @Override
  public Imagedto getImageByImageId(final int imageId) {
    Optional<Image> optionalImage = imageRepository.findById(imageId);
    Image image = optionalImage
        .orElseThrow(() -> new NoSuchElementException(
            "Aucune image trouvée avec l'identifiant " + imageId));
    return ImageConvert.getInstance().convertEntityToDto(image);
  }

  /**
   * Retrieves the image associated with a user by user ID and image type.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return Information about the image associated with the specified user and
   *     image type.
   */
  @Override
  public Imagedto getImageByUserIdAndImageType(final int userId) {
    Image image = imageRepository.getImageByUserIdAndImageType(userId);
    return ImageConvert.getInstance().convertEntityToDto(image);
  }

  /**
   * Retrieves all images associated with a game by game ID.
   *
   * @param typeImage
   *     The type of the image.
   * @param gameId
   *     The ID of the game.
   *
   * @return A list of all images associated with the specified game.
   */
  @Override
  public List<Imagedto> getAllImagesByGameIdAndImageType(
      final String typeImage, final int gameId) {
    List<Image> image = imageRepository.getAllImagesByGameId(typeImage, gameId);
    return ImageConvert.getInstance().convertListEntityToListDto(image);
  }

  /**
   * Retrieves all images of type Avatar.
   * This method fetches the images from the repository,
   * converts them to ImageDTO objects,
   * and returns the list of ImageDTOs.
   *
   * @return A list of ImageDTO objects representing all Avatar images.
   */
  @Override
  public List<Imagedto> getImagesByAvatarType() {
    List<Image> images = imageRepository.findImagesByAvatarType();
    return ImageConvert.getInstance().convertListEntityToListDto(images);
  }

}
