package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a Message entity in the persistence layer.
 * This class is mapped to the "messages" table in the database.
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id_message")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;

    @Basic
    @Column(name = "content", length = 50)
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "modification_date")
    private Date modificationDate;

    @ManyToOne
    @JoinColumn(name = "id_conversation")
    private Conversation conversation;

    /**
     * Retrieves the ID of the Message.
     * @return The ID of the Message.
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * Sets the ID of the Message.
     * @param idMessage The ID of the Message to set.
     */
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Retrieves the content of the Message.
     * @return The content of the Message.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the Message.
     * @param content The content of the Message to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the creation date of the Message.
     * @return The creation date of the Message.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the Message.
     * @param creationDate The creation date of the Message to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the modification date of the Message.
     * @return The modification date of the Message.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the Message.
     * @param modificationDate The modification date of the Message to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Retrieves the conversation associated with the Message.
     * @return The conversation associated with the Message.
     */
    public Conversation getConversation() {
        return conversation;
    }

    /**
     * Sets the conversation associated with the Message.
     * @param conversation The conversation to set.
     */
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
