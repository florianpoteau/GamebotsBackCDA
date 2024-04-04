package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a Conversation entity in the persistence layer.
 * This class is mapped to the "conversations" table in the database.
 */
@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @Column(name = "id_conversations")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConversation;

    @Basic
    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    /**
     * Retrieves the ID of the Conversation.
     * @return The ID of the Conversation.
     */
    public int getIdConversation() {
        return idConversation;
    }

    /**
     * Sets the ID of the Conversation.
     * @param idConversation The ID of the Conversation to set.
     */
    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }

    /**
     * Retrieves the name of the Conversation.
     * @return The name of the Conversation.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Conversation.
     * @param name The name of the Conversation to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the creation date of the Conversation.
     * @return The creation date of the Conversation.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the Conversation.
     * @param creationDate The creation date of the Conversation to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the modification date of the Conversation.
     * @return The modification date of the Conversation.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the Conversation.
     * @param modificationDate The modification date of the Conversation to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
