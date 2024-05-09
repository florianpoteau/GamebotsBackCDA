package co.simplon.gamebotsback.business.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a dto for a game.
 */
@Getter
@Setter
public class Gamedto {

  /**
   * The identifier of the game.
   * -- GETTER --
   * Returns the identifier of the game.
   * -- SETTER --
   * Sets the identifier of the game.
   */
  private int idGame;

  /**
   * The title of the game.
   * -- GETTER --
   * Returns the title of the game.
   * -- SETTER --
   * Sets the title of the game.
   */
  private String title;

  /**
   * The studio that developed the game.
   * -- GETTER --
   * Returns the studio that developed the game.
   * -- SETTER --
   * Sets the studio that developed the game.
   */
  private String studio;

  /**
   * The release date of the game.
   * -- GETTER --
   * Returns the release date of the game.
   * -- SETTER --
   * Sets the release date of the game.
   */
  private Date releaseDate;

  /**
   * The platform(s) on which the game is available.
   * -- GETTER --
   * Returns the platform(s) on which the game is available.
   * -- SETTER --
   * Sets the platform(s) on which the game is available.
   */
  private String platform;

  /**
   * The story or description of the game.
   * -- GETTER --
   * Returns the story or description of the game.
   * -- SETTER --
   * Sets the story or description of the game.
   */
  private String story;

  /**
   * Indicates whether the game has online features.
   * -- GETTER --
   * Returns whether the game has online features.
   * -- SETTER --
   * Sets whether the game has online features.
   */
  private boolean isOnline;

  /**
   * The maximum number of players supported by the game.
   * -- GETTER --
   * Returns the maximum number of players supported by the game.
   * -- SETTER --
   * Sets the maximum number of players supported by the game.
   */
  private int numberPlayers;

  /**
   * The creation date of the game.
   * -- GETTER --
   * Returns the creation date of the game.
   * -- SETTER --
   * Sets the creation date of the game.
   */
  private Date creationDate;

  /**
   * The modification date of the game.
   * -- GETTER --
   * Returns the modification date of the game.
   * -- SETTER --
   * Sets the modification date of the game.
   */
  private Date modificationDate;
}
