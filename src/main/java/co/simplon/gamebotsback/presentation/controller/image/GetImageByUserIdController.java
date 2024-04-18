package co.simplon.gamebotsback.presentation.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageByUserIdController {

    private final IImageService imageService;

    @Autowired
    public GetImageByUserIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/users/{id}/images")
    ImageDTO findImageByUserId(@PathVariable int id) {
        return imageService.getImageByUserIdAndImageType(id);
    }

}
