/**
 * Implementation of the <code>IImageService</code> interface providing functionalities for managing images.
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

/**
 * Implementation of the <code>IImageService</code> interface providing functionalities for managing images.
 */
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

}
