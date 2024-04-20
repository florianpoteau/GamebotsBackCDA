package co.simplon.gamebotsback.unit.business.service;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.business.service.image.ImageServiceImpl;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.IImageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceTest {

    @InjectMocks
    private ImageServiceImpl imageService;

    @Mock
    private IImageRepository iImageRepository;

    @Test
    @DisplayName("Test de récupération de toutes les images")
    void getAll() {
        when(iImageRepository.findAll()).thenReturn(List.of(new Image()));
        List<ImageDTO> images = imageService.getAll();
        verify(iImageRepository, times(1)).findAll();
        assertEquals(1, images.size(), "Une seule image attendue dans la liste");
        assertEquals(ImageDTO.class, images.get(0).getClass(), "ImageDTO attendu dans la liste");
    }

    @Test
    @DisplayName("Test de récupération de toutes les images par ID de jeu et type d'image")
    void getAllImageByGameIdAndImageType() {
        int gameId = 1;
        String typeImage = "Avatar";
        when(iImageRepository.getAllImagesByGameId(typeImage, gameId)).thenReturn(List.of(new Image()));
        List<ImageDTO> images = imageService.getAllImageByGameIdAndImageType(typeImage, gameId);
        verify(iImageRepository, times(1)).getAllImagesByGameId(typeImage, gameId);
        assertEquals(1, images.size(), "Une seule image attendue dans la liste");
        assertEquals(ImageDTO.class, images.get(0).getClass(), "ImageDTO attendu dans la liste");
    }

}
