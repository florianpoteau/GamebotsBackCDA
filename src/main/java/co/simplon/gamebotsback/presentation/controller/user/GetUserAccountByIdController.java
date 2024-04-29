package co.simplon.gamebotsback.presentation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.user.Iuserservice;

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
     * Handles a GET request to retrieve a user account by username.
     *
     * @param username The username of the user account to retrieve.
     * @return The UserDTO object representing the user account.
     */
    @GetMapping("/users/{id}")
    public Userdto findUserById(@PathVariable int id) {
        return userService.getById(id);
    }

}
