package co.simplon.gamebotsback.business.dto;

import java.util.Date;

/**
 * This class represents a game.
 */
public class GameDTO {

    /** The identifier of the game. */
    private int idGame;

    /** The title of the game. */
    private String title;

    /** The studio that developed the game. */
    private String studio;

    /** The release date of the game. */
    private Date releaseDate;

    /** The platform(s) on which the game is available. */
    private String platform;

    /** The story or description of the game. */
    private String story;

    /** Indicates whether the game has online features. */
    private boolean isOnline;

    /** The maximum number of players supported by the game. */
    private int numberPlayers;

    /** The creation date of the game. */
    private Date creationDate;

    /** The modification date of the game. */
    private Date modificationDate;

    /**
     * Returns the identifier of the game.
     * @return The identifier of the game.
     */
    public int getIdGame() {
        return idGame;
    }

    /**
     * Sets the identifier of the game.
     * @param idGame The identifier of the game.
     */
    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    /**
     * Returns the title of the game.
     * @return The title of the game.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the game.
     * @param title The title of the game.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the studio that developed the game.
     * @return The studio that developed the game.
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the studio that developed the game.
     * @param studio The studio that developed the game.
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Returns the release date of the game.
     * @return The release date of the game.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the game.
     * @param releaseDate The release date of the game.
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Returns the platform(s) on which the game is available.
     * @return The platform(s) on which the game is available.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform(s) on which the game is available.
     * @param platform The platform(s) on which the game is available.
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Returns the story or description of the game.
     * @return The story or description of the game.
     */
    public String getStory() {
        return story;
    }

    /**
     * Sets the story or description of the game.
     * @param story The story or description of the game.
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * Returns whether the game has online features.
     * @return True if the game has online features, false otherwise.
     */
    public boolean isOnline() {
        return isOnline;
    }

    /**
     * Sets whether the game has online features.
     * @param online True if the game has online features, false otherwise.
     */
    public void setOnline(boolean online) {
        isOnline = online;
    }

    /**
     * Returns the maximum number of players supported by the game.
     * @return The maximum number of players supported by the game.
     */
    public int getNumberPlayers() {
        return numberPlayers;
    }

    /**
     * Sets the maximum number of players supported by the game.
     * @param numberPlayers The maximum number of players supported by the game.
     */
    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    /**
     * Returns the creation date of the game.
     * @return The creation date of the game.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the game.
     * @param creationDate The creation date of the game.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the game.
     * @return The modification date of the game.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the game.
     * @param modificationDate The modification date of the game.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}