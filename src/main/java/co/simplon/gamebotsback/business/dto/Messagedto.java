package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Conversation;
import java.util.Date;

/**
 * This class represents a dto for a message.
 */
public class Messagedto {

  /**
   * The identifier of the message.
   */
  private int idMessage;

  /**
   * The content of the message.
   */
  private String content;

  /**
   * The creation date of the message.
   */
  private Date creationDate;

  /**
   * The modification date of the message.
   */
  private Date modificationDate;

  /**
   * The conversation associated with the message.
   */
  private Conversation conversation;

  /**
   * Returns the identifier of the message.
   *
   * @return The identifier of the message.
   */
  public int getIdMessage() {
    return idMessage;
  }

  /**
   * Sets the identifier of the message.
   *
   * @param messageId
   *     The identifier of the message.
   */
  public void setIdMessage(final int messageId) {
    this.idMessage = messageId;
  }

  /**
   * Returns the content of the message.
   *
   * @return The content of the message.
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content of the message.
   *
   * @param messageContent
   *     The content of the message.
   */
  public void setContent(final String messageContent) {
    this.content = messageContent;
  }

  /**
   * Returns the creation date of the message.
   *
   * @return The creation date of the message.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the message.
   *
   * @param messageCreationDate
   *     The creation date of the message.
   */
  public void setCreationDate(final Date messageCreationDate) {
    this.creationDate = messageCreationDate;
  }

  /**
   * Returns the modification date of the message.
   *
   * @return The modification date of the message.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the message.
   *
   * @param messageModificationDate
   *     The modification date of the message.
   */
  public void setModificationDate(final Date messageModificationDate) {
    this.modificationDate = messageModificationDate;
  }

  /**
   * Returns the conversation associated with the message.
   *
   * @return The conversation associated with the message.
   */
  public Conversation getConversation() {
    return conversation;
  }

  /**
   * Sets the conversation associated with the message.
   *
   * @param messageConversation
   *     The conversation associated with the message.
   */
  public void setConversation(final Conversation messageConversation) {
    this.conversation = messageConversation;
  }
}
