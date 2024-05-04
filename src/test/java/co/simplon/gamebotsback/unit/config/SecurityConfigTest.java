package co.simplon.gamebotsback.unit.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfigTest {

    @Mock
    PasswordEncoder passwordEncoder;

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
}
