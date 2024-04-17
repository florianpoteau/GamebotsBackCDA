package co.simplon.gamebotsback.persistance.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Represents a User entity in the persistence layer.
 * This class is mapped to the "users" table in the database.
 */
@Entity
@Table(name = "users")
public class User {

    /** The unique identifier of the user. */
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    /** The username of the user. */
    @Basic
    @Column(name = "username", length = 50)
    private String username;

    /** The phone number of the user. */
    @Column(name = "phone")
    private int phone;

    /** The email of the user. */
    @Basic
    @Column(name = "email", length = 50)
    private String email;

    /** The password of the user. */
    @Basic
    @Column(name = "password", length = 50)
    private String password;

    /** The creation date of the user. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    /** The last modification date of the user. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    /** The image associated with the user. */
    @ManyToOne
    @JoinColumn(name = "id_image")
    private Image image;

    /**
     * Retrieves the user's ID.
     * @return The user's ID.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets the user's ID.
     * @param idUser The user's ID to set.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Retrieves the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the phone number of the user.
     * @return The phone number of the user.
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     * @param phone The phone number to set.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the email of the user.
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the creation date of the user.
     * @return The creation date of the user.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the user.
     * @param creationDate The creation date to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the modification date of the user.
     * @return The modification date of the user.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the modification date of the user.
     * @param modificationDate The modification date to set.
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Retrieves the image associated with the user.
     * @return The image associated with the user.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image associated with the user.
     * @param image The image to set.
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
