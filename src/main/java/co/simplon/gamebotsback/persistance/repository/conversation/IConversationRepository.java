package co.simplon.gamebotsback.persistance.repository.conversation;

import co.simplon.gamebotsback.persistance.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConversationRepository extends JpaRepository<Conversation, Integer> {
}
