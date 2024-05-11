package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling
 * HTTP requests related to user account modification.
 * This controller receives a PUT request
 * with a user ID in the path and user data in the request body,
 * and delegates the modification of the user account to the UserService.
 */
@RestController
public class ModifyUserAccountController {

  /**
   * The UserService used to modify user accounts.
   */
  private final Iuserservice userService;

  /**
   * Constructor for the ModifyUserAccountController.
   *
   * @param serviceUser
   *     The UserService used to modify user accounts.
   */
  @Autowired
  public ModifyUserAccountController(final Iuserservice serviceUser) {
    this.userService = serviceUser;
  }

  /**
   * Handles a PUT request to modify a user account.
   *
   * @param userId
   *     The ID of the user account to be modified.
   * @param userDto
   *     The UserDTO object containing the updated user data.
   */
  @PutMapping("/users/{userId}")
  public void modifyUserAccount(
      @PathVariable final int userId, @RequestBody final Userdto userDto) {
    userService.modifyAccount(userId, userDto);
  }
}
