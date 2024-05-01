package co.simplon.gamebotsback.business.service.token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom implementation of Spring Security's UserDetailsService interface.
 * This service is responsible for loading user details
 * from the database based on the provided username.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

  /**
   * The DataSource used for database connections.
   */
  private final DataSource dataSource;

  /**
   * Constructs a new CustomUserDetailsService with the specified DataSource.
   *
   * @param source
   *     the DataSource used for database connections
   */
  public CustomUserDetailsService(final DataSource source) {
    this.dataSource = source;
  }

  /**
   * Loads user details from the database based on the provided username.
   *
   * @param username
   *     the username of the user whose details are to be loaded
   *
   * @return UserDetails object containing the user's details
   *
   * @throws UsernameNotFoundException
   *     if the user with the specified username is not found in the database
   */
  @Override
  public UserDetails loadUserByUsername(
      final String username) throws UsernameNotFoundException {
    String sql = "SELECT username, password FROM users WHERE username=?";
    try (Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          String password = resultSet.getString("password");
          return org.springframework.security.core.userdetails.User
              .withUsername(username)
              .password(password)
              .roles()
              .build();
        } else {
          throw new UsernameNotFoundException("User not found with username: "
              + username);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Error loading user by username", e);
    }
  }
}
