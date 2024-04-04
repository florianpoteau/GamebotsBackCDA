/**
 * Repository interface for managing TypeImage entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating TypeImage entities.
 *
 * @param <TypeImage> The type of entity managed by this repository, which is TypeImage.
 * @param <Integer>    The type of the identifier property of the TypeImage entity, which is Integer.
 *                     This represents the type of the primary key.
 */

package co.simplon.gamebotsback.persistance.repository.typeimage;

import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeImageRepository extends JpaRepository<TypeImage, Integer> {
}
