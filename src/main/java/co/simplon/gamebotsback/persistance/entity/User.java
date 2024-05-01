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
 * Represents a User entity in the persistence layer.
 * This class is mapped to the "users" table in the database.
 */
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
   */
  @Id
  @Column(name = "id_user")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUser;

  /**
   * The username of the user.
   */
  @Basic
  @Column(name = "username", length = LENGTH, unique = true)
  private String username;

  /**
   * The phone number of the user.
   */
  @Basic
  @Column(name = "phone", length = LENGTHPHONE)
  private String phone;

  /**
   * The email of the user.
   */
  @Basic
  @Column(name = "email", length = LENGTH)
  private String email;

  /**
   * The password of the user.
   */
  @Basic
  @Column(name = "password", length = LENGTHPASSWORD)
  private String password;

  /**
   * The creation date of the user.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation_date")
  private Date creationDate;

  /**
   * The last modification date of the user.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modification_date")
  private Date modificationDate;

  /**
   * The image associated with the user.
   */
  @ManyToOne
  @JoinColumn(name = "id_image")
  private Image image;

  /**
   * Retrieves the user's ID.
   *
   * @return The user's ID.
   */
  public int getIdUser() {
    return idUser;
  }

  /**
   * Sets the user's ID.
   *
   * @param userId
   *     The user's ID to set.
   */
  public void setIdUser(final int userId) {
    this.idUser = userId;
  }

  /**
   * Retrieves the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username of the user.
   *
   * @param userUsername
   *     The username to set.
   */
  public void setUsername(final String userUsername) {
    this.username = userUsername;
  }

  /**
   * Retrieves the phone number of the user.
   *
   * @return The phone number of the user.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the phone number of the user.
   *
   * @param userPhone
   *     The phone number to set.
   */
  public void setPhone(final String userPhone) {
    this.phone = userPhone;
  }

  /**
   * Retrieves the email of the user.
   *
   * @return The email of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email of the user.
   *
   * @param userEmail
   *     The email to set.
   */
  public void setEmail(final String userEmail) {
    this.email = userEmail;
  }

  /**
   * Retrieves the password of the user.
   *
   * @return The password of the user.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password of the user.
   *
   * @param userPassword
   *     The password to set.
   */
  public void setPassword(final String userPassword) {
    this.password = userPassword;
  }

  /**
   * Retrieves the creation date of the user.
   *
   * @return The creation date of the user.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the user.
   *
   * @param userCreationDate
   *     The creation date to set.
   */
  public void setCreationDate(final Date userCreationDate) {
    this.creationDate = userCreationDate;
  }

  /**
   * Retrieves the modification date of the user.
   *
   * @return The modification date of the user.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the user.
   *
   * @param userModificationDate
   *     The modification date to set.
   */
  public void setModificationDate(final Date userModificationDate) {
    this.modificationDate = userModificationDate;
  }

  /**
   * Retrieves the image associated with the user.
   *
   * @return The image associated with the user.
   */
  public Image getImage() {
    return image;
  }

  /**
   * Sets the image associated with the user.
   *
   * @param userImage
   *     The image to set.
   */
  public void setImage(final Image userImage) {
    this.image = userImage;
  }
}
