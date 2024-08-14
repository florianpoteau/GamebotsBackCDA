package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Conversation;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a dto for a message.
 */
@Getter
@Setter
public class Messagedto {

  /**
   * The identifier of the message.
   * -- GETTER --
   * Returns the identifier of the message.
   * -- SETTER --
   * Sets the identifier of the message.
   */
  private int idMessage;

  /**
   * The content of the message.
   * -- GETTER --
   * Returns the content of the message.
   * -- SETTER --
   * Sets the content of the message.
   */
  private String content;

  private String contentBot;

  /**
   * The creation date of the message.
   * -- GETTER --
   * Returns the creation date of the message.
   * -- SETTER --
   * Sets the creation date of the message.
   */
  private Date creationDate;

  /**
   * The modification date of the message.
   * -- GETTER --
   * Returns the modification date of the message.
   * -- SETTER --
   * Sets the modification date of the message.
   */
  private Date modificationDate;

  /**
   * The conversation associated with the message.
   * -- GETTER --
   * Returns the conversation associated with the message.
   * -- SETTER --
   * Sets the conversation associated with the message.
   */
  private Conversation conversation;
}
