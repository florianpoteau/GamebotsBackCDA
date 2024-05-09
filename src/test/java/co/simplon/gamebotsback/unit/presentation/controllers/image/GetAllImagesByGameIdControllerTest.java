package co.simplon.gamebotsback.unit.presentation.controllers.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetAllImagesByGameIdController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllImagesByGameIdControllerTest {

  @InjectMocks
  private GetAllImagesByGameIdController controller;

  @Mock
  private Iimageservice imageService;

  @Test
  @DisplayName("Test de recuperation de toutes les images par l'id d'un jeu depuis le controller")
  void getAllImagesByGameId() {
    when(imageService.getAllImagesByGameIdAndImageType("image_jeu", 1)).thenReturn(List.of(new Imagedto()));
    controller.findAllImagesByGameId(1);
    verify(imageService, times(1)).getAllImagesByGameIdAndImageType("image_jeu", 1);
  }
}
