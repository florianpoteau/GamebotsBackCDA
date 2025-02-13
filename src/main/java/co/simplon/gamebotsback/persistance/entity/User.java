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
 * Represents a User entity in the persistence layer.
 * This class is mapped to the "users" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  /**
   * The maximum length for string fields in the Game entity.
   */
  private static final int LENGTH = 50;

  /**
   * The maximum length for string fields in the Game entity.
   */
  private static final int LENGTHPASSWORD = 64;

  /**
   * The maximum length for string fields in the Game entity.
   */
  private static final int LENGTHPHONE = 50;

  /**
   * The unique identifier of the user.
   * -- GETTER --
   * Retrieves the user's ID.
   * -- SETTER --
   * Sets the user's ID.
   */
  @Id
  @Column(name = "id_user")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUser;

  /**
   * The username of the user.
   * -- GETTER --
   * Retrieves the username of the user.
   * -- SETTER --
   * Sets the username of the user.
   */
  @Basic
  @Column(name = "username", length = LENGTH, unique = true)
  private String username;

  /**
   * The phone number of the user.
   * -- GETTER --
   * Retrieves the phone number of the user.
   * -- SETTER --
   * Sets the phone number of the user.
   */
  @Basic
  @Column(name = "phone", length = LENGTHPHONE)
  private String phone;

  /**
   * The email of the user.
   * -- GETTER --
   * Retrieves the email of the user.
   * -- SETTER --
   * Sets the email of the user.
   */
  @Basic
  @Column(name = "email", length = LENGTH)
  private String email;

  /**
   * The password of the user.
   * -- GETTER --
   * Retrieves the password of the user.
   * -- SETTER --
   * Sets the password of the user.
   */
  @Basic
  @Column(name = "password", length = LENGTHPASSWORD)
  private String password;

  /**
   * The creation date of the user.
   * -- GETTER --
   * Retrieves the creation date of the user.
   * -- SETTER --
   * Sets the creation date of the user.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the user.
   * -- GETTER --
   * Retrieves the modification date of the user.
   * -- SETTER --
   * Sets the modification date of the user.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The image associated with the user.
   * -- GETTER --
   * Retrieves the image associated with the user.
   * -- SETTER --
   * Sets the image associated with the user.
   */
  @ManyToOne
  @JoinColumn(name = "id_image")
  private Image image;
}
