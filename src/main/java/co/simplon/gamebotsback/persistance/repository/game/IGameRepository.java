package co.simplon.gamebotsback.persistance.repository.game;

import co.simplon.gamebotsback.persistance.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Integer> {
}
