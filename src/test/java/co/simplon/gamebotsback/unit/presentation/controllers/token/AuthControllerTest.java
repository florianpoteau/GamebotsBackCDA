package co.simplon.gamebotsback.unit.presentation.controllers.token;

import co.simplon.gamebotsback.business.dto.Userdto;
import co.simplon.gamebotsback.business.service.token.TokenService;
import co.simplon.gamebotsback.business.service.user.Iuserservice;
import co.simplon.gamebotsback.presentation.controller.token.AuthController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuthControllerTest {

    @Mock
    private TokenService tokenService;

    @Mock
    private Iuserservice userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        Userdto userDto = new Userdto();
        userDto.setUsername("username");
        userDto.setPassword("password");

        when(userService.getIdByUsername(userDto.getUsername())).thenReturn(1);
        when(tokenService.generateToken(userDto.getUsername(), userDto.getPassword(), 1)).thenReturn("generatedToken");

        String token = authController.login(userDto);

        assertNotNull(token);

        verify(userService, times(1)).getIdByUsername(userDto.getUsername());
        verify(tokenService, times(1)).generateToken(userDto.getUsername(), userDto.getPassword(), 1);
    }

    @Test
    void testLoginFailure() {

        Userdto userDto = new Userdto();
        userDto.setUsername(null);
        userDto.setPassword(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> authController.login(userDto));

        assertEquals("Authentication object is null or does not contain a name", exception.getMessage());

        verify(userService, never()).getIdByUsername(anyString());
        verify(tokenService, never()).generateToken(anyString(), anyString(), anyInt());

    }
}
