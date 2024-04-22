package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 * Represents a TypeImage entity in the persistence layer.
 * This class is mapped to the "type_images" table in the database.
 */
@Entity
@Table(name = "type_images")
public class TypeImage {

    /**
     * The maximum length for string fields in the Game entity.
     */
    private static final int LENGTH = 50;

    /** The unique identifier of the type of image. */
    @Id
    @Column(name = "id_type_image")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeImage;

    /** The name of the type of image. */
    @Basic
    @Column(name = "name", length = LENGTH)
    private String name;

    /** The creation date of the type of image. */
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    /** The last modification date of the type of image. */
    @Temporal(TemporalType.DATE)
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
     * @param typeImageId The ID of the TypeImage to set.
     */
    public void setIdTypeImage(final int typeImageId) {
        this.idTypeImage = typeImageId;
    }

    /**
     * Retrieves the name of the TypeImage.
     * @return The name of the TypeImage.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the typeImageName of the TypeImage.
     * @param typeImageName The typeImageName of the TypeImage to set.
     */
    public void setName(final String typeImageName) {
        this.name = typeImageName;
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
     * @param typeImageCreationDate The creation date of the TypeImage to set.
     */
    public void setCreationDate(final Date typeImageCreationDate) {
        this.creationDate = typeImageCreationDate;
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
     * @param typeImageModificationDate The modification date of
     * the TypeImage to set.
     */
    public void setModificationDate(final Date typeImageModificationDate) {
        this.modificationDate = typeImageModificationDate;
    }
}
