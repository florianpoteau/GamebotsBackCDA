package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

/**
 * Represents an Image entity in the persistence layer.
 * This class is mapped to the "images" table in the database.
 */
@Entity
@Table(name = "images")
public class Image {

  /**
   * The maximum length for string fields in the Image entity.
   */
  private static final int LENGTH = 50;

  /**
   * The unique identifier of the image.
   */
  @Id
  @Column(name = "id_image")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idImage;

  /**
   * The name of the image.
   */
  @Basic
  @Column(name = "name", length = LENGTH)
  private String name;

  /**
   * The source URL or path of the image.
   */
  @Basic
  @Column(name = "source")
  private String source;

  /**
   * The creation date of the image.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the image.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The game associated with the image.
   */
  @ManyToOne
  @JoinColumn(name = "id_game")
  private Game game;

  /**
   * The type of image associated with the image.
   */
  @ManyToOne
  @JoinColumn(name = "id_type_image")
  private TypeImage typeImage;

  /**
   * Retrieves the ID of the Image.
   *
   * @return The ID of the Image.
   */
  public int getIdImage() {
    return idImage;
  }

  /**
   * Sets the ID of the Image.
   *
   * @param imageId The ID of the Image to set.
   */
  public void setIdImage(final int imageId) {
    this.idImage = imageId;
  }

  /**
   * Retrieves the name of the Image.
   *
   * @return The name of the Image.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the Image.
   *
   * @param imageName The name of the Image to set.
   */
  public void setName(final String imageName) {
    this.name = imageName;
  }

  /**
   * Retrieves the source of the Image.
   *
   * @return The source of the Image.
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the source of the Image.
   *
   * @param imageSource The source of the Image to set.
   */
  public void setSource(final String imageSource) {
    this.source = imageSource;
  }

  /**
   * Retrieves the creation date of the Image.
   *
   * @return The creation date of the Image.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the Image.
   *
   * @param imageCreationDate The creation date of the Image to set.
   */
  public void setCreationDate(final Date imageCreationDate) {
    this.creationDate = imageCreationDate;
  }

  /**
   * Retrieves the modification date of the Image.
   *
   * @return The modification date of the Image.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the Image.
   *
   * @param imageModificationDate The modification date of the Image to set.
   */
  public void setModificationDate(final Date imageModificationDate) {
    this.modificationDate = imageModificationDate;
  }

  /**
   * Retrieves the game associated with the Image.
   *
   * @return The game associated with the Image.
   */
  public Game getGame() {
    return game;
  }

  /**
   * Sets the game associated with the Image.
   *
   * @param imageGame The game to set.
   */
  public void setGame(final Game imageGame) {
    this.game = imageGame;
  }

  /**
   * Retrieves the type of image associated with the Image.
   *
   * @return The type of image associated with the Image.
   */
  public TypeImage getTypeImage() {
    return typeImage;
  }

  /**
   * Sets the type of image associated with the Image.
   *
   * @param imageTypeImage The type of image to set.
   */
  public void setTypeImage(final TypeImage imageTypeImage) {
    this.typeImage = imageTypeImage;
  }
}
