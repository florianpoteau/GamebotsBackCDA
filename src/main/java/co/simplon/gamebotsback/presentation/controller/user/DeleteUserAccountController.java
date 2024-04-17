/**
 * Controller class responsible for handling HTTP requests related to deleting user accounts.
 * This controller receives a DELETE request with the user ID and delegates the deletion of the user account to the UserService.
 */
package co.simplon.gamebotsback.presentation.controller.user;

import co.simplon.gamebotsback.business.service.user.IUserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserAccountController {

    private final IUserService userService;

    /**
     * Constructor for the DeleteUserAccountController.
     *
     * @param userService The UserService used to delete user accounts.
     */
    public DeleteUserAccountController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Handles a DELETE request to delete a user account by ID.
     *
     * @param id The ID of the user account to be deleted.
     */
    @DeleteMapping("/users/{id}")
    public void deleteUserAccountByID(@PathVariable final int id) {
        userService.deleteAccount(id);
    }
}
