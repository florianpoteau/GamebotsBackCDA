package co.simplon.gamebotsback.business.dto;

import java.util.Date;

/**
 * This class represents a dto for a game.
 */
public class Gamedto {

  /**
   * The identifier of the game.
   */
  private int idGame;

  /**
   * The title of the game.
   */
  private String title;

  /**
   * The studio that developed the game.
   */
  private String studio;

  /**
   * The release date of the game.
   */
  private Date releaseDate;

  /**
   * The platform(s) on which the game is available.
   */
  private String platform;

  /**
   * The story or description of the game.
   */
  private String story;

  /**
   * Indicates whether the game has online features.
   */
  private boolean isOnline;

  /**
   * The maximum number of players supported by the game.
   */
  private int numberPlayers;

  /**
   * The creation date of the game.
   */
  private Date creationDate;

  /**
   * The modification date of the game.
   */
  private Date modificationDate;

  /**
   * Returns the identifier of the game.
   *
   * @return The identifier of the game.
   */
  public int getIdGame() {
    return idGame;
  }

  /**
   * Sets the identifier of the game.
   *
   * @param gameId The identifier of the game.
   */
  public void setIdGame(final int gameId) {
    this.idGame = gameId;
  }

  /**
   * Returns the title of the game.
   *
   * @return The title of the game.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the game.
   *
   * @param gameTitle The title of the game.
   */
  public void setTitle(final String gameTitle) {
    this.title = gameTitle;
  }

  /**
   * Returns the studio that developed the game.
   *
   * @return The studio that developed the game.
   */
  public String getStudio() {
    return studio;
  }

  /**
   * Sets the studio that developed the game.
   *
   * @param gameStudio The studio that developed the game.
   */
  public void setStudio(final String gameStudio) {
    this.studio = gameStudio;
  }

  /**
   * Returns the release date of the game.
   *
   * @return The release date of the game.
   */
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * Sets the release date of the game.
   *
   * @param gameReleaseDate The release date of the game.
   */
  public void setReleaseDate(final Date gameReleaseDate) {
    this.releaseDate = gameReleaseDate;
  }

  /**
   * Returns the platform(s) on which the game is available.
   *
   * @return The platform(s) on which the game is available.
   */
  public String getPlatform() {
    return platform;
  }

  /**
   * Sets the platform(s) on which the game is available.
   *
   * @param gamePlatform The platform(s) on which the game is available.
   */
  public void setPlatform(final String gamePlatform) {
    this.platform = gamePlatform;
  }

  /**
   * Returns the story or description of the game.
   *
   * @return The story or description of the game.
   */
  public String getStory() {
    return story;
  }

  /**
   * Sets the story or description of the game.
   *
   * @param gameStory The story or description of the game.
   */
  public void setStory(final String gameStory) {
    this.story = gameStory;
  }

  /**
   * Returns whether the game has online features.
   *
   * @return True if the game has online features, false otherwise.
   */
  public boolean isOnline() {
    return isOnline;
  }

  /**
   * Sets whether the game has online features.
   *
   * @param gameIsOnline True if the game has online features, false otherwise.
   */
  public void setOnline(final boolean gameIsOnline) {
    isOnline = gameIsOnline;
  }

  /**
   * Returns the maximum number of players supported by the game.
   *
   * @return The maximum number of players supported by the game.
   */
  public int getNumberPlayers() {
    return numberPlayers;
  }

  /**
   * Sets the maximum number of players supported by the game.
   *
   * @param gameNumberPlayers The maximum number of
   *                          players supported by the game.
   */
  public void setNumberPlayers(final int gameNumberPlayers) {
    this.numberPlayers = gameNumberPlayers;
  }

  /**
   * Returns the creation date of the game.
   *
   * @return The creation date of the game.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the game.
   *
   * @param gameCreationDate The creation date of the game.
   */
  public void setCreationDate(final Date gameCreationDate) {
    this.creationDate = gameCreationDate;
  }

  /**
   * Returns the modification date of the game.
   *
   * @return The modification date of the game.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the game.
   *
   * @param gameModificationDate The modification date of the game.
   */
  public void setModificationDate(final Date gameModificationDate) {
    this.modificationDate = gameModificationDate;
  }
}
