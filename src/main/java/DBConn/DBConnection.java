/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aless
 */
public class DBConnection {

    private static final String JDBC_URL = "jdbc:sqlite:/C:\\Users\\aless\\OneDrive\\Documenti\\NetBeansProjects\\SQLITE\\sqlite-tools-win-x64-3450100\\HitTastic.db";

    // Method to establish a connection to the SQLite database
    public static Connection getConnection() throws SQLException {
        try {
            // Register the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            // Create a connection
            Connection connection = DriverManager.getConnection(JDBC_URL);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle any exceptions
            throw new SQLException("Error connecting to the database: " + ex.getMessage());
        }

    }
}
