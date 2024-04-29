package co.simplon.gamebotsback.business.service.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private final JwtEncoder encoder;
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs a new TokenService with the specified dependencies.
     *
     * @param encoder            the JwtEncoder used for encoding JWT tokens
     * @param userDetailsService the CustomUserDetailsService used for retrieving
     *                           user details
     * @param passwordEncoder    the PasswordEncoder used for encoding and verifying
     *                           passwords
     */
    @Autowired
    public TokenService(JwtEncoder encoder, CustomUserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        this.encoder = encoder;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Generates a JWT token for the specified username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the generated JWT token
     * @throws RuntimeException if the credentials are invalid or an error occurs
     *                          during token generation
     */
    public String generateToken(String username, String password, int userId) {
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
            return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    /**
     * Checks if the provided raw password matches the encoded password.
     *
     * @param encodedPassword the encoded password
     * @param rawPassword     the raw (unencoded) password
     * @return true if the passwords match, false otherwise
     */
    private boolean passwordMatches(String encodedPassword, String rawPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}