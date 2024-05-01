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

/**
 * Represents a Message entity in the persistence layer.
 * This class is mapped to the "messages" table in the database.
 */
@Entity
@Table(name = "messages")
public class Message {

  /**
   * The unique identifier of the message.
   */
  @Id
  @Column(name = "id_message")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idMessage;

  /**
   * The content of the message.
   */
  @Basic
  @Column(name = "content")
  private String content;

  /**
   * The creation date of the message.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the message.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The conversation associated with the message.
   */
  @ManyToOne
  @JoinColumn(name = "id_conversation")
  private Conversation conversation;

  /**
   * Retrieves the ID of the Message.
   *
   * @return The ID of the Message.
   */
  public int getIdMessage() {
    return idMessage;
  }

  /**
   * Sets the ID of the Message.
   *
   * @param messageId
   *     The ID of the Message to set.
   */
  public void setIdMessage(final int messageId) {
    this.idMessage = messageId;
  }

  /**
   * Retrieves the content of the Message.
   *
   * @return The content of the Message.
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content of the Message.
   *
   * @param messageContent
   *     The content of the Message to set.
   */
  public void setContent(final String messageContent) {
    this.content = messageContent;
  }

  /**
   * Retrieves the creation date of the Message.
   *
   * @return The creation date of the Message.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the Message.
   *
   * @param messageCreationDate
   *     The creation date of the Message to set.
   */
  public void setCreationDate(final Date messageCreationDate) {
    this.creationDate = messageCreationDate;
  }

  /**
   * Retrieves the modification date of the Message.
   *
   * @return The modification date of the Message.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the Message.
   *
   * @param messageModificationDate
   *     The modification date of the Message to set.
   */
  public void setModificationDate(final Date messageModificationDate) {
    this.modificationDate = messageModificationDate;
  }

  /**
   * Retrieves the conversation associated with the Message.
   *
   * @return The conversation associated with the Message.
   */
  public Conversation getConversation() {
    return conversation;
  }

  /**
   * Sets the conversation associated with the Message.
   *
   * @param messageConversation
   *     The conversation to set.
   */
  public void setConversation(final Conversation messageConversation) {
    this.conversation = messageConversation;
  }
}
