/**
 * Repository interface for managing User entities in the persistence layer.
 * This interface extends JpaRepository, providing access to basic CRUD (Create, Read, Update, Delete) operations
 * and additional methods for querying and manipulating User entities.
 *
 * @param <User>    The type of entity managed by this repository, which is User.
 * @param <Integer> The type of the identifier property of the User entity, which is Integer.
 *                  This represents the type of the primary key.
 */
package co.simplon.gamebotsback.persistance.repository.user;

import co.simplon.gamebotsback.persistance.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves a user by username.
     *
     * @param username The username of the user.
     * @return An optional containing the user with the specified username, or empty
     *         if not found.
     */
    @Query(UserQueries.FIND_BY_USERNAME)
    Optional<User> findByUsername(final String username);

}
