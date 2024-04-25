/**
 * Unit test class for testing the functionality of the ImageRepository.
 * This class contains test methods to verify the behavior of methods in the ImageRepository interface.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.repository.image.Iimagerepository;
import co.simplon.gamebotsback.persistance.repository.image.ImageQueries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageRepositoryTest {

  @Mock
  private Iimagerepository imageRepository;

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

  @Test
  @DisplayName("Test that ImageQueries throws exception when instantiated")
  void testInstantiation() {
    try {
      instantiateImageQueries();
      fail("Expected exception not thrown");
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      assertNotNull(cause);
      assertEquals("Utility class cannot be instantiated", cause.getMessage(), "Expected exception message to match");
    } catch (Exception e) {
      fail("Unexpected exception thrown: " + e.getClass().getSimpleName());
    }
  }

  private void instantiateImageQueries() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<ImageQueries> constructor = ImageQueries.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    constructor.newInstance();
  }

  @Test
  @DisplayName("Test that FIND_IMAGE_BY_USERID query is defined")
  void testFindImageByUserIdQuery() {

    assertNotNull(ImageQueries.FIND_IMAGE_BY_USERID, "Expected FIND_IMAGE_BY_USERID query to be defined");
    assertEquals("SELECT i FROM User u JOIN u.image i JOIN i.typeImage ti WHERE ti.name = 'avatar' AND u.id = :userId", ImageQueries.FIND_IMAGE_BY_USERID, "Expected FIND_IMAGE_BY_USERID query to match");
  }

  @Test
  @DisplayName("Test that FIND_ALL_IMAGES_BY_GAMEID query is defined")
  void testFindAllImagesByGameIdQuery() {

    assertNotNull(ImageQueries.FIND_ALL_IMAGES_BY_GAMEID, "Expected FIND_ALL_IMAGES_BY_GAMEID query to be defined");
    assertEquals("SELECT i FROM Image i JOIN i.typeImage ti JOIN i.game g WHERE ti.name = :typeImage AND g.idGame = :gameId", ImageQueries.FIND_ALL_IMAGES_BY_GAMEID, "Expected FIND_ALL_IMAGES_BY_GAMEID query to match");
  }
}
