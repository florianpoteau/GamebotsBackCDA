package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class SecurityConfigTest {

  @Mock
  PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testPasswordEncoder() {
    String password = "password";

    when(passwordEncoder.encode(password)).thenReturn("passwordEncoded");

    String encodedPassword = passwordEncoder.encode(password);

    assertTrue(encodedPassword != null && !encodedPassword.isEmpty());

    assertNotEquals(encodedPassword, password);
  }

  @Test
  void testPasswordDecoder() {
    String plainPassword = "password";

    String encodedPassword = "$2a$123";

    when(passwordEncoder.matches(plainPassword, encodedPassword)).thenReturn(true);

    boolean matches = passwordEncoder.matches(plainPassword, encodedPassword);

    assertTrue(matches);
  }

}
