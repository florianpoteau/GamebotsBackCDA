package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a TypeImage entity in the persistence layer.
 * This class is mapped to the "type_images" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "type_images")
public class TypeImage {

  /**
   * The maximum length for string fields in the Game entity.
   */
  private static final int LENGTH = 50;

  /**
   * The unique identifier of the type of image.
   * -- GETTER --
   * Retrieves the ID of the TypeImage.
   * -- SETTER --
   * Sets the ID of the TypeImage.
   */
  @Id
  @Column(name = "id_type_image")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTypeImage;

  /**
   * The name of the type of image.
   * -- GETTER --
   * Retrieves the name of the TypeImage.
   * -- SETTER --
   * Sets the typeImageName of the TypeImage.
   */
  @Basic
  @Column(name = "name", length = LENGTH)
  private String name;

  /**
   * The creation date of the type of image.
   * -- GETTER --
   * Retrieves the creation date of the TypeImage.
   * -- SETTER --
   * Sets the creation date of the TypeImage.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the type of image.
   * -- GETTER --
   * Retrieves the modification date of the TypeImage.
   * -- SETTER --
   * Sets the modification date of the TypeImage.
   */
  @Temporal(TemporalType.DATE)
  @Column(name = "modification_date")
  private Date modificationDate;
}
