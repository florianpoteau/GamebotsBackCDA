package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Image;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a dto for a user.
 */
@Getter
@Setter
public class Userdto {

  /**
   * The identifier of the user.
   * -- GETTER --
   * Returns the identifier of the user.
   * -- SETTER --
   * Sets the identifier of the user.
   */
  private int idUser;

  /**
   * The name of the user.
   * -- GETTER --
   * Returns the username of the user.
   * -- SETTER --
   * Sets the name of the user.
   */
  private String username;

  /**
   * The phone number of the user.
   * -- GETTER --
   * Returns the phone number of the user.
   * -- SETTER --
   * Sets the phone number of the user.
   */
  private String phone;

  /**
   * The email address of the user.
   * -- GETTER --
   * Returns the email address of the user.
   * -- SETTER --
   * Sets the email address of the user.
   */
  private String email;

  /**
   * The password of the user.
   * -- GETTER --
   * Returns the password of the user.
   * -- SETTER --
   * Sets the password of the user.
   */
  private String password;

  /**
   * The creation date of the user.
   * -- GETTER --
   * Returns the creation date of the user.
   * -- SETTER --
   * Sets the creation date of the user.
   */
  private Date creationDate;

  /**
   * The modification date of the user.
   * -- GETTER --
   * Returns the modification date of the user.
   * -- SETTER --
   * Sets the modification date of the user.
   */
  private Date modificationDate;

  /**
   * The image associated with the user.
   * -- GETTER --
   * Returns the image associated with the user.
   * -- SETTER --
   * Sets the image associated with the user.
   */
  private Image image;
}
