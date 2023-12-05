package src.test.java.gocart.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.main.java.gocart.model.User;
import src.main.java.gocart.util.DatabaseUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseUtilTest {
    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
    }

    @Test
    public void testAuthenticateUser() throws SQLException {
        String testUsername = "testUser";
        String testPassword = "testPass";

        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("username")).thenReturn(testUsername);
        when(mockResultSet.getString("password")).thenReturn(testPassword);

        User result = DatabaseUtil.authenticateUser(testUsername, testPassword);

        assertNotNull(result, "Authenticated user should not be null");
        assertEquals(testUsername, result.getUsername(), "Username should match the input");
        assertEquals(testPassword, result.getPassword(), "Password should match the input");

        verify(mockConnection).prepareStatement(anyString());
        verify(mockStatement).executeQuery();
    }

}
