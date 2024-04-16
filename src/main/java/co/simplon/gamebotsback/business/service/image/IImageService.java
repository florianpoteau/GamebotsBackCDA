package co.simplon.gamebotsback.business.service.image;

import java.util.List;

import co.simplon.gamebotsback.business.dto.ImageDTO;

public interface IImageService {

    List<ImageDTO> getAll();

    ImageDTO getById(int id);

}
