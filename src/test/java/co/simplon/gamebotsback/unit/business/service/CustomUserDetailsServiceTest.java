package co.simplon.gamebotsback.unit.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.simplon.gamebotsback.business.service.token.CustomUserDetailsService;

class CustomUserDetailsServiceTest {

  String username = "username";
  String password = "password";

  @Mock
  private DataSource dataSource;

  @Mock
  private ResultSet resultSet;

  @Mock
  private PreparedStatement preparedStatement;

  @Mock
  private Connection connection;

  private CustomUserDetailsService customUserDetailsService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    customUserDetailsService = new CustomUserDetailsService(dataSource);
  }

  @Test
  void testLoadUserByUsername() throws SQLException {

    when(resultSet.next()).thenReturn(true);
    when(resultSet.getString("password")).thenReturn(password);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(connection.prepareStatement(any())).thenReturn(preparedStatement);
    when(dataSource.getConnection()).thenReturn(connection);

    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

    assertEquals(username, userDetails.getUsername());
    assertEquals(password, userDetails.getPassword());
    verify(connection).prepareStatement(any());
    verify(preparedStatement).setString(1, username);

  }

  @Test
  void testLoadUserByUsernameWithUserNotFound() throws SQLException {

    when(resultSet.next()).thenReturn(false);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(dataSource.getConnection()).thenReturn(connection);
    when(dataSource.getConnection().prepareStatement(any())).thenReturn(preparedStatement);

    assertThrows(UsernameNotFoundException.class, () -> {
      customUserDetailsService.loadUserByUsername(username);
    });

  }

  @Test
  void testLoadUserByUsernameWithError() throws SQLException {
    when(dataSource.getConnection()).thenThrow(new UsernameNotFoundException("Error loading user by username"));

    assertThrows(UsernameNotFoundException.class, () -> {
      customUserDetailsService.loadUserByUsername(username);
    });
  }

}
