
package DAO;

import DBConn.DBConnection;
import Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class UserDAO {

    private final Connection conn;

    public UserDAO() throws SQLException, ClassNotFoundException {
        // Initialize database connection
        this.conn = ConnectionManagerDAO.getConnection();
    }

    public boolean registerUser(String user_name, String email, String user_role, String password) throws SQLException {
        String query = "INSERT INTO user (user_name, email, user_role, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user_name);
            stmt.setString(2, email);
            stmt.setString(3, user_role);
            stmt.setString(4, password);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if registration is successful
        }
    }

    // Method to retrieve a user by email
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM user WHERE email = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Map result set to User object
                    User user = new User(rs.getInt("user_id"), rs.getString("user_name"),
                            rs.getString("email"), rs.getString("password"), rs.getString("user_role"));
                    return user;
                }
            }
        }
        return null; // User not found or error occurred
    }

    // Method to retrieve user ID by email and password for login
    public int getUserIdByEmailAndPassword(String email, String password) throws SQLException {
        String query = "SELECT user_id FROM user WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("user_id");
                }
            }
        }
        return -1; // User not found or invalid credentials
    }

    // Method to update user details
    public boolean updateUser(int userId, String newName, String newEmail, String newPassword) throws SQLException {
        String query = "UPDATE user SET user_name = ?, email = ?, password = ? WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setString(2, newEmail);
            stmt.setString(3, newPassword);
            stmt.setInt(4, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if update is successful
        }
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = ConnectionManagerDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getString("user_role"),
                        rs.getString("password")
                );
                userList.add(user);
            }
        }
        return userList;
    }

    public static User getUserById(int userId) throws SQLException {
        User user = null;
        String query = "SELECT * FROM user WHERE user_id = ?";

        try (Connection conn = ConnectionManagerDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                            rs.getInt("user_id"),
                            rs.getString("user_name"),
                            rs.getString("email"),
                            rs.getString("user_role"),
                            rs.getString("password")
                    );
                }
            }
        }
        return user;
    }
}
