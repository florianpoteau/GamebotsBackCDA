package co.simplon.gamebotsback.presentation.controller.game;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.Igameservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP requests
 * related to retrieving all games.
 */
@RestController
public class GetAllGameController {

  /**
   * The game service used for game-related operations.
   */
  private final Igameservice gameService;

  /**
   * Constructor for the GetAllGameController.
   *
   * @param serviceGame
   *     The service responsible for retrieving game information.
   */
  @Autowired
  public GetAllGameController(
      final Igameservice serviceGame) {
    this.gameService = serviceGame;
  }

  /**
   * Handles HTTP GET requests to retrieve all games.
   *
   * @return A list of DTOs representing all games.
   */
  @GetMapping("/games")
  public List<Gamedto> findAllGames() {
    return gameService.getAll();
  }

}
