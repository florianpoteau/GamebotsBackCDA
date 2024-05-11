package co.simplon.gamebotsback.business.service.user;

import co.simplon.gamebotsback.business.dto.Userdto;

/**
 * The Iuserservice interface defines operations
 * available for managing user accounts.
 */
public interface Iuserservice {

  /**
   * Creates a new userDto account.
   *
   * @param userDto
   *     The information of the new userDto to create.
   */
  void createAccount(Userdto userDto);

  /**
   * Retrieves the ID of a user based on their username.
   *
   * @param username
   *     The username of the user.
   *
   * @return The ID of the user corresponding to the given username.
   */
  int getIdByUsername(String username);

  /**
   * Modifies information of an existing userDto account.
   *
   * @param userId
   *     The ID of the userDto to modify.
   * @param userDto
   *     The new information to associate with the userDto.
   */
  void modifyAccount(int userId, Userdto userDto);

  /**
   * Deletes the user account corresponding to the given ID.
   *
   * @param userId
   *     The ID of the user to delete.
   */
  void deleteAccount(int userId);

  /**
   * Retrieves information about a user based on their ID.
   *
   * @param userId
   *     The ID of the user.
   *
   * @return Information about the user corresponding to the given ID.
   */
  Userdto getById(int userId);

}
