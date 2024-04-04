package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "type_images")
public class TypeImage {

    @Id
    @Column(name = "id_type_images")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeImage;

    @Basic
    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    public int getIdTypeImages() {
        return idTypeImage;
    }

    public void setIdTypeImages(int idTypeImage) {
        this.idTypeImage = idTypeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
