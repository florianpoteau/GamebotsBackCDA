package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ImageConvert;
import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.Image;
import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImageConvertTest {

  private static final ImageConvert imageConvert = ImageConvert.getInstance();

  private static final String name = "Avatar-Apex-Pathfinder";
  private static final String source = "./src/images";

  private Image createSampleImage() {

    Image image = new Image();

    image.setIdImage(1);
    image.setName(name);
    image.setSource(source);
    image.setCreationDate(new Date());
    image.setModificationDate(new Date());
    image.setGame(new Game());
    image.setTypeImage(new TypeImage());

    return image;
  }

  private Image createSampleImageWithNull() {

    Image image = new Image();

    image.setIdImage(1);
    image.setName(null);
    image.setSource(null);
    image.setCreationDate(null);
    image.setModificationDate(null);
    image.setGame(null);
    image.setTypeImage(null);

    return image;
  }

  private Imagedto createSampleImageDTO() {

    Imagedto imageDTO = new Imagedto();

    imageDTO.setIdImage(1);
    imageDTO.setName(name);
    imageDTO.setSource(source);
    imageDTO.setCreationDate(new Date());
    imageDTO.setModificationDate(new Date());
    imageDTO.setGame(new Game());
    imageDTO.setTypeImage(new TypeImage());

    return imageDTO;
  }

  private Imagedto createSampleImageDTOWithNull() {

    Imagedto imageDTO = new Imagedto();

    imageDTO.setIdImage(1);
    imageDTO.setName(null);
    imageDTO.setSource(null);
    imageDTO.setCreationDate(null);
    imageDTO.setModificationDate(null);
    imageDTO.setGame(null);
    imageDTO.setTypeImage(null);

    return imageDTO;
  }

  @Test
  @DisplayName("Test de récupération de l'instance de ImageConvert")
  void testGetInstanceReturnsInstanceOfImageConvert() {

    ImageConvert imageConvert = ImageConvert.getInstance();

    assertNotNull(imageConvert);
    assertInstanceOf(ImageConvert.class, imageConvert);
  }

  @Test
  @DisplayName("Test de conversion de Image à ImageDto")
  void testConvertImageToImageDTO() {

    Image image = createSampleImage();
    Imagedto imageDTO = imageConvert.convertEntityToDto(image);

    assertSame(1, imageDTO.getIdImage());
    assertSame(name, imageDTO.getName());
    assertSame(source, imageDTO.getSource());
    assertSame(image.getCreationDate(), imageDTO.getCreationDate());
    assertSame(image.getModificationDate(), imageDTO.getModificationDate());
    assertSame(image.getGame(), imageDTO.getGame());
    assertSame(image.getTypeImage(), imageDTO.getTypeImage());
  }

  @Test
  @DisplayName("Test de conversion de Image à ImageDto quand Image est null")
  void testConvertImageToImageDTOWithNull() {

    Image image = createSampleImageWithNull();
    Imagedto imageDTO = imageConvert.convertEntityToDto(image);

    assertSame(1, imageDTO.getIdImage());
    assertNull(imageDTO.getName());
    assertNull(imageDTO.getSource());
    assertNull(imageDTO.getCreationDate());
    assertNull(imageDTO.getModificationDate());
    assertNull(imageDTO.getGame());
    assertNull(imageDTO.getTypeImage());
  }

  @Test
  @DisplayName("Test de conversion de ImageDto à Image")
  void testConvertImageDTOToImage() {

    Imagedto imageDTO = createSampleImageDTO();
    Image image = imageConvert.convertDtoToEntity(imageDTO);

    assertSame(1, image.getIdImage());
    assertSame(name, image.getName());
    assertSame(source, image.getSource());
    assertSame(imageDTO.getCreationDate(), image.getCreationDate());
    assertSame(imageDTO.getModificationDate(), image.getModificationDate());
    assertSame(imageDTO.getGame(), image.getGame());
    assertSame(imageDTO.getTypeImage(), image.getTypeImage());
  }

  @Test
  @DisplayName("Test de conversion de ImageDto à Image quand ImageDto est null")
  void testConvertImageDTOToImageWithNull() {

    Imagedto imageDTO = createSampleImageDTOWithNull();
    Image image = imageConvert.convertDtoToEntity(imageDTO);

    assertSame(1, image.getIdImage());
    assertNull(image.getName());
    assertNull(image.getSource());
    assertNull(image.getCreationDate());
    assertNull(image.getModificationDate());
    assertNull(image.getGame());
    assertNull(image.getTypeImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Image à une liste de ImageDto")
  void testConvertListImageToListImageDTO() {

    List<Image> imageList = List.of(createSampleImage(), createSampleImage());
    List<Imagedto> imagedtoList = imageConvert.convertListEntityToListDto(imageList);

    assertSame(1, imagedtoList.get(0).getIdImage());
    assertSame(1, imagedtoList.get(1).getIdImage());
    assertSame(name, imagedtoList.get(0).getName());
    assertSame(name, imagedtoList.get(1).getName());
    assertSame(source, imagedtoList.get(0).getSource());
    assertSame(source, imagedtoList.get(1).getSource());
    assertSame(imageList.get(0).getCreationDate(), imagedtoList.get(0).getCreationDate());
    assertSame(imageList.get(1).getCreationDate(), imagedtoList.get(1).getCreationDate());
    assertSame(imageList.get(0).getModificationDate(), imagedtoList.get(0).getModificationDate());
    assertSame(imageList.get(1).getModificationDate(), imagedtoList.get(1).getModificationDate());
    assertSame(imageList.get(0).getGame(), imagedtoList.get(0).getGame());
    assertSame(imageList.get(1).getGame(), imagedtoList.get(1).getGame());
    assertSame(imageList.get(0).getTypeImage(), imagedtoList.get(0).getTypeImage());
    assertSame(imageList.get(1).getTypeImage(), imagedtoList.get(1).getTypeImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Image à une liste de ImageDto quand la liste de Image est null")
  void testConvertListImageToListImageDTOWithNull() {

    List<Image> imageList = List.of(createSampleImageWithNull(), createSampleImageWithNull());
    List<Imagedto> imagedtoList = imageConvert.convertListEntityToListDto(imageList);

    assertSame(1, imagedtoList.get(0).getIdImage());
    assertSame(1, imagedtoList.get(1).getIdImage());
    assertNull(imagedtoList.get(0).getName());
    assertNull(imagedtoList.get(1).getName());
    assertNull(imagedtoList.get(0).getSource());
    assertNull(imagedtoList.get(1).getSource());
    assertNull(imagedtoList.get(0).getCreationDate());
    assertNull(imagedtoList.get(1).getCreationDate());
    assertNull(imagedtoList.get(0).getModificationDate());
    assertNull(imagedtoList.get(1).getModificationDate());
    assertNull(imagedtoList.get(0).getGame());
    assertNull(imagedtoList.get(1).getGame());
    assertNull(imagedtoList.get(0).getTypeImage());
    assertNull(imagedtoList.get(1).getTypeImage());
  }


  @Test
  @DisplayName("Test de conversation d'une liste de ImageDto à une liste de Image")
  void testConvertListImageDTOToListImage() {

    List<Imagedto> imagedtoList = List.of(createSampleImageDTO(), createSampleImageDTO());
    List<Image> imageList = imageConvert.convertListDtoToListEntity(imagedtoList);

    assertSame(1, imageList.get(0).getIdImage());
    assertSame(1, imageList.get(1).getIdImage());
    assertSame(name, imageList.get(0).getName());
    assertSame(name, imageList.get(1).getName());
    assertSame(source, imageList.get(0).getSource());
    assertSame(source, imageList.get(1).getSource());
    assertSame(imagedtoList.get(0).getCreationDate(), imageList.get(0).getCreationDate());
    assertSame(imagedtoList.get(1).getCreationDate(), imageList.get(1).getCreationDate());
    assertSame(imagedtoList.get(0).getModificationDate(), imageList.get(0).getModificationDate());
    assertSame(imagedtoList.get(1).getModificationDate(), imageList.get(1).getModificationDate());
    assertSame(imagedtoList.get(0).getGame(), imageList.get(0).getGame());
    assertSame(imagedtoList.get(1).getGame(), imageList.get(1).getGame());
    assertSame(imagedtoList.get(0).getTypeImage(), imageList.get(0).getTypeImage());
    assertSame(imagedtoList.get(1).getTypeImage(), imageList.get(1).getTypeImage());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de ImageDto à une liste de Image quand la liste de ImageDto est null")
  void testConvertListImageDTOToListImageWithNull() {

    List<Imagedto> imagedtoList = List.of(createSampleImageDTOWithNull(), createSampleImageDTOWithNull());
    List<Image> imageList = imageConvert.convertListDtoToListEntity(imagedtoList);

    assertSame(1, imageList.get(0).getIdImage());
    assertSame(1, imageList.get(1).getIdImage());
    assertNull(imageList.get(0).getName());
    assertNull(imageList.get(1).getName());
    assertNull(imageList.get(0).getSource());
    assertNull(imageList.get(1).getSource());
    assertNull(imageList.get(0).getCreationDate());
    assertNull(imageList.get(1).getCreationDate());
    assertNull(imageList.get(0).getModificationDate());
    assertNull(imageList.get(1).getModificationDate());
    assertNull(imageList.get(0).getGame());
    assertNull(imageList.get(1).getGame());
    assertNull(imageList.get(0).getTypeImage());
    assertNull(imageList.get(1).getTypeImage());
  }
}
