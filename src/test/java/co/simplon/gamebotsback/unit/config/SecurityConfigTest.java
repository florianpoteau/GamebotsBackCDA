package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import co.simplon.gamebotsback.config.RsaKeyProperties;
import co.simplon.gamebotsback.config.SecurityConfig;

class SecurityConfigTest {

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private RsaKeyProperties rsaKeyProperties;

  @Mock
  private RSAPublicKey rsaPublicKey;

  @Mock
  private RSAPrivateKey rsaPrivateKey;

  @InjectMocks
  private SecurityConfig securityConfig;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    when(rsaKeyProperties.publicKey()).thenReturn(rsaPublicKey);
    when(rsaKeyProperties.privateKey()).thenReturn(rsaPrivateKey);
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

  @Test
  void testJwtDecoder() throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {

    SecurityConfig securityConfig = new SecurityConfig(rsaKeyProperties);

    Method method = SecurityConfig.class.getDeclaredMethod("jwtDecoder");
    method.setAccessible(true);

    JwtDecoder decoder = (JwtDecoder) method.invoke(securityConfig);

    assertNotNull(decoder);
    assertTrue(decoder instanceof NimbusJwtDecoder);
  }

}
