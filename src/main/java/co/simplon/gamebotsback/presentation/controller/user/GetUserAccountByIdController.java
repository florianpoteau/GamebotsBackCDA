package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling HTTP
 * requests related to fetching a user account by its ID.
 * This controller handles HTTP GET requests to
 * retrieve a user account by its ID.
 */
@RestController
public class GetUserAccountByIdController {

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
  public GetUserAccountByIdController(final Iuserservice serviceUser) {
    this.userService = serviceUser;
  }

  /**
   * Handles a GET request to retrieve a user account by username.
   *
   * @param userId
   *     The ID of the user account to retrieve.
   *
   * @return The UserDTO object representing the user account.
   */
  @GetMapping("/users/{userId}")
  public Userdto findUserById(@PathVariable final int userId) {
    return userService.getById(userId);
  }

}
