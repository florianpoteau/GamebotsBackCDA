package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.IImageService;

@RestController
public class GetImageBannerByGameIdController {

    private final IImageService imageService;

    public GetImageBannerByGameIdController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/games/{id}/banner")
    List<ImageDTO> findImageBannerByGameId(@PathVariable int id) {
        return imageService.getImageByGameIdAndImageType("banner", id);
    }

}
