package co.simplon.gamebotsback.business.dto;

import java.util.Date;

/**
 * This class represents an image.
 */
public class ImageDTO {

    /** The identifier of the image. */
    private int idImage;

    /** The name of the image. */
    private String name;

    /** The source of the image. */
    private String source;

    /** The creation date of the image. */
    private Date creationDate;

    /** The modification date of the image. */
    private Date modificationDate;

    /** The game of the image. */
    private GameDTO gameDTO;

    /** The type of the image. */
    private TypeImageDTO typeImageDTO;

    /**
     * Returns the identifier of the image.
     * @return The identifier of the image.
     */
    public int getIdImage() {
        return idImage;
    }

    /**
     * Sets the identifier of the image.
     * @param idImage The identifier of the image.
     */
    public void setIdImage(int idImage) {
        this.idImage = idImage;
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
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the image.
     * @param creationDate The creation date of the image.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the image.
     * @return The modification date of the image.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the image.
     * @param modificationDate The modification date of the image.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the game of the image.
     * @return The game of the image.
     */
    public GameDTO getGameDTO() {
        return gameDTO;
    }

    /**
     * Sets the game of the image.
     * @param gameDTO The game of the image.
     */
    public void setGameDTO(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }

    /**
     * Returns the type of the image.
     * @return The type of the image.
     */
    public TypeImageDTO getTypeImageDTO() {
        return typeImageDTO;
    }

    /**
     * Sets the type of the image.
     * @param typeImageDTO The type of the image.
     */
    public void setTypeImageDTO(TypeImageDTO typeImageDTO) {
        this.typeImageDTO = typeImageDTO;
    }
}