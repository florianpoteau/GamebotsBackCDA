package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

public class SecurityConfigTest {

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtEncoder jwtEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPasswordEncoder() {
        String password = "password";

        when(passwordEncoder.encode(password)).thenReturn("passwordEncoded");

        String encodedPassword = passwordEncoder.encode(password);

        assertTrue(encodedPassword != null && !encodedPassword.isEmpty());

        assertTrue(!encodedPassword.equals(password));
    }

    @Test
    public void testPasswordDecoder() {
        String plainPassword = "password";

        String encodedPassword = "$2a$123";

        when(passwordEncoder.matches(plainPassword, encodedPassword)).thenReturn(true);

        boolean matches = passwordEncoder.matches(plainPassword, encodedPassword);

        assertTrue(matches);
    }

}
