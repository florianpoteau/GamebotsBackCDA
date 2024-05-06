package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.simplon.gamebotsback.config.RsaKeyProperties;
import co.simplon.gamebotsback.config.SecurityConfig;

class SecurityConfigTest {

  @Mock
  PasswordEncoder passwordEncoder;

  @Mock
  RsaKeyProperties rsaKeyProperties;

  @InjectMocks
  SecurityConfig securityConfig;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testPasswordEncoder() {
    SecurityConfig securityConfig = new SecurityConfig(rsaKeyProperties);

    PasswordEncoder encoder = securityConfig.passwordEncoder();

    assertNotNull(encoder);

    assertTrue(encoder instanceof BCryptPasswordEncoder);
  }

  @Test
  void testPasswordDecoder() {
    String plainPassword = "password";

    String encodedPassword = "$2a$123";

    when(passwordEncoder.matches(plainPassword, encodedPassword)).thenReturn(true);

    boolean matches = passwordEncoder.matches(plainPassword, encodedPassword);

    assertTrue(matches);
  }

  @Test
  void testAutowiredRsaKeyProperties() {
    SecurityConfig securityConfig = new SecurityConfig(rsaKeyProperties);

    assertNotNull(securityConfig);

  }

}
