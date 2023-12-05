package src.test.java.gocart.controller;

import src.main.java.gocart.model.User;
import src.main.java.gocart.util.DatabaseUtil;

public class LoginControllerTest {
    /**
     * Attempts to log in a user with the provided username and password.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return a User object if login is successful; null otherwise
     */
    public User login(String username, String password) {
        // Validate input
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return null; // Or throw an IllegalArgumentException
        }

        // Check credentials against the database
        User user = DatabaseUtil.authenticateUser(username, password);

        if (user != null) {
            // User found and password matches
            return user;
        } else {
            // User not found or password does not match
            return null;
        }
    }
}
