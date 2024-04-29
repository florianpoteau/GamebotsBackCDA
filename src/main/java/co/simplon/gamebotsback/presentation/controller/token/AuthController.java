/**
 * Controller class for login user
 * This controller handles HTTP POST requests to login user
 */
package co.simplon.gamebotsback.presentation.controller.token;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.token.TokenService;

@RestController
public class AuthController {

    private final TokenService tokenService;

    /**
     * Constructs a new AuthController with the specified TokenService.
     *
     * @param tokenService the TokenService used for generating JWT tokens
     */
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * Handles a login request by generating a JWT token for the specified user
     * credentials.
     *
     * @param userDTO the user credentials provided in the login request
     * @return the generated JWT token
     * @throws IllegalArgumentException if the user credentials are null or
     *                                  incomplete
     */
    @PostMapping("/login")
    public String login(@RequestBody Userdto userDTO) {

        // Vérifier si l'objet Authentication est null
        if (userDTO != null && userDTO.getUsername() != null) {
            // Générer le token JWT en utilisant l'objet Authentication
            String token = tokenService.generateToken(userDTO.getUsername(), userDTO.getPassword());
            return token;
        } else {
            throw new IllegalArgumentException("Authentication object is null or does not contain a name");
        }
    }

}
