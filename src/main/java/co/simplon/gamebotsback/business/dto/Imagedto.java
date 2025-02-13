package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Game;
import co.simplon.gamebotsback.persistance.entity.TypeImage;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 * This class represents a dto for an image.
 */
@Getter
@Setter
public class Imagedto {

  /**
   * The identifier of the image.
   * -- GETTER --
   * Returns the identifier of the image.
   * -- SETTER --
   * Sets the identifier of the image.
   */
  private int idImage;

  /**
   * The name of the image.
   * -- GETTER --
   * Returns the name of the image.
   * -- SETTER --
   * Sets the name of the image.
   */
  private String name;

  /**
   * The source of the image.
   * -- GETTER --
   * Returns the source of the image.
   * -- SETTER --
   * Sets the source of the image.
   */
  private String source;

  /**
   * The creation date of the image.
   * -- GETTER --
   * Returns the creation date of the image.
   * -- SETTER --
   * Sets the creation date of the image.
   */
  private Date creationDate;

  /**
   * The modification date of the image.
   * -- GETTER --
   * Returns the modification date of the image.
   * -- SETTER --
   * Sets the modification date of the image.
   */
  private Date modificationDate;

  /**
   * The game of the image.
   * -- GETTER --
   * Returns the game of the image.
   * -- SETTER --
   * Sets the imageGame of the image.
   */
  private Game game;

  /**
   * The type of the image.
   * -- GETTER --
   * Returns the type of the image.
   * -- SETTER --
   * Sets the type of the image.
   */
  private TypeImage typeImage;
}
