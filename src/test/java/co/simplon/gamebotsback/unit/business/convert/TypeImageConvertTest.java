package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.TypeImageConvert;
import co.simplon.gamebotsback.business.dto.TypeImagedto;
import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class TypeImageConvertTest {

  private static final TypeImageConvert typeImageConvert = TypeImageConvert.getInstance();
  private static final String name = "Avatar";

  private TypeImage createSampleTypeImage() {

    TypeImage typeImage = new TypeImage();

    typeImage.setIdTypeImage(1);
    typeImage.setName(name);
    typeImage.setCreationDate(new Date());
    typeImage.setModificationDate(new Date());

    return typeImage;
  }

  private TypeImage createSampleTypeImageWithNull() {

    TypeImage typeImage = new TypeImage();

    typeImage.setIdTypeImage(1);
    typeImage.setName(null);
    typeImage.setCreationDate(null);
    typeImage.setModificationDate(null);

    return typeImage;
  }

  private TypeImagedto createSampleTypeImageDTO() {

    TypeImagedto typeImageDTO = new TypeImagedto();

    typeImageDTO.setIdTypeImage(1);
    typeImageDTO.setName(name);
    typeImageDTO.setCreationDate(new Date());
    typeImageDTO.setModificationDate(new Date());

    return typeImageDTO;
  }

  private TypeImagedto createSampleTypeImageDTOWithNull() {

    TypeImagedto typeImageDTO = new TypeImagedto();

    typeImageDTO.setIdTypeImage(1);
    typeImageDTO.setName(null);
    typeImageDTO.setCreationDate(null);
    typeImageDTO.setModificationDate(null);

    return typeImageDTO;
  }

  @Test
  @DisplayName("Test de récupération de l'instance de TypeImageConvert")
  void testGetInstanceReturnsInstanceOfTypeImageConvert() {

    TypeImageConvert typeImageConvert = TypeImageConvert.getInstance();

    assertNotNull(typeImageConvert);
    assertInstanceOf(TypeImageConvert.class, typeImageConvert);
  }

  @Test
  @DisplayName("Test de conversion de TypeImage à TypeImageDto")
  void testConvertTypeImageToTypeImageDTO() {

    TypeImage typeImage = createSampleTypeImage();
    TypeImagedto typeImageDTO = typeImageConvert.convertEntityToDto(typeImage);

    assertSame(1, typeImageDTO.getIdTypeImage());
    assertSame(name, typeImageDTO.getName());
    assertSame(typeImage.getCreationDate(), typeImageDTO.getCreationDate());
    assertSame(typeImage.getModificationDate(), typeImageDTO.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversion de TypeImage à TypeImageDto quand TypeImage est null")
  void testConvertTypeImageToTypeImageDTOWithNull() {

    TypeImage typeImage = createSampleTypeImageWithNull();
    TypeImagedto typeImageDTO = typeImageConvert.convertEntityToDto(typeImage);

    assertSame(1, typeImageDTO.getIdTypeImage());
    assertNull(typeImageDTO.getName());
    assertNull(typeImageDTO.getCreationDate());
    assertNull(typeImageDTO.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversion de TypeImageDto à TypeImage")
  void testConvertTypeImageDTOToTypeImage() {

    TypeImagedto typeImageDTO = createSampleTypeImageDTO();
    TypeImage typeImage = typeImageConvert.convertDtoToEntity(typeImageDTO);

    assertSame(1, typeImage.getIdTypeImage());
    assertSame(name, typeImage.getName());
    assertSame(typeImageDTO.getCreationDate(), typeImage.getCreationDate());
    assertSame(typeImageDTO.getModificationDate(), typeImage.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversion de TypeImageDto à TypeImage quand TypeImageDto est null")
  void testConvertTypeImageDTOToTypeImageWithNull() {

    TypeImagedto typeImageDTO = createSampleTypeImageDTOWithNull();
    TypeImage typeImage = typeImageConvert.convertDtoToEntity(typeImageDTO);

    assertSame(1, typeImage.getIdTypeImage());
    assertNull(typeImage.getName());
    assertNull(typeImage.getCreationDate());
    assertNull(typeImage.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de TypeImage à une liste de TypeImageDto")
  void testConvertListTypeImageToListTypeImageDTO() {

    List<TypeImage> typeImageList = List.of(createSampleTypeImage(), createSampleTypeImage());
    List<TypeImagedto> typeImagedtoList = typeImageConvert.convertListEntityToListDto(typeImageList);

    assertSame(1, typeImagedtoList.get(0).getIdTypeImage());
    assertSame(1, typeImagedtoList.get(1).getIdTypeImage());
    assertSame(name, typeImagedtoList.get(0).getName());
    assertSame(name, typeImagedtoList.get(1).getName());
    assertSame(typeImageList.get(0).getCreationDate(), typeImagedtoList.get(0).getCreationDate());
    assertSame(typeImageList.get(1).getCreationDate(), typeImagedtoList.get(1).getCreationDate());
    assertSame(typeImageList.get(0).getModificationDate(), typeImagedtoList.get(0).getModificationDate());
    assertSame(typeImageList.get(1).getModificationDate(), typeImagedtoList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de TypeImage à une liste de TypeImageDto quand la liste de TypeImage est null")
  void testConvertListTypeImageToListTypeImageDTOWithNull() {

    List<TypeImage> typeImageList = List.of(createSampleTypeImageWithNull(), createSampleTypeImageWithNull());
    List<TypeImagedto> typeImagedtoList = typeImageConvert.convertListEntityToListDto(typeImageList);

    assertSame(1, typeImagedtoList.get(0).getIdTypeImage());
    assertSame(1, typeImagedtoList.get(1).getIdTypeImage());
    assertNull(typeImagedtoList.get(0).getName());
    assertNull(typeImagedtoList.get(1).getName());
    assertNull(typeImagedtoList.get(0).getCreationDate());
    assertNull(typeImagedtoList.get(1).getCreationDate());
    assertNull(typeImagedtoList.get(0).getModificationDate());
    assertNull(typeImagedtoList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de TypeImageDto à une liste de TypeImage")
  void testConvertListTypeImageDTOToListTypeImage() {

    List<TypeImagedto> typeImagedtoList = List.of(createSampleTypeImageDTO(), createSampleTypeImageDTO());
    List<TypeImage> typeImageList = typeImageConvert.convertListDtoToListEntity(typeImagedtoList);

    assertSame(1, typeImageList.get(0).getIdTypeImage());
    assertSame(1, typeImageList.get(1).getIdTypeImage());
    assertSame(name, typeImageList.get(0).getName());
    assertSame(name, typeImageList.get(1).getName());
    assertSame(typeImagedtoList.get(0).getCreationDate(), typeImageList.get(0).getCreationDate());
    assertSame(typeImagedtoList.get(1).getCreationDate(), typeImageList.get(1).getCreationDate());
    assertSame(typeImagedtoList.get(0).getModificationDate(), typeImageList.get(0).getModificationDate());
    assertSame(typeImagedtoList.get(1).getModificationDate(), typeImageList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de TypeImageDto à une liste de TypeImage quand la liste de TypeImageDto est null")
  void testConvertListTypeImageDTOToListTypeImageWithNull() {

    List<TypeImagedto> typeImagedtoList = List.of(createSampleTypeImageDTOWithNull(), createSampleTypeImageDTOWithNull());
    List<TypeImage> typeImageList = typeImageConvert.convertListDtoToListEntity(typeImagedtoList);

    assertSame(1, typeImageList.get(0).getIdTypeImage());
    assertSame(1, typeImageList.get(1).getIdTypeImage());
    assertNull(typeImageList.get(0).getName());
    assertNull(typeImageList.get(1).getName());
    assertNull(typeImageList.get(0).getCreationDate());
    assertNull(typeImageList.get(1).getCreationDate());
    assertNull(typeImageList.get(0).getModificationDate());
    assertNull(typeImageList.get(1).getModificationDate());
  }
}
