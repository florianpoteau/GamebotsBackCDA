package co.simplon.gamebotsback.persistance.repository.message;

import co.simplon.gamebotsback.persistance.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepository extends JpaRepository<Message, Integer> {
}
