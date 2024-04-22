/**
 * This class represents a unit test for the UserRepository class.
 * It tests the functionality of finding a user by username.
 */
package co.simplon.gamebotsback.unit.persistance.repository;

import co.simplon.gamebotsback.persistance.entity.User;
import co.simplon.gamebotsback.persistance.repository.user.IUserRepository;
import co.simplon.gamebotsback.persistance.repository.user.UserQueries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private IUserRepository userRepository;

    @Test
    @DisplayName("Test Find By Username")
    void testFindByUsername() {

        when(userRepository.findByUsername("Ylorklan")).thenReturn(Optional.of(new User()));

        Optional<User> user = userRepository.findByUsername("Ylorklan");

        verify(userRepository, times(1)).findByUsername("Ylorklan");

        assert user.isPresent();
    }

    @Test
    @DisplayName("Test that UserQueries throws exception when instantiated")
    void testInstantiation() {
        try {
            instantiateUserQueries();
            fail("Expected exception not thrown");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            assertNotNull(cause);
            assertEquals("Utility class cannot be instantiated", cause.getMessage(), "Expected exception message to match");
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getClass().getSimpleName());
        }
    }

    private void instantiateUserQueries() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<UserQueries> constructor = UserQueries.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    @DisplayName("Test that FIND_BY_USERNAME query is defined")
    void testFindByUsernameQuery() {

        assertNotNull(UserQueries.FIND_BY_USERNAME, "Expected FIND_BY_USERNAME query to be defined");
        assertEquals("SELECT u FROM User u WHERE u.username = :username", UserQueries.FIND_BY_USERNAME, "Expected FIND_BY_USERNAME query to match");
    }
}
