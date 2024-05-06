package co.simplon.gamebotsback.business.service.token;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for generating JWT tokens for user authentication.
 */
@Service
public class TokenService {

  /**
   * The JwtEncoder used for encoding JWT tokens.
   */
  private final JwtEncoder encoder;

  /**
   * The CustomUserDetailsService used for retrieving user details.
   */
  private final CustomUserDetailsService userDetailsService;

  /**
   * The PasswordEncoder used for encoding and verifying passwords.
   */
  private final PasswordEncoder passwordEncoder;

  /**
   * Constructs a new TokenService with the specified dependencies.
   *
   * @param encoderJwt
   *     the JwtEncoder used for encoding JWT tokens
   * @param serviceDetailsUser
   *     the CustomUserDetailsService used for retrieving
   *     user details
   * @param encoderPassword
   *     the PasswordEncoder used for encoding and verifying
   *     passwords
   */
  @Autowired
  public TokenService(final JwtEncoder encoderJwt,
                      final CustomUserDetailsService serviceDetailsUser,
                      final PasswordEncoder encoderPassword) {
    this.encoder = encoderJwt;
    this.userDetailsService = serviceDetailsUser;
    this.passwordEncoder = encoderPassword;
  }

  /**
   * Generates a JWT token for the specified username and password.
   *
   * @param username
   *     the username of the user
   * @param password
   *     the password of the user
   * @param userId
   *     the ID of the user
   *
   * @return the generated JWT token
   *
   * @throws RuntimeException
   *     if the credentials are invalid or an error occurs
   *     during token generation
   */
  public String generateToken(final String username,
                              final String password, final int userId) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    if (passwordMatches(userDetails.getPassword(), password)) {
      Instant now = Instant.now();
      JwtClaimsSet claims = JwtClaimsSet.builder()
          .issuer("self")
          .issuedAt(now)
          .expiresAt(now.plus(1, ChronoUnit.HOURS))
          .subject(username)
          .claim(username, username)
          .claim("userId", userId)
          .build();
      return this.encoder.encode(
          JwtEncoderParameters.from(claims)).getTokenValue();
    } else {
      throw new InvalidCredentialsException("Invalid credentials");
    }
  }

  /**
   * Checks if the provided raw password matches the encoded password.
   *
   * @param encodedPassword
   *     the encoded password
   * @param rawPassword
   *     the raw (unencoded) password
   *
   * @return true if the passwords match, false otherwise
   */
  private boolean passwordMatches(final String encodedPassword,
                                  final String rawPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
  }

  /**
   * Custom exception to handle invalid credentials during token generation.
   */
  public static class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
      super(message);
    }
  }
}
