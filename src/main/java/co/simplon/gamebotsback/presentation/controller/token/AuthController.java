package co.simplon.gamebotsback.presentation.controller.token;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.token.TokenService;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for login user
 * This controller handles HTTP POST requests to login user.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

  /**
   * The service responsible for generating JWT tokens.
   */
  private final TokenService tokenService;

  /**
   * The service responsible for user-related operations.
   */
  private final Iuserservice iuserservice;

  /**
   * Constructs a new AuthController with the
   * specified TokenService and IUserService.
   *
   * @param serviceToken
   *     the TokenService used for generating JWT tokens
   * @param userserviceinterface
   *     the IUserService
   *     used for user-related operations
   */
  public AuthController(
      final TokenService serviceToken,
      final Iuserservice userserviceinterface) {
    this.tokenService = serviceToken;
    this.iuserservice = userserviceinterface;
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

      int userId = iuserservice.getUserIdByUsername(userDto.getUsername());
      // Générer le token JWT en utilisant l'objet Authentication
      return tokenService.generateToken(
          userDto.getUsername(), userDto.getPassword(), userId);
    } else {
      throw new IllegalArgumentException("Authentication object is "
          + "null or does not contain a name");
    }
  }

}
