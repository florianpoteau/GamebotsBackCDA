package co.simplon.gamebotsback.business.dto;

import java.util.Date;

/**
 * This class represents a dto for a typeImage.
 */
public class TypeImagedto {

  /**
   * The identifier of the type of image.
   */
  private int idTypeImage;

  /**
   * The name of the type of image.
   */
  private String name;

  /**
   * The creation date of the type of image.
   */
  private Date creationDate;

  /**
   * The modification date of the type of image.
   */
  private Date modificationDate;

  /**
   * Returns the identifier of the type of image.
   *
   * @return The identifier of the type of image.
   */
  public int getIdTypeImage() {
    return idTypeImage;
  }

  /**
   * Sets the identifier of the type of image.
   *
   * @param typeImageId The identifier of the type of image.
   */
  public void setIdTypeImage(final int typeImageId) {
    this.idTypeImage = typeImageId;
  }

  /**
   * Returns the name of the type of image.
   *
   * @return The name of the type of image.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the type of image.
   *
   * @param typeImageName The name of the type of image.
   */
  public void setName(final String typeImageName) {
    this.name = typeImageName;
  }

  /**
   * Returns the creation date of the type of image.
   *
   * @return The creation date of the type of image.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the creation date of the type of image.
   *
   * @param typeImageCreationDate The creation date of the type of image.
   */
  public void setCreationDate(final Date typeImageCreationDate) {
    this.creationDate = typeImageCreationDate;
  }

  /**
   * Returns the modification date of the type of image.
   *
   * @return The modification date of the type of image.
   */
  public Date getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the modification date of the type of image.
   *
   * @param typeImageModificationDate The modification date of
   *                                  the type of image.
   */
  public void setModificationDate(final Date typeImageModificationDate) {
    this.modificationDate = typeImageModificationDate;
  }
}
