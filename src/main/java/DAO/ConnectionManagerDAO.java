/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aless
 */
public class ConnectionManagerDAO {

    private static final String JDBC_URL = "jdbc:sqlite:/C:\\Users\\aless\\OneDrive\\Documenti\\NetBeansProjects\\SQLITE\\sqlite-tools-win-x64-3450100\\HitTastic.db";

    // Method to establish a connection to the SQLite database
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            // Handle ClassNotFoundException gracefully
            throw new SQLException("SQLite JDBC driver not found", ex);
        }

        // Create a connection
        return DriverManager.getConnection(JDBC_URL);
    }

    // Method to close a connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                // Log or handle the exception appropriately
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}
