package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.TypeImage;

import java.util.Date;

/**
 * This class represents a dto for an image.
 */
public class Imagedto {

  /**
   * The identifier of the image.
   */
  private int idImage;

  /**
   * The name of the image.
   */
  private String name;

  /**
   * The source of the image.
   */
  private String source;

  /**
   * The creation date of the image.
   */
  private Date creationDate;

  /**
   * The modification date of the image.
   */
  private Date modificationDate;

  /**
   * The game of the image.
   */
  private Game game;

  /**
   * The type of the image.
   */
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
   * @param imageId The identifier of the image.
   */
  public void setIdImage(final int imageId) {
    this.idImage = imageId;
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
   * @param imageName The name of the image.
   */
  public void setName(final String imageName) {
    this.name = imageName;
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
   * @param imageSource The source of the image.
   */
  public void setSource(final String imageSource) {
    this.source = imageSource;
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
   * @param imageCreationDate The creation date of the image.
   */
  public void setCreationDate(final Date imageCreationDate) {
    this.creationDate = imageCreationDate;
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
   * @param imageModificationDate The modification date of the image.
   */
  public void setModificationDate(final Date imageModificationDate) {
    this.modificationDate = imageModificationDate;
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
   * Sets the imageGame of the image.
   *
   * @param imageGame The imageGame of the image.
   */
  public void setGame(final Game imageGame) {
    this.game = imageGame;
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
   * @param imageTypeImage The type of the image.
   */
  public void setTypeImage(final TypeImage imageTypeImage) {
    this.typeImage = imageTypeImage;
  }
}
