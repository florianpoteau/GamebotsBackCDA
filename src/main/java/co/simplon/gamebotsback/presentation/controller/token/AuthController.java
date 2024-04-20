package co.simplon.gamebotsback.presentation.controller.token;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.dto.UserDTO;
import co.simplon.gamebotsback.business.service.token.TokenService;

@RestController
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {

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
