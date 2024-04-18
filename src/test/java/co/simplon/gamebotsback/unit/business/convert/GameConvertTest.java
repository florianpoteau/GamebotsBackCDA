package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameConvertTest {

    private static final GameConvert gameConvert = GameConvert.getInstance();

    private static final String Title = "The Last Of Us";
    private static final String Story = "Jeu de Zombie qui fait peur";
    private static final String Platform = "Playstation";
    private static final String Studio = "Naughty Dog";

    private Game createSampleGame() {
        Game game = new Game();
        game.setIdGame(1);
        game.setTitle(Title);
        game.setStory(Story);
        game.setNumberPlayers(1);
        game.setOnline(false);
        game.setPlatform(Platform);
        game.setReleaseDate(new Date());
        game.setStudio(Studio);
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

    private GameDTO createSampleGameDTO() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setIdGame(1);
        gameDTO.setTitle(Title);
        gameDTO.setStory(Story);
        gameDTO.setNumberPlayers(1);
        gameDTO.setOnline(false);
        gameDTO.setPlatform(Platform);
        gameDTO.setReleaseDate(new Date());
        gameDTO.setStudio(Studio);
        gameDTO.setCreationDate(new Date());
        gameDTO.setModificationDate(new Date());
        return gameDTO;
    }

     private GameDTO createSampleGameDTOWithNull() {
            GameDTO gameDTO = new GameDTO();
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
    void testConvertGameToGameDTO() {

        Game game = createSampleGame();
        GameDTO gameDTO = gameConvert.convertEntityToDto(game);

        assertEquals(1, gameDTO.getIdGame());
        assertEquals(Title, gameDTO.getTitle());
        assertEquals(Story, gameDTO.getStory());
        assertEquals(1, gameDTO.getNumberPlayers());
        assertFalse(gameDTO.isOnline());
        assertEquals(Platform, gameDTO.getPlatform());
        assertEquals(game.getReleaseDate(), gameDTO.getReleaseDate());
        assertEquals(Studio, gameDTO.getStudio());
        assertEquals(game.getCreationDate(), gameDTO.getCreationDate());
        assertEquals(game.getModificationDate(), gameDTO.getModificationDate());
    }

    @Test
    void testConvertGameToGameDTOWithNull() {

        Game game = createSampleGameWithNull();
        GameDTO gameDTO = gameConvert.convertEntityToDto(game);

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
    void testConvertGameDTOToGame() {

        GameDTO gameDTO = createSampleGameDTO();
        Game game = gameConvert.convertDtoToEntity(gameDTO);

        assertEquals(1, game.getIdGame());
        assertEquals(Title, game.getTitle());
        assertEquals(Story, game.getStory());
        assertEquals(1, game.getNumberPlayers());
        assertFalse(game.isOnline());
        assertEquals(Platform, game.getPlatform());
        assertEquals(gameDTO.getReleaseDate(), game.getReleaseDate());
        assertEquals(Studio, game.getStudio());
        assertEquals(gameDTO.getCreationDate(), game.getCreationDate());
        assertEquals(gameDTO.getModificationDate(), game.getModificationDate());
    }

    @Test
    void testConvertGameDTOToGameWithNull() {

        GameDTO gameDTO = createSampleGameDTOWithNull();
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
    void testConvertListGameToListGameDTO() {

        List<Game> gameList = List.of(createSampleGame(), createSampleGame());
        List<GameDTO> gameDTOList = gameConvert.convertListEntityToListDto(gameList);

        assertEquals(1, gameDTOList.get(0).getIdGame());
        assertEquals(1, gameDTOList.get(1).getIdGame());
        assertEquals(Title, gameDTOList.get(0).getTitle());
        assertEquals(Title, gameDTOList.get(1).getTitle());
        assertEquals(Story, gameDTOList.get(0).getStory());
        assertEquals(Story, gameDTOList.get(1).getStory());
        assertEquals(1, gameDTOList.get(0).getNumberPlayers());
        assertEquals(1, gameDTOList.get(1).getNumberPlayers());
        assertFalse(gameDTOList.get(0).isOnline());
        assertFalse(gameDTOList.get(1).isOnline());
        assertEquals(Platform, gameDTOList.get(0).getPlatform());
        assertEquals(Platform, gameDTOList.get(1).getPlatform());
        assertEquals(gameList.get(0).getReleaseDate(), gameDTOList.get(0).getReleaseDate());
        assertEquals(gameList.get(1).getReleaseDate(), gameDTOList.get(1).getReleaseDate());
        assertEquals(Studio, gameDTOList.get(0).getStudio());
        assertEquals(Studio, gameDTOList.get(1).getStudio());
        assertEquals(gameList.get(0).getCreationDate(), gameDTOList.get(0).getCreationDate());
        assertEquals(gameList.get(1).getCreationDate(), gameDTOList.get(1).getCreationDate());
        assertEquals(gameList.get(0).getModificationDate(), gameDTOList.get(0).getModificationDate());
        assertEquals(gameList.get(1).getModificationDate(), gameDTOList.get(1).getModificationDate());
    }

    @Test
    void testConvertListGameToListGameDTOWithNull() {

        List<Game> gameList = List.of(createSampleGameWithNull(), createSampleGameWithNull());
        List<GameDTO> gameDTOList = gameConvert.convertListEntityToListDto(gameList);

        assertEquals(1, gameDTOList.get(0).getIdGame());
        assertEquals(1, gameDTOList.get(1).getIdGame());
        assertNull(gameDTOList.get(0).getTitle());
        assertNull(gameDTOList.get(1).getTitle());
        assertNull(gameDTOList.get(0).getStory());
        assertNull(gameDTOList.get(1).getStory());
        assertEquals(1, gameDTOList.get(0).getNumberPlayers());
        assertEquals(1, gameDTOList.get(1).getNumberPlayers());
        assertFalse(gameDTOList.get(0).isOnline());
        assertFalse(gameDTOList.get(1).isOnline());
        assertNull(gameDTOList.get(0).getPlatform());
        assertNull(gameDTOList.get(1).getPlatform());
        assertNull(gameDTOList.get(0).getReleaseDate());
        assertNull(gameDTOList.get(1).getReleaseDate());
        assertNull(gameDTOList.get(0).getStudio());
        assertNull(gameDTOList.get(1).getStudio());
        assertNull(gameDTOList.get(0).getCreationDate());
        assertNull(gameDTOList.get(1).getCreationDate());
        assertNull(gameDTOList.get(0).getModificationDate());
        assertNull(gameDTOList.get(1).getModificationDate());
    }

    @Test
    void testConvertListGameDTOToListGame() {

        List<GameDTO> gameDTOList = List.of(createSampleGameDTO(), createSampleGameDTO());
        List<Game> gameList = gameConvert.convertListDtoToListEntity(gameDTOList);

        assertEquals(1, gameList.get(0).getIdGame());
        assertEquals(1, gameList.get(1).getIdGame());
        assertEquals(Title, gameList.get(0).getTitle());
        assertEquals(Title, gameList.get(1).getTitle());
        assertEquals(Story, gameList.get(0).getStory());
        assertEquals(Story, gameList.get(1).getStory());
        assertEquals(1, gameList.get(0).getNumberPlayers());
        assertEquals(1, gameList.get(1).getNumberPlayers());
        assertFalse(gameList.get(0).isOnline());
        assertFalse(gameList.get(1).isOnline());
        assertEquals(Platform, gameList.get(0).getPlatform());
        assertEquals(Platform, gameList.get(1).getPlatform());
        assertEquals(gameDTOList.get(0).getReleaseDate(), gameList.get(0).getReleaseDate());
        assertEquals(gameDTOList.get(0).getReleaseDate(), gameList.get(1).getReleaseDate());
        assertEquals(Studio, gameList.get(0).getStudio());
        assertEquals(Studio, gameList.get(1).getStudio());
        assertEquals(gameDTOList.get(0).getCreationDate(), gameList.get(0).getCreationDate());
        assertEquals(gameDTOList.get(0).getCreationDate(), gameList.get(1).getCreationDate());
        assertEquals(gameDTOList.get(0).getModificationDate(), gameList.get(0).getModificationDate());
        assertEquals(gameDTOList.get(0).getModificationDate(), gameList.get(1).getModificationDate());
    }

    @Test
    void testConvertListGameDTOToListGameWithNull() {

        List<GameDTO> gameDTOList = List.of(createSampleGameDTOWithNull(), createSampleGameDTOWithNull());
        List<Game> gameList = gameConvert.convertListDtoToListEntity(gameDTOList);

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
