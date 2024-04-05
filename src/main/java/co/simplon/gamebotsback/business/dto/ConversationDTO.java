package co.simplon.gamebotsback.business.dto;

import java.util.Date;

import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.entity.Game;

/**
 * This class represents a conversation.
 */
public class ConversationDTO {

    /** The unique identifier of the conversation. */
    private int idConversation;

    /** The name of the conversation. */
    private String name;

    /** The creation date of the conversation. */
    private Date creationDate;

    /** The modification date of the conversation. */
    private Date modificationDate;

    /** The user associated with the conversation. */
    private User user;

    /** The game associated with the conversation. */
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
     * @param idConversation The ID of the conversation to set.
     */
    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
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
     * @param name The name of the conversation to set.
     */
    public void setName(String name) {
        this.name = name;
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
     * @param creationDate The creation date of the conversation to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * @param modificationDate The modification date of the conversation to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
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
     * @param user The user associated with the conversation to set.
     */
    public void setUser(User user) {
        this.user = user;
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
     * @param game The game associated with the conversation to set.
     */
    public void setGame(Game game) {
        this.game = game;
    }
}