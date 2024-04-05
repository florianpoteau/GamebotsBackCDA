package co.simplon.gamebotsback.business.dto;

import java.sql.Timestamp;

/**
 * This class represents a user.
 */
public class UserDTO {

    /** The identifier of the user. */
    private int idUser;

    /** The name of the user. */
    private String username;

    /** The phone number of the user. */
    private int phone;

    /** The email address of the user. */
    private String email;

    /** The password of the user. */
    private String password;

    /** The creation date of the user. */
    private Timestamp creationDate;

    /** The modification date of the user. */
    private Timestamp modificationDate;

    /** The image associated with the user. */
    private ImageDTO imageDTO;

    /**
     * Returns the identifier of the user.
     * @return The identifier of the user.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets the identifier of the user.
     * @param idUser The identifier of the user.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Returns the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the name of the user.
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the phone number of the user.
     * @return The phone number of the user.
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     * @param phone The phone number of the user.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Returns the email address of the user.
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the creation date of the user.
     * @return The creation date of the user.
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the user.
     * @param creationDate The creation date of the user.
     */
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the modification date of the user.
     * @return The modification date of the user.
     */
    public Timestamp getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the user.
     * @param modificationDate The modification date of the user.
     */
    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Returns the image associated with the user.
     * @return The image associated with the user.
     */
    public ImageDTO getImageDTO() {
        return imageDTO;
    }

    /**
     * Sets the image associated with the user.
     * @param imageDTO The image associated with the user.
     */
    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }
}
