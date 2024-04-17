/**
 * Implementation of the <code>IImageService</code> interface providing functionalities for managing images.
 * This service class retrieves image data from the repository, converts it into DTOs (Data Transfer Objects),
 * and provides methods to interact with images.
 */
package co.simplon.gamebotsback.business.service.image;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.ImageConvert;
import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.IImageRepository;

@Service
public class ImageServiceImpl implements IImageService {

    private IImageRepository imageRepository;

    /**
     * Constructor for <code>ImageServiceImpl</code>.
     *
     * @param imageRepository The repository used to access image data.
     */
    @Autowired
    public ImageServiceImpl(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /**
     * Retrieves all images.
     *
     * @return A list of all images.
     */
    @Override
    public List<ImageDTO> getAll() {
        final List<Image> result = imageRepository.findAll();
        return ImageConvert.getInstance().convertListEntityToListDto(result);
    }

    /**
     * Retrieves information about an image based on its ID.
     *
     * @param id The ID of the image.
     * @return Information about the image corresponding to the given ID.
     */
    @Override
    public ImageDTO getById(int id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        Image image = optionalImage.get();
        return ImageConvert.getInstance().convertEntityToDto(image);
    }

    /**
     * Retrieves the image associated with a user by user ID and image type.
     *
     * @param userId The ID of the user.
     * @return Information about the image associated with the specified user and
     *         image type.
     */
    @Override
    public ImageDTO getImagesByUserIdAndImageType(int userId) {
        Image image = imageRepository.getImagesByUserIdAndImageType(userId);
        return ImageConvert.getInstance().convertEntityToDto(image);
    }

    /**
     * Retrieves all images associated with a game by game ID.
     *
     * @param typeImage The type of the image.
     * @param gameId    The ID of the game.
     * @return A list of all images associated with the specified game.
     */
    @Override
    public List<ImageDTO> getAllImagesByGameId(String typeImage, int gameId) {
        List<Image> image = imageRepository.getAllImagesByGameId(typeImage, gameId);
        return ImageConvert.getInstance().convertListEntityToListDto(image);
    }

}
