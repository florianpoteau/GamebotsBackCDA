package co.simplon.gamebotsback.presentation.controller.image;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GetAllImagesBannerController {

    private final Iimageservice imageservice;

    public GetAllImagesBannerController(final Iimageservice serviceImage) {
        this.imageservice = serviceImage;
    }

    @GetMapping("/games/banner")
    public List<Imagedto> findAllImageBanner() {
        return imageservice.getAllImagesBanner("banner");
    }

}
