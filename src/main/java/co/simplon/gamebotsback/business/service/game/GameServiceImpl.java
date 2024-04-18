/**
 * Implementation of the <code>IGameService</code> interface providing functionalities for managing games.
 */
package co.simplon.gamebotsback.business.service.game;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.gamebotsback.business.convert.GameConvert;
import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.repository.game.IGameRepository;

/**
 * Implementation of the <code>IGameService</code> interface providing functionalities for managing games.
 */
@Service
public class GameServiceImpl implements IGameService {

    private final IGameRepository gameRepository;

    /**
     * Constructor for <code>GameServiceImpl</code>.
     *
     * @param gameRepository The repository used to access game data.
     */
    @Autowired
    public GameServiceImpl(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * Retrieves all available games.
     *
     * @return A list of available games.
     */
    @Override
    public List<GameDTO> getAll() {
        final List<Game> result = gameRepository.findAll();
        return GameConvert.getInstance().convertListEntityToListDto(result);
    }

    /**
     * Retrieves information about a game based on its ID.
     *
     * @param id The ID of the game.
     * @return Information about the game corresponding to the given ID.
     * @throws IllegalArgumentException if the game with the specified ID does not exist.
     */
    @Override
    public GameDTO getById(int id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return GameConvert.getInstance().convertEntityToDto(game);
        } else {
            throw new IllegalArgumentException("The game with the specified ID does not exist: " + id);
        }
    }

}
