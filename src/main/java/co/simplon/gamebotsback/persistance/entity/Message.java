package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id_messages")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessages;

    @Basic
    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    @ManyToOne
    @JoinColumn(name = "id_conversations")
    private Conversation conversation;

    public int getIdMessages() {
        return idMessages;
    }

    public void setIdMessages(int idMessages) {
        this.idMessages = idMessages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
