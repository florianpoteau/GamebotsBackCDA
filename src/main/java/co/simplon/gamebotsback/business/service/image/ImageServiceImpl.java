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

    @Autowired
    public ImageServiceImpl(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ImageDTO> getAll() {
        final List<Image> result = imageRepository.findAll();
        return ImageConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public ImageDTO getById(int id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        Image image = optionalImage.get();
        return ImageConvert.getInstance().convertEntityToDto(image);
    }

}
