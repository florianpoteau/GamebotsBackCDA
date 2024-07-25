package co.simplon.gamebotsback.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.hibernate.internal.util.config.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.util.WebUtils;

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
   *     the RSA key properties containing
   *     the public and private keys
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
   * @throws ConfigurationException
   *     if an error occurs during configuration
   */
  @SuppressWarnings({"deprecation", "removal"})
  @Bean
  public SecurityFilterChain securityFilterChain(
      final HttpSecurity http) throws ConfigurationException {

    try {
      return http
          .csrf(AbstractHttpConfigurer::disable)
          .authorizeRequests(authorize -> authorize
              .requestMatchers(
                  "/users", "/login", "/register", "/csrf").permitAll()
              .anyRequest().authenticated())
          .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
          .sessionManagement(session -> session.sessionCreationPolicy(
              SessionCreationPolicy.STATELESS))
          .cors()
          .and()
          .build();
    } catch (Exception e) {
      throw new ConfigurationException(
          "Erreur lors de la configuration de la sécurité", e);
    }
  }

  /**
   * Extracts the token from the request cookies or headers.
   *
   * @param request
   *     the HttpServletRequest object
   *
   * @return the extracted token string, or null if not found
   */
  public String cookieTokenExtractor(final HttpServletRequest request) {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (header != null) {
      return header.replace("Bearer ", "");
    }
    Cookie cookie = WebUtils.getCookie(request, "access_token");
    return cookie != null ? cookie.getValue() : null;
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
    JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(
        rsaKeys.privateKey()).build();
    JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwks);
  }

  /**
   * Creates a CorsFilter bean to handle CORS configuration.
   *
   * @return a CorsFilter instance
   */
  @SuppressWarnings({
      "checkstyle:LineLength", "checkstyle:VariableDeclarationUsageDistance"})
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source =
        new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOrigins(List.of("http://localhost:5173"));
    config.setAllowedMethods(List.of(
        "GET", "POST", "PUT", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
