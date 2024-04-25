/**
 * Controller class responsible for handling HTTP requests related to retrieving all games.
 */
package co.simplon.gamebotsback.presentation.controller.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.IGameService;

@RestController
public class GetAllGameController {

  private final IGameService gameService;

  /**
   * Constructor for the GetAllGameController.
   *
   * @param gameService The service responsible for retrieving game information.
   */
  @Autowired
  public GetAllGameController(IGameService gameService) {
    this.gameService = gameService;
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
