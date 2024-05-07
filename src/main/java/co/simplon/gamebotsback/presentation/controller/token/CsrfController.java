package co.simplon.gamebotsback.presentation.controller.token;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling CSRF token requests.
 */
@RestController
public class CsrfController {

    /**
     * Retrieves the CSRF token.
     *
     * @param token the CSRF token injected by Spring Security
     * @return the CSRF token
     */
    @GetMapping("/csrf")
    public CsrfToken getCsrf(final CsrfToken token) {
        return token;
    }

}
