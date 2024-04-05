package co.simplon.gamebotsback.business.dto;

import java.sql.Timestamp;

/**
 * This class represents a message.
 */
public class Message {

    /** The identifier of the message. */
    private int idMessage;

    /** The content of the message. */
    private String content;

    /** The creation date of the message. */
    private Timestamp creationDate;

    /** The modification date of the message. */
    private Timestamp modificationDate;

    /** The conversation associated with the message. */
    private Conversation conversation;

    /**
     * Returns the identifier of the message.
     * @return The identifier of the message.
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * Sets the identifier of the message.
     * @param idMessage The identifier of the message.
     */
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Returns the content of the message.
     * @return The content of the message.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     * @param content The content of the message.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns the creation date of the message.
     * @return The creation date of the message.
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the message.
     * @param creationDate The creation date of the message.
     */
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the message.
     * @return The modification date of the message.
     */
    public Timestamp getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the message.
     * @param modificationDate The modification date of the message.
     */
    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the conversation associated with the message.
     * @return The conversation associated with the message.
     */
    public Conversation getConversation() {
        return conversation;
    }

    /**
     * Sets the conversation associated with the message.
     * @param conversation The conversation associated with the message.
     */
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
