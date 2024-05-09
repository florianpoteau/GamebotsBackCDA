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
 * Represents a Message entity in the persistence layer.
 * This class is mapped to the "messages" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

  /**
   * The unique identifier of the message.
   * -- GETTER --
   * Retrieves the ID of the Message.
   * -- SETTER --
   * Sets the ID of the Message.
   */
  @Id
  @Column(name = "id_message")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idMessage;

  /**
   * The content of the message.
   * -- GETTER --
   * Retrieves the content of the Message.
   * -- SETTER --
   * Sets the content of the Message.
   */
  @Basic
  @Column(name = "content")
  private String content;

  /**
   * The creation date of the message.
   * -- GETTER --
   * Retrieves the creation date of the Message.
   * -- SETTER --
   * Sets the creation date of the Message.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the message.
   * -- GETTER --
   * Retrieves the modification date of the Message.
   * -- SETTER --
   * Sets the modification date of the Message.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The conversation associated with the message.
   * -- GETTER --
   * Retrieves the conversation associated with the Message.
   * -- SETTER --
   * Sets the conversation associated with the Message.
   */
  @ManyToOne
  @JoinColumn(name = "id_conversation")
  private Conversation conversation;
}
