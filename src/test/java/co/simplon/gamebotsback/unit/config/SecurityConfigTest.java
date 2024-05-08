package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
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
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import co.simplon.gamebotsback.config.RsaKeyProperties;
import co.simplon.gamebotsback.config.SecurityConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

class SecurityConfigTest {

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private RsaKeyProperties rsaKeyProperties;

  @Mock
  private RSAPublicKey rsaPublicKey;

  @Mock
  private RSAPrivateKey rsaPrivateKey;

  @Mock
  private HttpServletRequest request;

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

  @Test
  void testJwtEncoder() throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException {

    // Configuration de la clef Privée simulée
    when(rsaPrivateKey.getEncoded()).thenReturn(new byte[] {});

    when(rsaPrivateKey.getAlgorithm()).thenReturn("rsa");

    when(rsaPrivateKey.getFormat()).thenReturn("PKCS#8");

    when(rsaPrivateKey.getModulus())
        .thenReturn(new BigInteger(
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789048647632746736247676746277486287364665657675682736472637567824657672367562456724756762452765675656476726652876479612"));

    when(rsaPrivateKey.getPrivateExponent())
        .thenReturn(new BigInteger(
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789084837248237574275624658782309786479267657357865767246756274576275676876576273862767676726767467856786575676587626587"));

    // Configuration de la clef Public simulée
    when(rsaPublicKey.getEncoded()).thenReturn(new byte[] {});

    when(rsaPublicKey.getAlgorithm()).thenReturn("rsa");

    when(rsaPublicKey.getFormat()).thenReturn("PKCS#8");

    when(rsaPublicKey.getModulus())
        .thenReturn(new BigInteger(
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789048647632746736247676746277486287364665657675682736472637567824657672367562456724756762452765675656476726652876479612"));

    when(rsaPublicKey.getPublicExponent())
        .thenReturn(new BigInteger(
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789084837248237574275624658782309786479267657357865767246756274576275676876576273862767676726767467856786575676587626587"));

    SecurityConfig securityConfig = new SecurityConfig(rsaKeyProperties);

    Method method = SecurityConfig.class.getDeclaredMethod("jwtEncoder");

    method.setAccessible(true);

    JwtEncoder encoder = (JwtEncoder) method.invoke(securityConfig);

    assertNotNull(encoder);
    assertTrue(encoder instanceof JwtEncoder);
  }

  @Test
  void testCookieTokenExtractorWithAuthorizationHeader() {

    when(request.getHeader("Authorization")).thenReturn("Bearer mockAccessToken");

    SecurityConfig securityConfig = new SecurityConfig(null);

    String token = securityConfig.cookieTokenExtractor(request);

    assertEquals("mockAccessToken", token);
  }

  @Test
  void testCookieTokenExtractorWithCookie() {

    Cookie cookie = new Cookie("access_token", "mockAccessToken");

    when(request.getHeader("Authorization")).thenReturn(null);

    when(request.getCookies()).thenReturn(new Cookie[] { cookie });

    SecurityConfig securityConfig = new SecurityConfig(null);

    String token = securityConfig.cookieTokenExtractor(request);

    assertEquals("mockAccessToken", token);
  }

  @Test
  void testCookieTokenExtractorWithNoToken() {

    when(request.getHeader("Authorization")).thenReturn(null);

    when(request.getCookies()).thenReturn(null);

    SecurityConfig securityConfig = new SecurityConfig(null);

    String token = securityConfig.cookieTokenExtractor(request);

    assertEquals(null, token);
  }

}
