package co.simplon.gamebotsback.business.dto;

import java.sql.Timestamp;

/**
 * This class represents an image.
 */
public class Image {

    /** The identifier of the image. */
    private int id;

    /** The name of the image. */
    private String name;

    /** The source of the image. */
    private String source;

    /** The creation date of the image. */
    private Timestamp creationDate;

    /** The modification date of the image. */
    private Timestamp modificationDate;

    /** The type of the image. */
    private TypeImage typeImage;

    /**
     * Returns the identifier of the image.
     * @return The identifier of the image.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the image.
     * @param id The identifier of the image.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the image.
     * @return The name of the image.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the image.
     * @param name The name of the image.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the source of the image.
     * @return The source of the image.
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source of the image.
     * @param source The source of the image.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Returns the creation date of the image.
     * @return The creation date of the image.
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the image.
     * @param creationDate The creation date of the image.
     */
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the image.
     * @return The modification date of the image.
     */
    public Timestamp getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the image.
     * @param modificationDate The modification date of the image.
     */
    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the type of the image.
     * @return The type of the image.
     */
    public TypeImage getTypeImage() {
        return typeImage;
    }

    /**
     * Sets the type of the image.
     * @param typeImage The type of the image.
     */
    public void setTypeImage(TypeImage typeImage) {
        this.typeImage = typeImage;
    }
}