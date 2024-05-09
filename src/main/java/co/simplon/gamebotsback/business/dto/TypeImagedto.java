package co.simplon.gamebotsback.business.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a dto for a typeImage.
 */

@Getter
@Setter
public class TypeImagedto {

  /**
   * The identifier of the type of image.
   * -- GETTER --
   * Returns the identifier of the type of image.
   * -- SETTER --
   * Sets the identifier of the type of image.
   */
  private int idTypeImage;

  /**
   * The name of the type of image.
   * -- GETTER --
   * Returns the name of the type of image.
   * -- SETTER --
   * Sets the name of the type of image.
   */
  private String name;

  /**
   * The creation date of the type of image.
   * -- GETTER --
   * Returns the creation date of the type of image.
   * -- SETTER --
   * Sets the creation date of the type of image.
   */
  private Date creationDate;

  /**
   * The modification date of the type of image.
   * -- GETTER --
   * Returns the modification date of the type of image.
   * -- SETTER --
   * Sets the modification date of the type of image.
   */
  private Date modificationDate;
}
