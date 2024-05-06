package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.business.service.image.ImageServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.Iimagerepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceTest {

  Image existingImage = new Image();

  int imageId = 1;

  @InjectMocks
  private ImageServiceImpl imageService;

  @Mock
  private Iimagerepository iImageRepository;

  @Test
  @DisplayName("Test de récupération de toutes les images")
  void testGetAll() {

    when(iImageRepository.findAll()).thenReturn(List.of(existingImage));
    List<Imagedto> images = imageService.getAll();

    verify(iImageRepository, times(1)).findAll();
    assertEquals(1, images.size(), "Une seule image attendue dans la liste");
    assertEquals(Imagedto.class, images.get(0).getClass(), "ImageDTO attendu dans la liste");
  }

  @Test
  @DisplayName("Test de récupération d'une image par son id")
  void testGetById() {

    existingImage.setIdImage(imageId);

    when(iImageRepository.findById(imageId)).thenReturn(Optional.of(existingImage));
    Imagedto imageDTO = imageService.getById(imageId);

    verify(iImageRepository, times(1)).findById(imageId);
    assertNotNull(imageDTO, "ImageDTO attendu dans la liste");
    assertEquals(imageId, imageDTO.getIdImage(), "ImageDTO attendu dans la liste");
  }

  @Test
  @DisplayName("Test de récupération de toutes les images par ID d'un jeu et d'un type d'image")
  void testGetAllImagesByGameIdAndImageType() {

    int gameId = 1;
    String typeImage = "images_game";

    when(iImageRepository.getAllImagesByGameId(typeImage, gameId)).thenReturn(List.of(existingImage));
    List<Imagedto> imagesDTO = imageService.getAllImagesByGameIdAndImageType(typeImage, gameId);

    verify(iImageRepository, times(1)).getAllImagesByGameId(typeImage, gameId);
    assertNotNull(imagesDTO, "L'objet images ne doit pas être nul");
    assertEquals(imageId, imagesDTO.size(), "ImageDTO attendu dans la liste");
    assertEquals(Imagedto.class, imagesDTO.get(0).getClass(), "ImageDTO attendu dans la liste");

  }

  @Test
  @DisplayName("Test de récupération de l'avatar de l'utilisateur")
  void testGetImageByUserIdAndImageType() {

    int userId = 1;
    existingImage.setIdImage(imageId);

    when(iImageRepository.getImageByUserIdAndImageType(userId)).thenReturn(existingImage);
    Imagedto imageDTO = imageService.getImageByUserIdAndImageType(userId);
    verify(iImageRepository, times(1)).getImageByUserIdAndImageType(userId);
    assertNotNull(imageDTO, "L'objet image ne dois pas être null");
    assertEquals(imageId, imageDTO.getIdImage(), "ImageDTO attendu dans la liste");
    assertEquals(Imagedto.class, imageDTO.getClass(), "ImageDTO attendu dans la liste");

  }
}
