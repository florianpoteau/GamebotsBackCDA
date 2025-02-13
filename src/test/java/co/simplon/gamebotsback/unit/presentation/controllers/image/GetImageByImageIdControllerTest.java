package co.simplon.gamebotsback.unit.presentation.controllers.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetImageByImageIdController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetImageByImageIdControllerTest {

  @InjectMocks
  private GetImageByImageIdController controller;

  @Mock
  private Iimageservice imageService;

  @Test
  @DisplayName("Test de recuperation d'une image par son id depuis le controller")
  void getImageById() {
    when(imageService.getImageByImageId(anyInt())).thenReturn(new Imagedto());
    Imagedto imagedto = controller.findImageByImageId(anyInt());
    verify(imageService, times(1)).getImageByImageId(anyInt());
    assertEquals(Imagedto.class, imagedto.getClass());
  }
}
