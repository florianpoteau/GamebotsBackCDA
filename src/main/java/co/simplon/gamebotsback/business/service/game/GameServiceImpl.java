package co.simplon.gamebotsback.business.service.game;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.repository.game.Igamerepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of the <code>IGameService</code> interface
 * providing functionalities for managing games.
 */
@Service
public class GameServiceImpl implements Igameservice {

  /**
   * The repository used to access game data.
   */
  private final Igamerepository gameRepository;

  /**
   * Constructor for <code>GameServiceImpl</code>.
   *
   * @param repositoryGame
   *     The repository used to access game data.
   */
  @Autowired
  public GameServiceImpl(final Igamerepository repositoryGame) {
    this.gameRepository = repositoryGame;
  }

  /**
   * Retrieves all available games.
   *
   * @return A list of available games.
   */
  @Override
  public List<Gamedto> getAllGames() {
    final List<Game> result = gameRepository.findAll();
    return GameConvert.getInstance().convertListEntityToListDto(result);
  }

  /**
   * Retrieves information about a game based on its ID.
   *
   * @param gameId
   *     The ID of the game.
   *
   * @return Information about the game corresponding to the given ID.
   *
   * @throws IllegalArgumentException
   *     if the game with
   *     the specified ID does not exist.
   */
  @Override
  public Gamedto getGameByGameId(final int gameId) {
    Optional<Game> optionalGame = gameRepository.findById(gameId);
    if (optionalGame.isPresent()) {
      Game game = optionalGame.get();
      return GameConvert.getInstance().convertEntityToDto(game);
    } else {
      throw new IllegalArgumentException(
          "The game with the specified ID does not exist: " + gameId);
    }
  }

}
