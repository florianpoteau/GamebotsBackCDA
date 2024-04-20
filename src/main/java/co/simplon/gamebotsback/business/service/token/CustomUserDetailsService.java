package co.simplon.gamebotsback.business.service.token;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DataSource dataSource;

    public CustomUserDetailsService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
                    throw new UsernameNotFoundException("User not found with username: " + username);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading user by username", e);
        }
    }
}
