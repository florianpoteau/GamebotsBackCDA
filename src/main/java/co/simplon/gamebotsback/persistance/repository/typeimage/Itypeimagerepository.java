package co.simplon.gamebotsback.persistance.repository.typeimage;

import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing TypeImage
 * entities in the persistence layer.
 * This interface extends JpaRepository,
 * providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating TypeImage entities.
 */
public interface Itypeimagerepository extends
    JpaRepository<TypeImage, Integer> {
}
