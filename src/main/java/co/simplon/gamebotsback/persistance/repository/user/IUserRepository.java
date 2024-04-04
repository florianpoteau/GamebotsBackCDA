package co.simplon.gamebotsback.persistance.repository.user;

import co.simplon.gamebotsback.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
