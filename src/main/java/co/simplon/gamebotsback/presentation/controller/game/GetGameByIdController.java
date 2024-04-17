package co.simplon.gamebotsback.presentation.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.business.service.game.IGameService;

@RestController
public class GetGameByIdController {

    private IGameService gameService;

    @Autowired
    public GetGameByIdController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games/{id}")
    public GameDTO findGameById(@PathVariable int id) {
        return gameService.getById(id);
    }

}
