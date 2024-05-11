package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests to retrieve user accounts by username.
 */
@RestController
public class GetUserAccountByUsernameController {

  /**
   * The UserService used to retrieve user accounts.
   */
  private final Iuserservice userService;

  /**
   * Constructor for the GetUserAccountByIdController.
   *
   * @param serviceUser
   *     The UserService used to retrieve user accounts.
   */
  @Autowired
  public GetUserAccountByUsernameController(final Iuserservice serviceUser) {
    this.userService = serviceUser;
  }

  /**
   * Handles a GET request to retrieve a user account by username.
   *
   * @param username
   *     The username of the user account to retrieve.
   *
   * @return The UserDTO object representing the user account.
   */
  @GetMapping("/users/username/{username}")
  public int findUserIdByUsername(@PathVariable final String username) {
    return userService.getUserIdByUsername(username);
  }
}
