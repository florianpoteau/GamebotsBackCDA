package co.simplon.gamebotsback.business.service.game;

import co.simplon.gamebotsback.business.dto.Gamedto;
import java.util.List;

/**
 * The <code>IGameService</code> interface
 * defines operations available for managing games.
 */
public interface Igameservice {

  /**
   * Retrieves all available games.
   *
   * @return A list of available games.
   */
  List<Gamedto> getAllGames();

  /**
   * Retrieves information about a game based on its ID.
   *
   * @param gameId
   *     The ID of the game.
   *
   * @return Information about the game corresponding to the given ID.
   */
  Gamedto getGameByGameId(int gameId);
}
