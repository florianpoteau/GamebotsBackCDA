/**
 * Controller class responsible for handling HTTP requests related to retrieving user accounts by ID.
 * This controller receives a GET request with the user ID in the URL path,
 * retrieves the user account from the UserService, and returns it as a UserDTO object.
 */
package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserAccountByIdController {

  private final Iuserservice userService;

  /**
   * Constructor for the GetUserAccountByIdController.
   *
   * @param userService The UserService used to retrieve user accounts.
   */
  @Autowired
  public GetUserAccountByIdController(Iuserservice userService) {
    this.userService = userService;
  }

  /**
   * Handles a GET request to retrieve a user account by ID.
   *
   * @param id The ID of the user account to retrieve.
   * @return The UserDTO object representing the user account.
   */
  @GetMapping("/users/{id}")
  public Userdto findUserById(@PathVariable int id) {
    return userService.getById(id);
  }
}
