/**
 * This class represents a unit test for the UserRepository class.
 * It tests the functionality of finding a user by username.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    /**
     * Mock object representing the IUserRepository interface.
     */
    @Mock
    private IUserRepository userRepository;

    /**
     * Test method for finding a user by username.
     */
    @Test
    @DisplayName("Test Find By Username")
    void testFindByUsername() {
        // Mock behavior for findByUsername method
        User user = new User();
        when(userRepository.findByUsername("Ylorklan")).thenReturn(user);

        // Call findByUsername method and retrieve the optional user
        User result = userRepository.findByUsername("Ylorklan");

        // Verify that findByUsername was called once with the username "Ylorklan"
        verify(userRepository, times(1)).findByUsername("Ylorklan");

        // Assertion: The user should be present
        assert result != null;
    }
}
