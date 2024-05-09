package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.User;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a dto for a conversation.
 */
@Getter
@Setter
public class Conversationdto {

  /**
   * The unique identifier of the conversation.
   * -- GETTER --
   * Retrieves the ID of the conversation.
   * -- SETTER --
   * Sets the ID of the conversation.
   */
  private int idConversation;

  /**
   * The name of the conversation.
   * -- GETTER --
   * Retrieves the name of the conversation.
   * -- SETTER --
   * Sets the name of the conversation.
   */
  private String name;

  /**
   * The creation date of the conversation.
   * -- GETTER --
   * Retrieves the creation date of the conversation.
   * -- SETTER --
   * Sets the creation date of the conversation.
   */
  private Date creationDate;

  /**
   * The modification date of the conversation.
   * -- GETTER --
   * Retrieves the modification date of the conversation.
   * -- SETTER --
   * Sets the modification date of the conversation.
   */
  private Date modificationDate;

  /**
   * The user associated with the conversation.
   * -- GETTER --
   * Retrieves the user associated with the conversation.
   * -- SETTER --
   * Sets the user associated with the conversation.
   */
  private User user;

  /**
   * The game associated with the conversation.
   * -- GETTER --
   * Retrieves the game associated with the conversation.
   * -- SETTER --
   * Sets the game associated with the conversation.
   */
  private Game game;
}
