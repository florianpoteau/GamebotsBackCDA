/**
 * Controller class responsible for handling HTTP requests related to retrieving a game by its ID.
 */
package co.simplon.gamebotsback.presentation.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.IGameService;

@RestController
public class GetGameByIdController {

  private final IGameService gameService;

  /**
   * Constructor for the GetGameByIdController.
   *
   * @param gameService The service responsible for retrieving game information.
   */
  @Autowired
  public GetGameByIdController(IGameService gameService) {
    this.gameService = gameService;
  }

  /**
   * Handles HTTP GET requests to retrieve a game by its ID.
   *
   * @param id The ID of the game to retrieve.
   * @return The DTO representing the game with the specified ID.
   */
  @GetMapping("/games/{id}")
  public Gamedto findGameById(@PathVariable int id) {
    return gameService.getById(id);
  }

}
