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
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Image entity in the persistence layer.
 * This class is mapped to the "images" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {

  /**
   * The maximum length for string fields in the Image entity.
   */
  private static final int LENGTH = 50;

  /**
   * The unique identifier of the image.
   * -- GETTER --
   * Retrieves the ID of the Image.
   * -- SETTER --
   * Sets the ID of the Image.
   */
  @Id
  @Column(name = "id_image")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idImage;

  /**
   * The name of the image.
   * -- GETTER --
   * Retrieves the name of the Image.
   * -- SETTER --
   * Sets the name of the Image.
   */
  @Basic
  @Column(name = "name", length = LENGTH)
  private String name;

  /**
   * The source URL or path of the image.
   * -- GETTER --
   * Retrieves the source of the Image.
   * -- SETTER --
   * Sets the source of the Image.
   */
  @Basic
  @Column(name = "source")
  private String source;

  /**
   * The creation date of the image.
   * -- GETTER --
   * Retrieves the creation date of the Image.
   * -- SETTER --
   * Sets the creation date of the Image.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the image.
   * -- GETTER --
   * Retrieves the modification date of the Image.
   * -- SETTER --
   * Sets the modification date of the Image.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The game associated with the image.
   * -- GETTER --
   * Retrieves the game associated with the Image.
   * -- SETTER --
   * Sets the game associated with the Image.
   */
  @ManyToOne
  @JoinColumn(name = "id_game")
  private Game game;

  /**
   * The type of image associated with the image.
   * -- GETTER --
   * Retrieves the type of image associated with the Image.
   * -- SETTER --
   * Sets the type of image associated with the Image.
   */
  @ManyToOne
  @JoinColumn(name = "id_type_image")
  private TypeImage typeImage;
}
