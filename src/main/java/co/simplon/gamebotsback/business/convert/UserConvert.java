package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.persistance.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to convert
 * between UserDTO objects and User entities.
 */
public final class UserConvert {
  /**
   * The singleton instance of the ConversationConvert class.
   */
  private static UserConvert instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private UserConvert() {
  }

  /**
   * Returns the singleton instance of UserConvert.
   *
   * @return the singleton instance of UserConvert
   */
  public static UserConvert getInstance() {
    if (instance == null) {
      instance = new UserConvert();
    }
    return instance;
  }

  /**
   * Converts a User entity to a UserDTO.
   *
   * @param entity
   *     the User entity to convert
   *
   * @return the converted UserDTO
   */
  public Userdto convertEntityToDto(final User entity) {
    final Userdto dto = new Userdto();
    dto.setIdUser(entity.getIdUser());
    dto.setUsername(entity.getUsername());
    dto.setPhone(entity.getPhone());
    dto.setEmail(entity.getEmail());
    dto.setPassword(entity.getPassword());
    dto.setCreationDate(entity.getCreationDate());
    dto.setModificationDate(entity.getModificationDate());
    dto.setImage(entity.getImage());

    return dto;
  }

  /**
   * Converts a UserDTO to a User entity.
   *
   * @param dto
   *     the UserDTO to convert
   *
   * @return the converted User entity
   */
  public User convertDtoToEntity(final Userdto dto) {
    final User entity = new User();
    entity.setIdUser(dto.getIdUser());
    entity.setUsername(dto.getUsername());
    entity.setPhone(dto.getPhone());
    entity.setEmail(dto.getEmail());
    entity.setPassword(dto.getPassword());
    entity.setCreationDate(dto.getCreationDate());
    entity.setModificationDate(dto.getModificationDate());
    entity.setImage(dto.getImage());

    return entity;
  }

  /**
   * Converts a list of User entities to a list of UserDTO objects.
   *
   * @param entityList
   *     the list of User entities to convert
   *
   * @return the list of converted UserDTO objects
   */
  public List<Userdto> convertListEntityToListDto(
      final List<User> entityList) {
    final List<Userdto> dtoList = new ArrayList<>();
    for (User entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }

    return dtoList;
  }

  /**
   * Converts a list of UserDTO objects to a list of User entities.
   *
   * @param dtoList
   *     the list of UserDTO objects to convert
   *
   * @return the list of converted User entities
   */
  public List<User> convertListDtoToListEntity(
      final List<Userdto> dtoList) {
    final List<User> entityList = new ArrayList<>();
    for (Userdto dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }

    return entityList;
  }
}
