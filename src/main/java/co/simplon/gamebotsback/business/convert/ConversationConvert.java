package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.Conversationdto;
import co.simplon.gamebotsback.persistance.entity.Conversation;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to convert between
 * Conversationdto objects and Conversation entities.
 */
public final class ConversationConvert {

  /**
   * The singleton instance of the ConversationConvert class.
   */
  private static ConversationConvert instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private ConversationConvert() {
  }

  /**
   * Returns the singleton instance of ConversationConvert.
   *
   * @return the singleton instance of ConversationConvert
   */
  public static ConversationConvert getInstance() {
    if (instance == null) {
      instance = new ConversationConvert();
    }
    return instance;
  }

  /**
   * Converts a Conversation entity to a Conversationdto.
   *
   * @param entity
   *     the Conversation entity to convert
   *
   * @return the converted Conversationdto
   */
  public Conversationdto convertEntityToDto(final Conversation entity) {
    final Conversationdto dto = new Conversationdto();
    dto.setIdConversation(entity.getIdConversation());
    dto.setName(entity.getName());
    dto.setCreationDate(entity.getCreationDate());
    dto.setModificationDate(entity.getModificationDate());
    dto.setGame(entity.getGame());
    dto.setUser(entity.getUser());
    return dto;
  }

  /**
   * Converts a Conversationdto to a Conversation entity.
   *
   * @param dto
   *     the Conversationdto to convert
   *
   * @return the converted Conversation entity
   */
  public Conversation convertDtoToEntity(final Conversationdto dto) {
    final Conversation entity = new Conversation();
    entity.setIdConversation(dto.getIdConversation());
    entity.setName(dto.getName());
    entity.setCreationDate(dto.getCreationDate());
    entity.setModificationDate(dto.getModificationDate());
    entity.setGame(dto.getGame());
    entity.setUser(dto.getUser());
    return entity;
  }

  /**
   * Converts a list of Conversation entities to a list of Conversationdto
   * objects.
   *
   * @param entityList
   *     the list of Conversation entities to convert
   *
   * @return the list of converted Conversationdto objects
   */
  public List<Conversationdto> convertListEntityToListDto(
      final List<Conversation> entityList) {
    final List<Conversationdto> dtoList = new ArrayList<>();
    for (Conversation entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }
    return dtoList;
  }

  /**
   * Converts a list of Conversationdto objects to a list of Conversation
   * entities.
   *
   * @param dtoList
   *     the list of Conversationdto objects to convert
   *
   * @return the list of converted Conversation entities
   */
  public List<Conversation> convertListDtoToListEntity(
      final List<Conversationdto> dtoList) {
    final List<Conversation> entityList = new ArrayList<>();
    for (Conversationdto dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }
    return entityList;
  }
}
