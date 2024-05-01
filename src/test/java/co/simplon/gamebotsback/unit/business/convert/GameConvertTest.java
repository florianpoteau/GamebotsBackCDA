package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.persistance.entity.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameConvertTest {

  private static final GameConvert gameConvert = GameConvert.getInstance();

  private static final String title = "The Last Of Us";
  private static final String story = "Jeu de Zombie qui fait peur";
  private static final String platform = "Playstation";
  private static final String studio = "Naughty Dog";

  private Game createSampleGame() {

    Game game = new Game();

    game.setIdGame(1);
    game.setTitle(title);
    game.setStory(story);
    game.setNumberPlayers(1);
    game.setOnline(false);
    game.setPlatform(platform);
    game.setReleaseDate(new Date());
    game.setStudio(studio);
    game.setCreationDate(new Date());
    game.setModificationDate(new Date());

    return game;
  }

  private Game createSampleGameWithNull() {

    Game game = new Game();

    game.setIdGame(1);
    game.setTitle(null);
    game.setStory(null);
    game.setNumberPlayers(1);
    game.setOnline(false);
    game.setPlatform(null);
    game.setReleaseDate(null);
    game.setStudio(null);
    game.setCreationDate(null);
    game.setModificationDate(null);

    return game;
  }

  private Gamedto createSampleGameDTO() {

    Gamedto gameDTO = new Gamedto();

    gameDTO.setIdGame(1);
    gameDTO.setTitle(title);
    gameDTO.setStory(story);
    gameDTO.setNumberPlayers(1);
    gameDTO.setOnline(false);
    gameDTO.setPlatform(platform);
    gameDTO.setReleaseDate(new Date());
    gameDTO.setStudio(studio);
    gameDTO.setCreationDate(new Date());
    gameDTO.setModificationDate(new Date());

    return gameDTO;
  }

  private Gamedto createSampleGameDTOWithNull() {

    Gamedto gameDTO = new Gamedto();

    gameDTO.setIdGame(1);
    gameDTO.setTitle(null);
    gameDTO.setStory(null);
    gameDTO.setNumberPlayers(1);
    gameDTO.setOnline(false);
    gameDTO.setPlatform(null);
    gameDTO.setReleaseDate(null);
    gameDTO.setStudio(null);
    gameDTO.setCreationDate(null);
    gameDTO.setModificationDate(null);

    return gameDTO;
  }

  @Test
  @DisplayName("Test de récupération de l'instance de GameConvert")
  void testGetInstanceReturnsInstanceOfGameConvert() {

    GameConvert gameConvert = GameConvert.getInstance();

    assertNotNull(gameConvert);
    assertInstanceOf(GameConvert.class, gameConvert);
  }

  @Test
  @DisplayName("Test de conversion de Game à GameDto")
  void testConvertGameToGameDto() {

    Game game = createSampleGame();
    Gamedto gameDTO = gameConvert.convertEntityToDto(game);

    assertEquals(1, gameDTO.getIdGame());
    assertEquals(title, gameDTO.getTitle());
    assertEquals(story, gameDTO.getStory());
    assertEquals(1, gameDTO.getNumberPlayers());
    assertFalse(gameDTO.isOnline());
    assertEquals(platform, gameDTO.getPlatform());
    assertEquals(game.getReleaseDate(), gameDTO.getReleaseDate());
    assertEquals(studio, gameDTO.getStudio());
    assertEquals(game.getCreationDate(), gameDTO.getCreationDate());
    assertEquals(game.getModificationDate(), gameDTO.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversion de Game à Game quand GameDto est null")
  void testConvertGameToGameDtoWithNull() {

    Game game = createSampleGameWithNull();
    Gamedto gameDTO = gameConvert.convertEntityToDto(game);

    assertEquals(1, gameDTO.getIdGame());
    assertNull(gameDTO.getTitle());
    assertNull(gameDTO.getStory());
    assertEquals(1, gameDTO.getNumberPlayers());
    assertFalse(gameDTO.isOnline());
    assertNull(gameDTO.getPlatform());
    assertNull(gameDTO.getReleaseDate());
    assertNull(gameDTO.getStudio());
    assertNull(gameDTO.getCreationDate());
    assertNull(gameDTO.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation de GameDTO à Game")
  void testConvertGameDtoToGame() {

    Gamedto gameDTO = createSampleGameDTO();
    Game game = gameConvert.convertDtoToEntity(gameDTO);

    assertEquals(1, game.getIdGame());
    assertEquals(title, game.getTitle());
    assertEquals(story, game.getStory());
    assertEquals(1, game.getNumberPlayers());
    assertFalse(game.isOnline());
    assertEquals(platform, game.getPlatform());
    assertEquals(gameDTO.getReleaseDate(), game.getReleaseDate());
    assertEquals(studio, game.getStudio());
    assertEquals(gameDTO.getCreationDate(), game.getCreationDate());
    assertEquals(gameDTO.getModificationDate(), game.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation de GameDTO à Game quand GameDto est null")
  void testConvertGameDtoToGameWithNull() {

    Gamedto gameDTO = createSampleGameDTOWithNull();
    Game game = gameConvert.convertDtoToEntity(gameDTO);

    assertEquals(1, game.getIdGame());
    assertNull(game.getTitle());
    assertNull(game.getStory());
    assertEquals(1, game.getNumberPlayers());
    assertFalse(game.isOnline());
    assertNull(game.getPlatform());
    assertNull(game.getReleaseDate());
    assertNull(game.getStudio());
    assertNull(game.getCreationDate());
    assertNull(game.getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Game à une liste de GameDto")
  void testConvertListGameToListGameDto() {

    List<Game> gameList = List.of(createSampleGame(), createSampleGame());
    List<Gamedto> gamedtoList = gameConvert.convertListEntityToListDto(gameList);

    assertEquals(1, gamedtoList.get(0).getIdGame());
    assertEquals(1, gamedtoList.get(1).getIdGame());
    assertEquals(title, gamedtoList.get(0).getTitle());
    assertEquals(title, gamedtoList.get(1).getTitle());
    assertEquals(story, gamedtoList.get(0).getStory());
    assertEquals(story, gamedtoList.get(1).getStory());
    assertEquals(1, gamedtoList.get(0).getNumberPlayers());
    assertEquals(1, gamedtoList.get(1).getNumberPlayers());
    assertFalse(gamedtoList.get(0).isOnline());
    assertFalse(gamedtoList.get(1).isOnline());
    assertEquals(platform, gamedtoList.get(0).getPlatform());
    assertEquals(platform, gamedtoList.get(1).getPlatform());
    assertEquals(gameList.get(0).getReleaseDate(), gamedtoList.get(0).getReleaseDate());
    assertEquals(gameList.get(1).getReleaseDate(), gamedtoList.get(1).getReleaseDate());
    assertEquals(studio, gamedtoList.get(0).getStudio());
    assertEquals(studio, gamedtoList.get(1).getStudio());
    assertEquals(gameList.get(0).getCreationDate(), gamedtoList.get(0).getCreationDate());
    assertEquals(gameList.get(1).getCreationDate(), gamedtoList.get(1).getCreationDate());
    assertEquals(gameList.get(0).getModificationDate(), gamedtoList.get(0).getModificationDate());
    assertEquals(gameList.get(1).getModificationDate(), gamedtoList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de Game à une liste de GameDto quand la liste de Game est null")
  void testConvertListGameToListGameDtoWithNull() {

    List<Game> gameList = List.of(createSampleGameWithNull(), createSampleGameWithNull());
    List<Gamedto> gamedtoList = gameConvert.convertListEntityToListDto(gameList);

    assertEquals(1, gamedtoList.get(0).getIdGame());
    assertEquals(1, gamedtoList.get(1).getIdGame());
    assertNull(gamedtoList.get(0).getTitle());
    assertNull(gamedtoList.get(1).getTitle());
    assertNull(gamedtoList.get(0).getStory());
    assertNull(gamedtoList.get(1).getStory());
    assertEquals(1, gamedtoList.get(0).getNumberPlayers());
    assertEquals(1, gamedtoList.get(1).getNumberPlayers());
    assertFalse(gamedtoList.get(0).isOnline());
    assertFalse(gamedtoList.get(1).isOnline());
    assertNull(gamedtoList.get(0).getPlatform());
    assertNull(gamedtoList.get(1).getPlatform());
    assertNull(gamedtoList.get(0).getReleaseDate());
    assertNull(gamedtoList.get(1).getReleaseDate());
    assertNull(gamedtoList.get(0).getStudio());
    assertNull(gamedtoList.get(1).getStudio());
    assertNull(gamedtoList.get(0).getCreationDate());
    assertNull(gamedtoList.get(1).getCreationDate());
    assertNull(gamedtoList.get(0).getModificationDate());
    assertNull(gamedtoList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de GameDto à une liste de Game")
  void testConvertListGameDtoToListGame() {

    List<Gamedto> gamedtoList = List.of(createSampleGameDTO(), createSampleGameDTO());
    List<Game> gameList = gameConvert.convertListDtoToListEntity(gamedtoList);

    assertEquals(1, gameList.get(0).getIdGame());
    assertEquals(1, gameList.get(1).getIdGame());
    assertEquals(title, gameList.get(0).getTitle());
    assertEquals(title, gameList.get(1).getTitle());
    assertEquals(story, gameList.get(0).getStory());
    assertEquals(story, gameList.get(1).getStory());
    assertEquals(1, gameList.get(0).getNumberPlayers());
    assertEquals(1, gameList.get(1).getNumberPlayers());
    assertFalse(gameList.get(0).isOnline());
    assertFalse(gameList.get(1).isOnline());
    assertEquals(platform, gameList.get(0).getPlatform());
    assertEquals(platform, gameList.get(1).getPlatform());
    assertEquals(gamedtoList.get(0).getReleaseDate(), gameList.get(0).getReleaseDate());
    assertEquals(gamedtoList.get(0).getReleaseDate(), gameList.get(1).getReleaseDate());
    assertEquals(studio, gameList.get(0).getStudio());
    assertEquals(studio, gameList.get(1).getStudio());
    assertEquals(gamedtoList.get(0).getCreationDate(), gameList.get(0).getCreationDate());
    assertEquals(gamedtoList.get(0).getCreationDate(), gameList.get(1).getCreationDate());
    assertEquals(gamedtoList.get(0).getModificationDate(), gameList.get(0).getModificationDate());
    assertEquals(gamedtoList.get(0).getModificationDate(), gameList.get(1).getModificationDate());
  }

  @Test
  @DisplayName("Test de conversation d'une liste de GameDto à une liste de Game quand la liste de GameDto est null")
  void testConvertListGameDtoToListGameWithNull() {

    List<Gamedto> gamedtoList = List.of(createSampleGameDTOWithNull(), createSampleGameDTOWithNull());
    List<Game> gameList = gameConvert.convertListDtoToListEntity(gamedtoList);

    assertEquals(1, gameList.get(0).getIdGame());
    assertEquals(1, gameList.get(1).getIdGame());
    assertNull(gameList.get(0).getTitle());
    assertNull(gameList.get(1).getTitle());
    assertNull(gameList.get(0).getStory());
    assertNull(gameList.get(1).getStory());
    assertEquals(1, gameList.get(0).getNumberPlayers());
    assertEquals(1, gameList.get(1).getNumberPlayers());
    assertFalse(gameList.get(0).isOnline());
    assertFalse(gameList.get(1).isOnline());
    assertNull(gameList.get(0).getPlatform());
    assertNull(gameList.get(1).getPlatform());
    assertNull(gameList.get(0).getReleaseDate());
    assertNull(gameList.get(1).getReleaseDate());
    assertNull(gameList.get(0).getStudio());
    assertNull(gameList.get(1).getStudio());
    assertNull(gameList.get(0).getCreationDate());
    assertNull(gameList.get(1).getCreationDate());
    assertNull(gameList.get(0).getModificationDate());
    assertNull(gameList.get(1).getModificationDate());
  }
}
