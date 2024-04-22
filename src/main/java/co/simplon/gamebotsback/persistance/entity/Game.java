package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

/**
 * Represents a Game entity in the persistence layer.
 * This class is mapped to the "games" table in the database.
 */
@Entity
@Table(name = "games")
public class Game {

    /**
     * The maximum length for string fields in the Game entity.
     */
    private static final int LENGTH = 50;

    /** The unique identifier of the game. */
    @Id
    @Column(name = "id_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGame;

    /** The title of the game. */
    @Basic
    @Column(name = "title", length = LENGTH)
    private String title;

    /** The studio that developed the game. */
    @Basic
    @Column(name = "studio", length = LENGTH)
    private String studio;

    /** The release date of the game. */
    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    /** The platform(s) the game is available on. */
    @Basic
    @Column(name = "platform", length = LENGTH)
    private String platform;

    /** The story or plot of the game. */
    @Basic
    @Column(name = "story", length = LENGTH)
    private String story;

    /** Indicates whether the game has online features. */
    @Column(name = "is_online")
    private boolean isOnline;

    /** The maximum number of players supported by the game. */
    @Column(name = "number_players")
    private int numberPlayers;

    /** The creation date of the game entity. */
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    /** The last modification date of the game entity. */
    @Temporal(TemporalType.DATE)
    @Column(name = "modification_date")
    private Date modificationDate;

    /**
     * Retrieves the ID of the Game.
     * @return The ID of the Game.
     */
    public int getIdGame() {
        return idGame;
    }

    /**
     * Sets the ID of the Game.
     * @param gameId The ID of the Game to set.
     */
    public void setIdGame(final int gameId) {
        this.idGame = gameId;
    }

    /**
     * Retrieves the title of the Game.
     * @return The title of the Game.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the Game.
     * @param gameTitle The title of the Game to set.
     */
    public void setTitle(final String gameTitle) {
        this.title = gameTitle;
    }

    /**
     * Retrieves the studio of the Game.
     * @return The studio of the Game.
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the studio of the Game.
     * @param gameStudio The studio of the Game to set.
     */
    public void setStudio(final String gameStudio) {
        this.studio = gameStudio;
    }

    /**
     * Retrieves the release date of the Game.
     * @return The release date of the Game.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the Game.
     * @param gameReleaseDate The release date of the Game to set.
     */
    public void setReleaseDate(final Date gameReleaseDate) {
        this.releaseDate = gameReleaseDate;
    }

    /**
     * Retrieves the platform of the Game.
     * @return The platform of the Game.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform of the Game.
     * @param gamePlatform The platform of the Game to set.
     */
    public void setPlatform(final String gamePlatform) {
        this.platform = gamePlatform;
    }

    /**
     * Retrieves the story of the Game.
     * @return The story of the Game.
     */
    public String getStory() {
        return story;
    }

    /**
     * Sets the story of the Game.
     * @param gameStory The story of the Game to set.
     */
    public void setStory(final String gameStory) {
        this.story = gameStory;
    }

    /**
     * Retrieves whether the Game is online.
     * @return True if the Game is online, otherwise false.
     */
    public boolean isOnline() {
        return isOnline;
    }

    /**
     * Sets whether the Game is online.
     * @param gameIsOnline True if the Game is online, otherwise false.
     */
    public void setOnline(final boolean gameIsOnline) {
        isOnline = gameIsOnline;
    }

    /**
     * Retrieves the number of players for the Game.
     * @return The number of players for the Game.
     */
    public int getNumberPlayers() {
        return numberPlayers;
    }

    /**
     * Sets the number of players for the Game.
     * @param gameNumberPlayers The number of players for the Game to set.
     */
    public void setNumberPlayers(final int gameNumberPlayers) {
        this.numberPlayers = gameNumberPlayers;
    }

    /**
     * Retrieves the creation date of the Game.
     * @return The creation date of the Game.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the Game.
     * @param gameCreationDate The creation date of the Game to set.
     */
    public void setCreationDate(final Date gameCreationDate) {
        this.creationDate = gameCreationDate;
    }

    /**
     * Retrieves the modification date of the Game.
     * @return The modification date of the Game.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the Game.
     * @param gameModificationDate The modification date of the Game to set.
     */
    public void setModificationDate(final Date gameModificationDate) {
        this.modificationDate = gameModificationDate;
    }
}
