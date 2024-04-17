package co.simplon.gamebotsback.presentation.controller.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.business.service.game.IGameService;

@RestController
public class GetAllGameController {

    private final IGameService gameService;

    @Autowired
    public GetAllGameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<GameDTO> findAllGames() {
        return gameService.getAll();
    }

}
