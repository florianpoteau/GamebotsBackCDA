package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.TypeImagedto;
import co.simplon.gamebotsback.persistance.entity.TypeImage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to convert
 * between TypeImageDTO objects and TypeImage entities.
 */
public final class TypeImageConvert {

  /**
   * The singleton instance of the ConversationConvert class.
   */
  private static TypeImageConvert instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private TypeImageConvert() {
  }

  /**
   * Returns the singleton instance of TypeImageConvert.
   *
   * @return the singleton instance of TypeImageConvert
   */
  public static TypeImageConvert getInstance() {
    if (instance == null) {
      instance = new TypeImageConvert();
    }
    return instance;
  }

  /**
   * Converts a TypeImage entity to a TypeImageDTO.
   *
   * @param entity the TypeImage entity to convert
   * @return the converted TypeImageDTO
   */
  public TypeImagedto convertEntityToDto(final TypeImage entity) {
    final TypeImagedto dto = new TypeImagedto();
    dto.setIdTypeImage(entity.getIdTypeImage());
    dto.setName(entity.getName());
    dto.setCreationDate(entity.getCreationDate());
    dto.setModificationDate(entity.getModificationDate());

    return dto;
  }

  /**
   * Converts a TypeImageDTO to a TypeImage entity.
   *
   * @param dto the TypeImageDTO to convert
   * @return the converted TypeImage entity
   */
  public TypeImage convertDtoToEntity(final TypeImagedto dto) {
    final TypeImage entity = new TypeImage();
    entity.setIdTypeImage(dto.getIdTypeImage());
    entity.setName(dto.getName());
    entity.setCreationDate(dto.getCreationDate());
    entity.setModificationDate(dto.getModificationDate());

    return entity;
  }

  /**
   * Converts a list of TypeImageDTO objects to a list of TypeImage entities.
   *
   * @param dtoList the list of TypeImageDTO objects to convert
   * @return the list of converted TypeImage entities
   */
  public List<TypeImage> convertListDtoToListEntity(
      final List<TypeImagedto> dtoList) {
    final List<TypeImage> entityList = new ArrayList<>();
    for (TypeImagedto dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }

    return entityList;
  }

  /**
   * Converts a list of TypeImage entities to a list of TypeImageDTO objects.
   *
   * @param entityList the list of TypeImage entities to convert
   * @return the list of converted TypeImageDTO objects
   */
  public List<TypeImagedto> convertListEntityToListDto(
      final List<TypeImage> entityList) {
    final List<TypeImagedto> dtoList = new ArrayList<>();
    for (TypeImage entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }

    return dtoList;
  }
}
