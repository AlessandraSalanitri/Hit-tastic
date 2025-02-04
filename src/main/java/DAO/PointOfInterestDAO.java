/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConn.DBConnection;
import Entities.Comments;
import Entities.PointOfInterest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointOfInterestDAO {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<PointOfInterest> searchByType(String poiType) throws SQLException {
        List<PointOfInterest> searchResults = new ArrayList<>();
        String query = "SELECT * FROM pointOfInterest WHERE poi_type = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, poiType);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PointOfInterest poi = new PointOfInterest(
                            rs.getInt("poi_id"),
                            rs.getString("poi_name"),
                            rs.getString("poi_location"),
                            rs.getString("poi_type"),
                            rs.getInt("poi_likes"));
                    searchResults.add(poi);
                }
            }
        }
        return searchResults;
    }

    public List<PointOfInterest> getPointsOfInterestByLetter(String letter) throws SQLException {
        List<PointOfInterest> searchResults = new ArrayList<>();
        String query = "SELECT * FROM pointOfInterest WHERE poi_name LIKE ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, letter + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PointOfInterest poi = new PointOfInterest(
                            rs.getInt("poi_id"),
                            rs.getString("poi_name"),
                            rs.getString("poi_location"),
                            rs.getString("poi_type"),
                            rs.getInt("poi_likes"));
                    searchResults.add(poi);
                }
            }
        }
        return searchResults;
    }


    public PointOfInterest getPointOfInterestById(int poiId) throws SQLException {
        PointOfInterest poi = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Get connection from ConnectionManagerDAO
            connection = ConnectionManagerDAO.getConnection();

            // Prepare SQL statement to retrieve point of interest by ID
            String sql = "SELECT * FROM pointOfInterest WHERE poi_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, poiId);

            // Execute query
            rs = stmt.executeQuery();

            // Check if a point of interest was found
            if (rs.next()) {
                // Populate a PointOfInterest object with data from the ResultSet
                poi = new PointOfInterest(
                        rs.getInt("poi_id"), rs.getString("poi_name"),
                        rs.getString("poi_location"),
                        rs.getString("poi_type"), rs.getInt("poi_likes")
                );
            }
        } finally {
            // Close JDBC resources in a finally block to ensure they're always closed
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return poi;
    }

    public static void addNewPointOfInterest(PointOfInterest poi) throws SQLException {

        String sql = "INSERT INTO pointOfInterest (poi_name, poi_location, poi_type, poi_likes) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, poi.getPoi_name());
            stmt.setString(2, poi.getPoi_location());
            stmt.setString(3, poi.getPoi_type());
            stmt.setInt(4, poi.getPoi_likes());

            stmt.executeUpdate();
        }

    }

    public static List<PointOfInterest> getAllPointsOfInterest() throws SQLException {
        List<PointOfInterest> pointsOfInterest = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM pointOfInterest";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int poi_id = resultSet.getInt("poi_id");
                String poi_name = resultSet.getString("poi_name");
                String poi_location = resultSet.getString("poi_location");
                String poi_type = resultSet.getString("poi_type");
                int poi_likes = resultSet.getInt("poi_likes");

                // Correct usage of resultSet within its scope
                PointOfInterest poi = new PointOfInterest(poi_id, poi_name, poi_location, poi_type, poi_likes);
                pointsOfInterest.add(poi);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return pointsOfInterest;
    }

    public void addComment(int poiId, String commentText, int userId) throws SQLException {
        String query = "INSERT INTO comments (poi_id, comment_text, user_id) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionManagerDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, poiId);
            statement.setString(2, commentText);
            statement.setInt(3, userId);
            statement.executeUpdate();
        }
    }

    public void incrementLikes(int poiId) throws SQLException {
        String query = "UPDATE pointOfInterest SET poi_likes = poi_likes + 1 WHERE poi_id = ?";
        try (Connection connection = ConnectionManagerDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, poiId);
            statement.executeUpdate();
        }
    }

    public List<Comments> getCommentsForPointOfInterest(int poiId) throws SQLException {
        List<Comments> comments = new ArrayList<>();
        String query = "SELECT c.comment_id, c.comment_text, c.user_id, c.timestamp, u.user_name "
                + "FROM comments c "
                + "INNER JOIN user u ON c.user_id = u.user_id "
                + "WHERE c.poi_id = ?";

        // Correctly establish a database connection before preparing the statement
        try (Connection connection = ConnectionManagerDAO.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, poiId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Comments comment = new Comments(
                            rs.getInt("comment_id"),
                            rs.getString("comment_text"),
                            rs.getInt("user_id"),
                            rs.getTimestamp("timestamp"),
                            poiId, // Correctly passed
                            rs.getString("user_name") // Correctly fetches user_name from the query
                    );
                    comments.add(comment);
                }
            }
        }
        return comments;
    }
}
