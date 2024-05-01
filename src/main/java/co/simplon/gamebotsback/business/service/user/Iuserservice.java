package co.simplon.gamebotsback.business.service.user;

import co.simplon.gamebotsback.business.dto.Userdto;

/**
 * The IUserService interface defines operations available for managing user
 * accounts.
 */
public interface Iuserservice {

  /**
   * Creates a new user account.
   *
   * @param user
   *     The information of the new user to create.
   */
  void createAccount(Userdto user);

  /**
   * Retrieves information about a user based on their ID.
   *
   * @param id
   *     The ID of the user.
   *
   * @return Information about the user corresponding to the given ID.
   */
  int getIdByUsername(String username);

  /**
   * Modifies information of an existing user account.
   *
   * @param id
   *     The ID of the user to modify.
   * @param user
   *     The new information to associate with the user.
   *
   * @return The updated information of the user.
   */
  Userdto modifyAccount(int id, Userdto user);

  /**
   * Deletes the user account corresponding to the given ID.
   *
   * @param id
   *     The ID of the user to delete.
   */
  void deleteAccount(int id);

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
