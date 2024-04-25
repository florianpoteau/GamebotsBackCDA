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
 * Represents a Conversation entity in the persistence layer.
 * This class is mapped to the "conversations" table in the database.
 */
@Entity
@Table(name = "conversations")
public class Conversation {

  /**
   * The maximum length for string fields in the Conversation entity.
   */
  private static final int LENGTH = 50;
  /**
   * The unique identifier of the conversation.
   */
  @Id
  @Column(name = "id_conversation")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idConversation;

  /**
   * The name of the conversation.
   */
  @Basic
  @Column(name = "name", length = LENGTH)
  private String name;

  /**
   * The creation date of the conversation.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The modification date of the conversation.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The user associated with the conversation.
   */
  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;

  /**
   * The game associated with the conversation.
   */
  @ManyToOne
  @JoinColumn(name = "id_game")
  private Game game;

  /**
   * Retrieves the ID of the conversation.
   *
   * @return The ID of the conversation.
   */
  public int getIdConversation() {
    return idConversation;
  }

  /**
   * Sets the ID of the conversation.
   *
   * @param conversationId The ID of the conversation to set.
   */
  public void setIdConversation(final int conversationId) {
    this.idConversation = conversationId;
  }

  /**
   * Retrieves the name of the conversation.
   *
   * @return The name of the conversation.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the conversation.
   *
   * @param conversationName The name of the conversation to set.
   */
  public void setName(final String conversationName) {
    this.name = conversationName;
  }

  /**
   * Retrieves the creation date of the conversation.
   *
   * @return The creation date of the conversation.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the conversation.
   *
   * @param conversationCreationDate The creation date of
   *                                 the conversation to set.
   */
  public void setCreationDate(final Date conversationCreationDate) {
    this.creationDate = conversationCreationDate;
  }

  /**
   * Retrieves the modification date of the conversation.
   *
   * @return The modification date of the conversation.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the conversation.
   *
   * @param conversationModificationDate The modification date of
   *                                     the conversation to set.
   */
  public void setModificationDate(final Date conversationModificationDate) {
    this.modificationDate = conversationModificationDate;
  }

  /**
   * Retrieves the user associated with the conversation.
   *
   * @return The user associated with the conversation.
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the user associated with the conversation.
   *
   * @param conversationUser The user associated with the conversation to set.
   */
  public void setUser(final User conversationUser) {
    this.user = conversationUser;
  }

  /**
   * Retrieves the game associated with the conversation.
   *
   * @return The game associated with the conversation.
   */
  public Game getGame() {
    return game;
  }

  /**
   * Sets the game associated with the conversation.
   *
   * @param conversationGame The game associated with the conversation to set.
   */
  public void setGame(final Game conversationGame) {
    this.game = conversationGame;
  }
}
