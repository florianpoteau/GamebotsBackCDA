package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.Imagedto;
import co.simplon.gamebotsback.persistance.entity.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * This class provides methods to convert
 * between Imagedto objects and Image entities.
 */
public final class ImageConvert {

  /**
   * The singleton instance of the ConversationConvert class.
   */
  private static ImageConvert instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private ImageConvert() {
  }

  /**
   * Returns the singleton instance of ImageConvert.
   *
   * @return the singleton instance of ImageConvert
   */
  public static ImageConvert getInstance() {
    if (instance == null) {
      instance = new ImageConvert();
    }
    return instance;
  }

  /**
   * Converts an Image entity to an Imagedto.
   *
   * @param entity the Image entity to convert
   * @return the converted Imagedto
   */
  public Imagedto convertEntityToDto(final Image entity) {
    final Imagedto dto = new Imagedto();
    dto.setIdImage(entity.getIdImage());
    dto.setName(entity.getName());
    dto.setSource(entity.getSource());
    dto.setTypeImage(entity.getTypeImage());
    dto.setGame(entity.getGame());
    dto.setCreationDate(entity.getCreationDate());
    dto.setModificationDate(entity.getModificationDate());

    return dto;
  }

  /**
   * Converts an Imagedto to an Image entity.
   *
   * @param dto the Imagedto to convert
   * @return the converted Image entity
   */
  public Image convertDtoToEntity(final Imagedto dto) {
    final Image entity = new Image();
    entity.setIdImage(dto.getIdImage());
    entity.setName(dto.getName());
    entity.setSource(dto.getSource());
    entity.setTypeImage(dto.getTypeImage());
    entity.setGame(dto.getGame());
    entity.setCreationDate(dto.getCreationDate());
    entity.setModificationDate(dto.getModificationDate());

    return entity;
  }

  /**
   * Converts a list of Imagedto objects to a list of Image entities.
   *
   * @param dtoList the list of Imagedto objects to convert
   * @return the list of converted Image entities
   */
  public List<Image> convertListDtoToListEntity(final List<Imagedto> dtoList) {
    final List<Image> entityList = new ArrayList<>();
    for (Imagedto dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }

    return entityList;
  }

  /**
   * Converts a list of Image entities to a list of Imagedto objects.
   *
   * @param entityList the list of Image entities to convert
   * @return the list of converted Imagedto objects
   */
  public List<Imagedto> convertListEntityToListDto(
      final List<Image> entityList) {
    final List<Imagedto> dtoList = new ArrayList<>();
    for (Image entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }

    return dtoList;
  }

}
