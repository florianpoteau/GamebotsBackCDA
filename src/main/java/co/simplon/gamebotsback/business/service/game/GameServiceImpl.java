package co.simplon.gamebotsback.business.service.game;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.repository.game.IGameRepository;

@Service
public class GameServiceImpl implements IGameService {

    private IGameRepository gameRepository;

    @Autowired
    public GameServiceImpl(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameDTO> getAll() {
        final List<Game> result = gameRepository.findAll();
        return GameConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public GameDTO getById(int id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        Game game = optionalGame.get();
        return GameConvert.getInstance().convertEntityToDto(game);
    }

}
