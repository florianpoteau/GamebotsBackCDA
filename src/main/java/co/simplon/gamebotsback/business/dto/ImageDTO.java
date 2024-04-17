/**
 * This class represents a dto for a image.
 */
package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.TypeImage;

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
    private Game game;

    /** The type of the image. */
    private TypeImage typeImage;

    /**
     * Returns the identifier of the image.
     * 
     * @return The identifier of the image.
     */
    public int getIdImage() {
        return idImage;
    }

    /**
     * Sets the identifier of the image.
     * 
     * @param idImage The identifier of the image.
     */
    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    /**
     * Returns the name of the image.
     * 
     * @return The name of the image.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the image.
     * 
     * @param name The name of the image.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the source of the image.
     * 
     * @return The source of the image.
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source of the image.
     * 
     * @param source The source of the image.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Returns the creation date of the image.
     * 
     * @return The creation date of the image.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the image.
     * 
     * @param creationDate The creation date of the image.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the image.
     * 
     * @return The modification date of the image.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the image.
     * 
     * @param modificationDate The modification date of the image.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the game of the image.
     * 
     * @return The game of the image.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the game of the image.
     * 
     * @param game The game of the image.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Returns the type of the image.
     * 
     * @return The type of the image.
     */
    public TypeImage getTypeImage() {
        return typeImage;
    }

    /**
     * Sets the type of the image.
     * 
     * @param typeImage The type of the image.
     */
    public void setTypeImage(TypeImage typeImage) {
        this.typeImage = typeImage;
    }
}
