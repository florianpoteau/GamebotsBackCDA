package co.simplon.gamebotsback.business.service.game;

import java.util.List;

import co.simplon.gamebotsback.business.dto.GameDTO;

public interface IGameService {

    List<GameDTO> getAll();

    GameDTO getById(final int id);

}
