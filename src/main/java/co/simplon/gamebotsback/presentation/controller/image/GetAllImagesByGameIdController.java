package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetAllImagesByGameIdController {

    private IImageService imageService;

    @Autowired
    public GetAllImagesByGameIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/games/{id}/images")
    public List<ImageDTO> findAllImagesByGameId(@PathVariable int id) {
        return imageService.getAllImageByGameIdAndImageType("image_jeu", id);
    }

}
