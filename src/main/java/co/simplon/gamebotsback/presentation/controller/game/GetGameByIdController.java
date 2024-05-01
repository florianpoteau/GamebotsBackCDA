package co.simplon.gamebotsback.presentation.controller.game;

import co.simplon.gamebotsback.business.dto.Gamedto;
import co.simplon.gamebotsback.business.service.game.Igameservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling
 * HTTP requests related to fetching a game by its ID.
 * This controller handles HTTP GET requests to retrieve a game by its ID.
 */
@RestController
public class GetGameByIdController {

  /**
   * The service responsible for retrieving game information.
   */
  private final Igameservice gameService;

  /**
   * Constructor for the GetGameByIdController.
   *
   * @param serviceGame
   *     The service responsible for retrieving game information.
   */
  @Autowired
  public GetGameByIdController(final Igameservice serviceGame) {
    this.gameService = serviceGame;
  }

  /**
   * Handles HTTP GET requests to retrieve a game by its ID.
   *
   * @param id
   *     The ID of the game to retrieve.
   *
   * @return The DTO representing the game with the specified ID.
   */
  @GetMapping("/games/{id}")
  public Gamedto findGameById(@PathVariable final int id) {
    return gameService.getById(id);
  }

}
