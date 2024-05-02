package co.simplon.gamebotsback.unit.presentation.controllers.image;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.Iimageservice;
import co.simplon.gamebotsback.presentation.controller.image.GetImageByUserIdController;
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
public class GetImageByUserIdControllerTest {

  @InjectMocks
  private GetImageByUserIdController controller;

  @Mock
  private Iimageservice imageService;

  @Test
  void getImageByUserId() {
    when(imageService.getImageByUserIdAndImageType(anyInt())).thenReturn(new Imagedto());
    Imagedto imagedto = controller.findImageByUserId(anyInt());
    verify(imageService, times(1)).getImageByUserIdAndImageType(anyInt());
    assertEquals(Imagedto.class, imagedto.getClass());
  }
}
