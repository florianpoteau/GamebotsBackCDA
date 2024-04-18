package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the GameConvert class.
 */
class GameConvertTest {

    private static final GameConvert gameConvert = GameConvert.getInstance();

    /**
     * Tests the conversion of a Game entity to a GameDTO.
     */
    @Test
    void testConvertGameToGameDTO() {
        Game game = new Game();
        game.setIdGame(1);
        game.setTitle("The Last Of Us");
        game.setStory("Jeu de Zombie qui fait peur");
        game.setNumberPlayers(1);
        game.setOnline(false);
        game.setPlatform("Playstation");
        Date releaseDate = new Date();
        game.setReleaseDate(releaseDate);
        game.setStudio("Naughty Dog");
        Date creationDate = new Date();
        game.setCreationDate(creationDate);
        game.setModificationDate(null);

        GameDTO gameDTO = gameConvert.convertEntityToDto(game);

        assertSame(1, gameDTO.getIdGame());
        assertSame("The Last Of Us", gameDTO.getTitle());
        assertSame("Jeu de Zombie qui fait peur", gameDTO.getStory());
        assertSame(1, gameDTO.getNumberPlayers());
        assertSame(false, gameDTO.isOnline());
        assertSame("Playstation", gameDTO.getPlatform());
        assertSame(releaseDate, gameDTO.getReleaseDate());
        assertSame("Naughty Dog", gameDTO.getStudio());
        assertSame(creationDate, gameDTO.getCreationDate());
        assertNull(gameDTO.getModificationDate());
    }

    /**
     * Tests the conversion of a GameDTO to a Game entity.
     */
    @Test
    void testConvertGameDTOToGame() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setIdGame(1);
        gameDTO.setTitle("The Last Of Us");
        gameDTO.setStory("Jeu de Zombie qui fait peur");
        gameDTO.setNumberPlayers(1);
        gameDTO.setOnline(false);
        gameDTO.setPlatform("Playstation");
        Date releaseDate = new Date();
        gameDTO.setReleaseDate(releaseDate);
        gameDTO.setStudio("Naughty Dog");
        Date creationDate = new Date();
        gameDTO.setCreationDate(creationDate);
        gameDTO.setModificationDate(null);

        Game game = gameConvert.convertDtoToEntity(gameDTO);

        assertSame(1, game.getIdGame());
        assertSame("The Last Of Us", game.getTitle());
        assertSame("Jeu de Zombie qui fait peur", game.getStory());
        assertSame(1, game.getNumberPlayers());
        assertSame(false, game.isOnline());
        assertSame("Playstation", game.getPlatform());
        assertSame(releaseDate, game.getReleaseDate());
        assertSame("Naughty Dog", game.getStudio());
        assertSame(creationDate, game.getCreationDate());
        assertNull(game.getModificationDate());
    }

    /**
     * Tests the conversion of a List Game entity to a List GameDTO.
     */
    @Test
    void testConvertListGameToListGameDTO() {
        Game game = new Game();
        game.setIdGame(1);
        game.setTitle("The Last Of Us");
        game.setStory("Jeu de Zombie qui fait peur");
        game.setNumberPlayers(1);
        game.setOnline(false);
        game.setPlatform("Playstation");
        Date releaseDate = new Date();
        game.setReleaseDate(releaseDate);
        game.setStudio("Naughty Dog");
        Date creationDate = new Date();
        game.setCreationDate(creationDate);
        game.setModificationDate(null);

        Game game2 = new Game();
        game2.setIdGame(2);
        game2.setTitle("The Last Of Us 2");
        game2.setStory("Jeu de Zombie qui fait peur et qui est triste");
        game2.setNumberPlayers(1);
        game2.setOnline(false);
        game2.setPlatform("Playstation");
        Date releaseDate2 = new Date();
        game2.setReleaseDate(releaseDate2);
        game2.setStudio("Naughty Dog");
        Date creationDate2 = new Date();
        game2.setCreationDate(creationDate2);
        game2.setModificationDate(null);

        List<Game> gameList = List.of(game, game2);

        List<GameDTO> gameDTOList = gameConvert.convertListEntityToListDto(gameList);

        assertSame(1, gameDTOList.get(0).getIdGame());
        assertSame(2, gameDTOList.get(1).getIdGame());
        assertSame("The Last Of Us", gameDTOList.get(0).getTitle());
        assertSame("The Last Of Us 2", gameDTOList.get(1).getTitle());
        assertSame("Jeu de Zombie qui fait peur", gameDTOList.get(0).getStory());
        assertSame("Jeu de Zombie qui fait peur et qui est triste", gameDTOList.get(1).getStory());
        assertSame(1, gameDTOList.get(0).getNumberPlayers());
        assertSame(1, gameDTOList.get(1).getNumberPlayers());
        assertSame(false, gameDTOList.get(0).isOnline());
        assertSame(false, gameDTOList.get(1).isOnline());
        assertSame("Playstation", gameDTOList.get(0).getPlatform());
        assertSame("Playstation", gameDTOList.get(1).getPlatform());
        assertSame(releaseDate, gameDTOList.get(0).getReleaseDate());
        assertSame(releaseDate2, gameDTOList.get(1).getReleaseDate());
        assertSame("Naughty Dog", gameDTOList.get(0).getStudio());
        assertSame("Naughty Dog", gameDTOList.get(1).getStudio());
        assertSame(creationDate, gameDTOList.get(0).getCreationDate());
        assertSame(creationDate2, gameDTOList.get(1).getCreationDate());
        assertNull(gameDTOList.get(0).getModificationDate());
        assertNull(gameDTOList.get(1).getModificationDate());
    }

    /**
     * Tests the conversion of a List GameDTO to a List Game entity.
     */
    @Test
    void testConvertListGameDTOToListGame() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setIdGame(1);
        gameDTO.setTitle("The Last Of Us");
        gameDTO.setStory("Jeu de Zombie qui fait peur");
        gameDTO.setNumberPlayers(1);
        gameDTO.setOnline(false);
        gameDTO.setPlatform("Playstation");
        Date releaseDate = new Date();
        gameDTO.setReleaseDate(releaseDate);
        gameDTO.setStudio("Naughty Dog");
        Date creationDate = new Date();
        gameDTO.setCreationDate(creationDate);
        gameDTO.setModificationDate(null);

        GameDTO gameDTO2 = new GameDTO();
        gameDTO2.setIdGame(2);
        gameDTO2.setTitle("The Last Of Us 2");
        gameDTO2.setStory("Jeu de Zombie qui fait peur et qui est triste");
        gameDTO2.setNumberPlayers(1);
        gameDTO2.setOnline(false);
        gameDTO2.setPlatform("Playstation");
        Date releaseDate2 = new Date();
        gameDTO2.setReleaseDate(releaseDate2);
        gameDTO2.setStudio("Naughty Dog");
        Date creationDate2 = new Date();
        gameDTO2.setCreationDate(creationDate2);
        gameDTO2.setModificationDate(null);

        List<GameDTO> gameDTOList = List.of(gameDTO, gameDTO2);

        List<Game> gameList = gameConvert.convertListDtoToListEntity(gameDTOList);

        assertSame(1, gameList.get(0).getIdGame());
        assertSame(2, gameList.get(1).getIdGame());
        assertSame("The Last Of Us", gameList.get(0).getTitle());
        assertSame("The Last Of Us 2", gameList.get(1).getTitle());
        assertSame("Jeu de Zombie qui fait peur", gameList.get(0).getStory());
        assertSame("Jeu de Zombie qui fait peur et qui est triste", gameList.get(1).getStory());
        assertSame(1, gameList.get(0).getNumberPlayers());
        assertSame(1, gameList.get(1).getNumberPlayers());
        assertSame(false, gameList.get(0).isOnline());
        assertSame(false, gameList.get(1).isOnline());
        assertSame("Playstation", gameList.get(0).getPlatform());
        assertSame("Playstation", gameList.get(1).getPlatform());
        assertSame(releaseDate, gameList.get(0).getReleaseDate());
        assertSame(releaseDate2, gameList.get(1).getReleaseDate());
        assertSame("Naughty Dog", gameList.get(0).getStudio());
        assertSame("Naughty Dog", gameList.get(1).getStudio());
        assertSame(creationDate, gameList.get(0).getCreationDate());
        assertSame(creationDate2, gameList.get(1).getCreationDate());
        assertNull(gameList.get(0).getModificationDate());
        assertNull(gameList.get(1).getModificationDate());
    }
}
