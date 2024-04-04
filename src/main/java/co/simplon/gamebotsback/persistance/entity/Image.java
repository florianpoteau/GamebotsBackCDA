package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "images")
public class Image {

        @Id
        @Column(name = "id_images")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idImages;

        @Basic
        @Column(name = "name")
        private String name;

        @Basic
        @Column(name = "source")
        private String source;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "creation_date")
        private Date creationDate;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "modification_date")
        private Date modificationDate;

        @ManyToOne
        @JoinColumn(name = "id_games")
        private Game game;

    public int getIdImages() {
        return idImages;
    }

    public void setIdImages(int idImages) {
        this.idImages = idImages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
