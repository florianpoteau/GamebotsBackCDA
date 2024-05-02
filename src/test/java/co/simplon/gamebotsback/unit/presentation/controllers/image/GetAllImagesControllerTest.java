package co.simplon.gamebotsback.unit.presentation.controllers.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetAllImagesController;
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
public class GetAllImagesControllerTest {

  @InjectMocks
  private GetAllImagesController controller;

  @Mock
  private Iimageservice imageService;

  @Test
  void getAllImages() {
    when(imageService.getAll()).thenReturn(List.of(new Imagedto()));
    controller.findAllImages();
    verify(imageService, times(1)).getAll();
  }
}
