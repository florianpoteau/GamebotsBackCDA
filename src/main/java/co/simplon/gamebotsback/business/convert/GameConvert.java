package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.persistance.entity.Game;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to convert
 * between Gamedto objects and Game entities.
 */
public final class GameConvert {

  /**
   * The singleton instance of the ConversationConvert class.
   */
  private static GameConvert instance;

  /**
   * Private constructor to prevent instantiation from outside the class.
   */
  private GameConvert() {
  }

  /**
   * Returns the singleton instance of GameConvert.
   *
   * @return the singleton instance of GameConvert
   */
  public static GameConvert getInstance() {
    if (instance == null) {
      instance = new GameConvert();
    }
    return instance;
  }

  /**
   * Converts a Game entity to a Gamedto.
   *
   * @param entity
   *     the Game entity to convert
   *
   * @return the converted Gamedto
   */
  public Gamedto convertEntityToDto(final Game entity) {
    final Gamedto dto = new Gamedto();
    dto.setIdGame(entity.getIdGame());
    dto.setTitle(entity.getTitle());
    dto.setStory(entity.getStory());
    dto.setNumberPlayers(entity.getNumberPlayers());
    dto.setOnline(entity.isOnline());
    dto.setPlatform(entity.getPlatform());
    dto.setReleaseDate(entity.getReleaseDate());
    dto.setStudio(entity.getStudio());
    dto.setCreationDate(entity.getCreationDate());
    dto.setModificationDate(entity.getModificationDate());

    return dto;
  }

  /**
   * Converts a Gamedto to a Game entity.
   *
   * @param dto
   *     the Gamedto to convert
   *
   * @return the converted Game entity
   */
  public Game convertDtoToEntity(final Gamedto dto) {
    final Game entity = new Game();
    dto.setIdGame(entity.getIdGame());
    entity.setTitle(dto.getTitle());
    entity.setStory(dto.getStory());
    entity.setNumberPlayers(dto.getNumberPlayers());
    entity.setOnline(dto.isOnline());
    entity.setPlatform(dto.getPlatform());
    entity.setReleaseDate(dto.getReleaseDate());
    entity.setStudio(dto.getStudio());
    entity.setCreationDate(dto.getCreationDate());
    entity.setModificationDate(dto.getModificationDate());

    return entity;
  }

  /**
   * Converts a list of Game entities to a list of Gamedto objects.
   *
   * @param entityList
   *     the list of Game entities to convert
   *
   * @return the list of converted Gamedto objects
   */
  public List<Gamedto> convertListEntityToListDto(final List<Game> entityList) {
    final List<Gamedto> dtoList = new ArrayList<>();
    for (Game entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }

    return dtoList;
  }

  /**
   * Converts a list of Gamedto objects to a list of Game entities.
   *
   * @param dtoList
   *     the list of Gamedto objects to convert
   *
   * @return the list of converted Game entities
   */
  public List<Game> convertListDtoToListEntity(final List<Gamedto> dtoList) {
    final List<Game> entityList = new ArrayList<>();
    for (Gamedto dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }

    return entityList;
  }
}
