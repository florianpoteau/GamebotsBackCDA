package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a TypeImage entity in the persistence layer.
 * This class is mapped to the "type_images" table in the database.
 */
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

    /**
     * Retrieves the ID of the TypeImage.
     * @return The ID of the TypeImage.
     */
    public int getIdTypeImage() {
        return idTypeImage;
    }

    /**
     * Sets the ID of the TypeImage.
     * @param idTypeImage The ID of the TypeImage to set.
     */
    public void setIdTypeImage(int idTypeImage) {
        this.idTypeImage = idTypeImage;
    }

    /**
     * Retrieves the name of the TypeImage.
     * @return The name of the TypeImage.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the TypeImage.
     * @param name The name of the TypeImage to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the creation date of the TypeImage.
     * @return The creation date of the TypeImage.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the TypeImage.
     * @param creationDate The creation date of the TypeImage to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the modification date of the TypeImage.
     * @return The modification date of the TypeImage.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the TypeImage.
     * @param modificationDate The modification date of the TypeImage to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
