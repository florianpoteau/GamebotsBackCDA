package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests related to user account creation.
 * This controller receives a POST request with user data
 * in JSON format and delegates the creation of the
 * user account to the UserService.
 */
@RestController
public class CreateUserAccountController {

  /**
   * The UserService used to create user accounts.
   */
  private final Iuserservice userService;

  /**
   * Constructor for the CreateUserAccountController.
   *
   * @param serviceUser
   *     The UserService used to create user accounts.
   */
  @Autowired
  public CreateUserAccountController(
      final Iuserservice serviceUser) {
    this.userService = serviceUser;
  }

  /**
   * Handles a POST request to create a new user account.
   *
   * @param userDto
   *     The UserDTO object containing
   *     the user data to be used for account creation.
   */
  @PostMapping("/users")
  public void createAccount(
      @RequestBody final Userdto userDto) {
    userService.createUserAccount(userDto);
  }
}
