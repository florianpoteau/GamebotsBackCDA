/**
 * Repository interface for managing Game entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Game entities.
 *
 * @param <Game>     The type of entity managed by this repository, which is Game.
 * @param <Integer>  The type of the identifier property of the Game entity, which is Integer.
 *                   This represents the type of the primary key.
 */

package co.simplon.gamebotsback.persistance.repository.game;

import co.simplon.gamebotsback.persistance.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Integer> {
}
