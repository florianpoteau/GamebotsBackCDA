package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Image;
import java.util.Date;

/**
 * This class represents a dto for a user.
 */
public class Userdto {

  /**
   * The identifier of the user.
   */
  private int idUser;

  /**
   * The name of the user.
   */
  private String username;

  /**
   * The phone number of the user.
   */
  private String phone;

  /**
   * The email address of the user.
   */
  private String email;

  /**
   * The password of the user.
   */
  private String password;

  /**
   * The creation date of the user.
   */
  private Date creationDate;

  /**
   * The modification date of the user.
   */
  private Date modificationDate;

  /**
   * The image associated with the user.
   */
  private Image image;

  /**
   * Returns the identifier of the user.
   *
   * @return The identifier of the user.
   */
  public int getIdUser() {
    return idUser;
  }

  /**
   * Sets the identifier of the user.
   *
   * @param userId
   *     The identifier of the user.
   */
  public void setIdUser(final int userId) {
    this.idUser = userId;
  }

  /**
   * Returns the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the name of the user.
   *
   * @param userUsername
   *     The username of the user.
   */
  public void setUsername(final String userUsername) {
    this.username = userUsername;
  }

  /**
   * Returns the phone number of the user.
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
   *     The phone number of the user.
   */
  public void setPhone(final String userPhone) {
    this.phone = userPhone;
  }

  /**
   * Returns the email address of the user.
   *
   * @return The email address of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email address of the user.
   *
   * @param userEmail
   *     The email address of the user.
   */
  public void setEmail(final String userEmail) {
    this.email = userEmail;
  }

  /**
   * Returns the password of the user.
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
   *     The password of the user.
   */
  public void setPassword(final String userPassword) {
    this.password = userPassword;
  }

  /**
   * Returns the creation date of the user.
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
   *     The creation date of the user.
   */
  public void setCreationDate(final Date userCreationDate) {
    this.creationDate = userCreationDate;
  }

  /**
   * Returns the modification date of the user.
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
   *     The modification date of the user.
   */
  public void setModificationDate(final Date userModificationDate) {
    this.modificationDate = userModificationDate;
  }

  /**
   * Returns the image associated with the user.
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
   *     The image associated with the user.
   */
  public void setImage(final Image userImage) {
    this.image = userImage;
  }
}
