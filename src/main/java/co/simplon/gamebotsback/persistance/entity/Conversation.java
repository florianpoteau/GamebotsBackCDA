package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Conversation entity in the persistence layer.
 * This class is mapped to the "conversations" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "conversations")
public class Conversation {

  /**
   * The maximum length for string fields in the Conversation entity.
   */
  private static final int LENGTH = 50;
  /**
   * The unique identifier of the conversation.
   * -- GETTER --
   * Retrieves the ID of the conversation.
   * -- SETTER --
   * Sets the ID of the conversation.
   */
  @Id
  @Column(name = "id_conversation")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idConversation;

  /**
   * The name of the conversation.
   * -- GETTER --
   * Retrieves the name of the conversation.
   * -- SETTER --
   * Sets the name of the conversation.
   */
  @Basic
  @Column(name = "name", length = LENGTH)
  private String name;

  /**
   * The creation date of the conversation.
   * -- GETTER --
   * Retrieves the creation date of the conversation.
   * -- SETTER --
   * Sets the creation date of the conversation.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The modification date of the conversation.
   * -- GETTER --
   * Retrieves the modification date of the conversation.
   * -- SETTER --
   * Sets the modification date of the conversation.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The user associated with the conversation.
   * -- GETTER --
   * Retrieves the user associated with the conversation.
   * -- SETTER --
   * Sets the user associated with the conversation.
   */
  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;

  /**
   * The game associated with the conversation.
   * -- GETTER --
   * Retrieves the game associated with the conversation.
   * -- SETTER --
   * Sets the game associated with the conversation.
   */
  @ManyToOne
  @JoinColumn(name = "id_game")
  private Game game;
}
