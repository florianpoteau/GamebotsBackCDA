/**
 * Unit test class for testing the functionality of the ImageRepository.
 * This class contains test methods to verify the behavior of methods in the ImageRepository interface.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.IImageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageRepositoryTest {

    @Mock
    private IImageRepository imageRepository;

    @Test
    @DisplayName("Test Find Image By User Id ")
    void testFindImageByUserId() {
        when(imageRepository.getImageByUserIdAndImageType(1)).thenReturn(new Image());
        Image image = imageRepository.getImageByUserIdAndImageType(1);
        verify(imageRepository, times(1)).getImageByUserIdAndImageType(1);
        assert image != null;
    }

    @Test
    @DisplayName("Test Find All Images By Game Id ")
    void testFindAllImagesByGameId() {

        when(imageRepository.getAllImagesByGameId("Avatar", 1)).thenReturn(List.of(new Image()));

        List<Image> images = imageRepository.getAllImagesByGameId("Avatar", 1);

        verify(imageRepository, times(1)).getAllImagesByGameId("Avatar", 1);

        assert images != null;
        assert images.size() == 1;
        assert images.get(0) != null;
    }
}
