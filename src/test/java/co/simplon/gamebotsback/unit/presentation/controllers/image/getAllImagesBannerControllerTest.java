package co.simplon.gamebotsback.unit.presentation.controllers.image;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetAllImagesBannerController;

@ExtendWith(MockitoExtension.class)
class GetAllImagesBannerControllerTest {

    @InjectMocks
    private GetAllImagesBannerController controller;

    @Mock
    private Iimageservice imageservice;

    @Test
    @DisplayName("Test de récupération des bannières de chaque jeu")
    void getAllImagesBanner() {
        when(imageservice.getAllImagesBanner("banner")).thenReturn(List.of(new Imagedto()));
        controller.findAllImageBanner();
        verify(imageservice, times(1)).getAllImagesBanner("banner");
    }

}

