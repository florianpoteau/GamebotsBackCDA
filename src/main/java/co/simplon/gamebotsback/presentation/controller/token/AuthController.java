package co.simplon.gamebotsback.presentation.controller.token;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.token.TokenService;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for login user
 * This controller handles HTTP POST requests to login user.
 */
@RestController
public class AuthController {

  private final TokenService tokenService;
  private final Iuserservice iuserservice;

  /**
   * Constructs a new AuthController with the specified TokenService.
   *
   * @param serviceToken
   *     the TokenService used for generating JWT tokens
   */
  public AuthController(
      final TokenService serviceToken, final Iuserservice iuserservice) {
    this.tokenService = serviceToken;
    this.iuserservice = iuserservice;
  }

  /**
   * Handles a login request by generating a JWT token for the specified user
   * credentials.
   *
   * @param userDto
   *     the user credentials provided in the login request
   *
   * @return the generated JWT token
   *
   * @throws IllegalArgumentException
   *     if the user credentials are null or
   *     incomplete
   */
  @PostMapping("/login")
  public String login(@RequestBody final Userdto userDto) {

    // Vérifier si l'objet Authentication est null
    if (userDto != null && userDto.getUsername() != null) {

      int userId = iuserservice.getIdByUsername(userDto.getUsername());
      // Générer le token JWT en utilisant l'objet Authentication
      String token = tokenService.generateToken(
          userDto.getUsername(), userDto.getPassword(), userId);
      return token;
    } else {
      throw new IllegalArgumentException("Authentication object is "
          + "null or does not contain a name");
    }
  }

}
