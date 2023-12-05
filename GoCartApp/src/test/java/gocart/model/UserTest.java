package src.test.java.gocart.model;

import src.main.java.gocart.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("username", "password", "customer");

        assertNotNull(user, "User object should be created");
        assertEquals("username", user.getUsername(), "Username should be set correctly");
        assertEquals("password", user.getPassword(), "Password should be set correctly");
        assertEquals("customer", user.getRole(), "Role should be set correctly");
    }

    // If you have additional methods in the User class like validation methods,
    // you should add tests for them here.
    // For example:

    @Test
    public void testIsValidUser() {
        User validUser = new User("username", "password", "customer");
        assertTrue(validUser.isValid(), "User should be valid with correct details");

        User invalidUser = new User("", "", "");
        assertFalse(invalidUser.isValid(), "User with empty fields should be invalid");
    }

}
