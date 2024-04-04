package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a Game entity in the persistence layer.
 * This class is mapped to the "games" table in the database.
 */
@Entity
@Table(name = "games")
public class Game {

    @Id
    @Column(name = "id_games")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGame;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "studio")
    private String studio;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    @Basic
    @Column(name = "platform")
    private String platform;

    @Basic
    @Column(name = "story")
    private String story;

    @Column(name = "isOnline")
    private boolean isOnline;

    @Column(name = "number_players")
    private int numberPlayers;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
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
     * @param idGame The ID of the Game to set.
     */
    public void setIdGame(int idGame) {
        this.idGame = idGame;
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
     * @param title The title of the Game to set.
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @param studio The studio of the Game to set.
     */
    public void setStudio(String studio) {
        this.studio = studio;
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
     * @param releaseDate The release date of the Game to set.
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
     * @param platform The platform of the Game to set.
     */
    public void setPlatform(String platform) {
        this.platform = platform;
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
     * @param story The story of the Game to set.
     */
    public void setStory(String story) {
        this.story = story;
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
     * @param online True if the Game is online, otherwise false.
     */
    public void setOnline(boolean online) {
        isOnline = online;
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
     * @param numberPlayers The number of players for the Game to set.
     */
    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
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
     * @param creationDate The creation date of the Game to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * @param modificationDate The modification date of the Game to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
