/**
 * Controller class responsible for handling HTTP requests related to user account creation.
 * This controller receives a POST request with user data in JSON format and delegates the creation of the user account to the UserService.
 */
package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserAccountController {

  private final IUserService userService;

  /**
   * Constructor for the CreateUserAccountController.
   *
   * @param userService The UserService used to create user accounts.
   */
  @Autowired
  public CreateUserAccountController(IUserService userService) {
    this.userService = userService;
  }

  /**
   * Handles a POST request to create a new user account.
   *
   * @param userDTO The UserDTO object containing the user data to be used for account creation.
   */
  @PostMapping("/users")
  public void createAccount(@RequestBody Userdto userDTO) {
    userService.createAccount(userDTO);
  }
}
