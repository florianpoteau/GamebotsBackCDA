package co.simplon.gamebotsback.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for security settings.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /**
   * Represents RSA keys used for JWT token encryption and decryption.
   */
  private final RsaKeyProperties rsaKeys;

  /**
   * Constructs a new SecurityConfig
   * with the specified RSA key properties.
   *
   * @param keysRsa
   *     the RSA key properties containing the public and private keys
   */
  @Autowired
  public SecurityConfig(
      final RsaKeyProperties keysRsa) {
    this.rsaKeys = keysRsa;
  }

  /**
   * Creates a PasswordEncoder bean.
   *
   * @return a BCryptPasswordEncoder instance
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Configures security filters for HTTP requests.
   *
   * @param http
   *     the HttpSecurity object to configure
   *
   * @return a SecurityFilterChain instance
   *
   * @throws Exception
   *     if an error occurs while configuring security
   */
  @SuppressWarnings({"deprecation", "removal"})
  @Bean
  public SecurityFilterChain securityFilterChain(
      final HttpSecurity http) throws Exception {
    return http
        .authorizeRequests(authorize -> authorize
            .requestMatchers("/users", "/login").permitAll().anyRequest()
            .authenticated()

        )
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .logout().disable()
        .csrf().disable()
        .build();
  }

  /**
   * Creates a JwtDecoder bean for decoding JWT tokens.
   *
   * @return a NimbusJwtDecoder instance
   */
  @Bean
  JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
  }

  /**
   * Creates a JwtEncoder bean for encoding JWT tokens.
   *
   * @return a NimbusJwtEncoder instance
   */
  @Bean
  JwtEncoder jwtEncoder() {
    JWK jwk = new RSAKey.Builder(
        rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
    JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwks);
  }
}
