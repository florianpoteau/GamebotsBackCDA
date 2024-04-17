/**
 * This class represents a dto for a user.
 */
package co.simplon.gamebotsback.business.dto;

import co.simplon.gamebotsback.persistance.entity.Image;

import java.util.Date;

/**
 * This class represents a user.
 */
public class UserDTO {

    /** The identifier of the user. */
    private int idUser;

    /** The name of the user. */
    private String username;

    /** The phone number of the user. */
    private Integer phone;

    /** The email address of the user. */
    private String email;

    /** The password of the user. */
    private String password;

    /** The creation date of the user. */
    private Date creationDate;

    /** The modification date of the user. */
    private Date modificationDate;

    /** The image associated with the user. */
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
     * @param idUser The identifier of the user.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the phone number of the user.
     * 
     * @return The phone number of the user.
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     * 
     * @param phone The phone number of the user.
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
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
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @param creationDate The creation date of the user.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * @param modificationDate The modification date of the user.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
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
     * @param image The image associated with the user.
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
