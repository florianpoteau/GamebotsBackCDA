package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Game entity in the persistence layer.
 * This class is mapped to the "games" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "games")
public class Game {

  /**
   * The maximum length for string fields in the Game entity.
   */
  private static final int LENGTH = 50;

  /**
   * The unique identifier of the game.
   * -- GETTER --
   * Retrieves the ID of the Game.
   * -- SETTER --
   * Sets the ID of the Game.
   */
  @Id
  @Column(name = "id_game")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idGame;

  /**
   * The title of the game.
   * -- GETTER --
   * Retrieves the title of the Game.
   * -- SETTER --
   * Sets the title of the Game.
   */
  @Basic
  @Column(name = "title", length = LENGTH)
  private String title;

  /**
   * The studio that developed the game.
   * -- GETTER --
   * Retrieves the studio of the Game.
   * -- SETTER --
   * Sets the studio of the Game.
   */
  @Basic
  @Column(name = "studio", length = LENGTH)
  private String studio;

  /**
   * The release date of the game.
   * -- GETTER --
   * Retrieves the release date of the Game.
   * -- SETTER --
   * Sets the release date of the Game.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "release_date")
  private Date releaseDate;

  /**
   * The platform(s) the game is available on.
   * -- GETTER --
   * Retrieves the story of the Game.
   * -- SETTER --
   * Sets the story of the Game.
   */
  @Basic
  @Column(name = "platform", length = LENGTH)
  private String platform;

  /**
   * The story or plot of the game.
   * -- GETTER --
   * Retrieves the platform of the Game.
   * -- SETTER --
   * Sets the platform of the Game.
   */
  @Basic
  @Column(name = "story", columnDefinition = "TEXT")
  private String story;

  /**
   * Indicates whether the game has online features.
   * -- GETTER --
   * Retrieves whether the Game is online.
   * -- SETTER --
   * Sets whether the Game is online.
   */
  @Column(name = "is_online")
  private boolean isOnline;

  /**
   * The maximum number of players supported by the game.
   * -- GETTER --
   * Retrieves the number of players for the Game.
   * -- SETTER --
   * Sets the number of players for the Game.
   */
  @Column(name = "number_players")
  private int numberPlayers;

  /**
   * The creation date of the game entity.
   * -- GETTER --
   * Retrieves the creation date of the Game.
   * -- SETTER --
   * Sets the creation date of the Game.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the game entity.
   * -- GETTER --
   * Retrieves the modification date of the Game.
   * -- SETTER --
   * Sets the modification date of the Game.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;
}
