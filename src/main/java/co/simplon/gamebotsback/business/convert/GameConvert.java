package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to convert
 * between GameDTO objects and Game entities.
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
   * Converts a Game entity to a GameDTO.
   *
   * @param entity the Game entity to convert
   * @return the converted GameDTO
   */
  public GameDTO convertEntityToDto(final Game entity) {
    final GameDTO dto = new GameDTO();
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
   * Converts a GameDTO to a Game entity.
   *
   * @param dto the GameDTO to convert
   * @return the converted Game entity
   */
  public Game convertDtoToEntity(final GameDTO dto) {
    final Game entity = new Game();
    entity.setIdGame(dto.getIdGame());
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
   * Converts a list of GameDTO objects to a list of Game entities.
   *
   * @param dtoList the list of GameDTO objects to convert
   * @return the list of converted Game entities
   */
  public List<Game> convertListDtoToListEntity(final List<GameDTO> dtoList) {
    final List<Game> entityList = new ArrayList<>();
    for (GameDTO dto : dtoList) {
      entityList.add(convertDtoToEntity(dto));
    }

    return entityList;
  }

  /**
   * Converts a list of Game entities to a list of GameDTO objects.
   *
   * @param entityList the list of Game entities to convert
   * @return the list of converted GameDTO objects
   */
  public List<GameDTO> convertListEntityToListDto(final List<Game> entityList) {
    final List<GameDTO> dtoList = new ArrayList<>();
    for (Game entity : entityList) {
      dtoList.add(convertEntityToDto(entity));
    }

    return dtoList;
  }

}
