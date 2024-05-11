package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests related to user account deletion.
 * This controller receives a DELETE request
 * with a user ID in the path and delegates the deletion
 * of the user account to the UserService.
 */
@RestController
public class DeleteUserAccountController {

  /**
   * The UserService used to delete user accounts.
   */
  private final Iuserservice userService;

  /**
   * Constructor for the DeleteUserAccountController.
   *
   * @param serviceUser
   *     The UserService used to delete user accounts.
   */
  public DeleteUserAccountController(final Iuserservice serviceUser) {
    this.userService = serviceUser;
  }

  /**
   * Handles a DELETE request to delete a user account by ID.
   *
   * @param userId
   *     The ID of the user account to be deleted.
   */
  @DeleteMapping("/users/{userId}")
  public void deleteUserAccountByUserId(@PathVariable final int userId) {
    userService.deleteUserAccount(userId);
  }
}
