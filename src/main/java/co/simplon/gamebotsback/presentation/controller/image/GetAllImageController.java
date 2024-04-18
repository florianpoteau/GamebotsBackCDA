package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetAllImageController {

    private final IImageService imageService;

    @Autowired
    public GetAllImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public List<ImageDTO> findAllImages() {
        return imageService.getAll();
    }

}
