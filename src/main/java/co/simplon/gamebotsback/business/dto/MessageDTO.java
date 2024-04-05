package co.simplon.gamebotsback.business.dto;

import java.util.Date;

/**
 * This class represents a message.
 */
public class MessageDTO {

    /** The identifier of the message. */
    private int idMessage;

    /** The content of the message. */
    private String content;

    /** The creation date of the message. */
    private Date creationDate;

    /** The modification date of the message. */
    private Date modificationDate;

    /** The conversation associated with the message. */
    private ConversationDTO conversationDTO;

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
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the message.
     * @param creationDate The creation date of the message.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the message.
     * @return The modification date of the message.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the message.
     * @param modificationDate The modification date of the message.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the conversation associated with the message.
     * @return The conversation associated with the message.
     */
    public ConversationDTO getConversationDTO() {
        return conversationDTO;
    }

    /**
     * Sets the conversation associated with the message.
     * @param conversationDTO The conversation associated with the message.
     */
    public void setConversationDTO(ConversationDTO conversationDTO) {
        this.conversationDTO = conversationDTO;
    }
}
