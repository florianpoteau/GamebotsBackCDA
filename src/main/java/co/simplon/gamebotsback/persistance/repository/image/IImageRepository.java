/**
 * Repository interface for managing Image entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating Image entities.
 *
 * @param <Image>   The type of entity managed by this repository, which is Image.
 * @param <Integer> The type of the identifier property of the Image entity, which is Integer.
 *                  This represents the type of the primary key.
 */

package co.simplon.gamebotsback.persistance.repository.image;

import co.simplon.gamebotsback.persistance.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Integer> {
}
