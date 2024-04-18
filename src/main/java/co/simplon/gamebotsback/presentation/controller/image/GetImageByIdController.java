package co.simplon.gamebotsback.presentation.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageByIdController {

    private final IImageService imageService;

    @Autowired
    public GetImageByIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images/{id}")
    ImageDTO findImageById(@PathVariable int id) {
        return imageService.getById(id);
    }

}
