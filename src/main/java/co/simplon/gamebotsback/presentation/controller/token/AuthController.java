package co.simplon.gamebotsback.presentation.controller.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.gamebotsback.business.service.token.TokenService;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        if (authentication != null) {
            String token = tokenService.generateToken(authentication);
            return token;
        } else {
            // Gérer le cas où l'authentification a échoué
            LOG.error("Authentication failed. No valid credentials provided.");
            // Retourner une réponse d'erreur appropriée, par exemple :
            throw new RuntimeException("Authentication failed. No valid credentials provided.");
        }
    }

}
