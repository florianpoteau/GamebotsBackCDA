/**
 * Controller class responsible for handling HTTP requests related to modifying user accounts.
 * This controller receives a PUT request with the user ID and updated user data in JSON format,
 * and delegates the modification of the user account to the UserService.
 */
package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyUserAccountController {

  private final Iuserservice userService;

  /**
   * Constructor for the ModifyUserAccountController.
   *
   * @param userService The UserService used to modify user accounts.
   */
  @Autowired
  public ModifyUserAccountController(Iuserservice userService) {
    this.userService = userService;
  }

  /**
   * Handles a PUT request to modify a user account.
   *
   * @param id      The ID of the user account to be modified.
   * @param userDTO The UserDTO object containing the updated user data.
   */
  @PutMapping("/users/{id}")
  public void modifyUserAccount(@PathVariable int id, @RequestBody Userdto userDTO) {
    userService.modifyAccount(id, userDTO);
  }
}
