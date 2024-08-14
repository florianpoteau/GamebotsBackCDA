package co.simplon.gamebotsback.unit.presentation.controllers.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetImageBannerByGameIdController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetImageBannerByGameIdControllerTest {

  @InjectMocks
  private GetImageBannerByGameIdController controller;

  @Mock
  private Iimageservice imageService;

  @Test
  @DisplayName("Test de recuperation d'une image 'banner' par l'id d'un jeu depuis le controller")
  void getImageBannerByGameId() {
    when(imageService.getImagesByGameIdAndImageTypeBanner("banner", 1)).thenReturn(new Imagedto());
    controller.findImageBannerByGameId(1);
    verify(imageService, times(1)).getImagesByGameIdAndImageTypeBanner("banner", 1);
  }
}
