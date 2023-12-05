package src.main.java.gocart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.main.java.gocart.model.Product;
import src.main.java.gocart.model.User;

public class DatabaseUtil {
    // Database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gocart_db";
    private static final String DATABASE_USER = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";

    /**
     * Gets a connection to the database.
     * 
     * @return A Connection object.
     * @throws SQLException If a database access error occurs.
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    /**
     * Authenticates a user.
     * 
     * @param username The username.
     * @param password The password.
     * @return A User object if authentication is successful; null otherwise.
     */
    public static User authenticateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?"; // Note: Use password hashing in production

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Other database operations like addProduct, updateProduct, etc., can be added here

    /**
     * Example method to add a product to the database.
     * 
     * @param product The product to add.
     * @return true if the operation is successful; false otherwise.
     */
    public static boolean addProduct(Product product) {
        String sql = "INSERT INTO products (id, name, price, description, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getDescription());
            pstmt.setInt(5, product.getQuantity());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
