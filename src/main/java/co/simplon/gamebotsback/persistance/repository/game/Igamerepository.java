package co.simplon.gamebotsback.persistance.repository.game;

import co.simplon.gamebotsback.persistance.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Game entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic
 * CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Game entities.
 */

public interface Igamerepository extends JpaRepository<Game, Integer> {
}
