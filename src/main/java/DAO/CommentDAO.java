/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConn.DBConnection;
import Entities.Comments;
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
public class CommentDAO {
    
    // Method to retrieve all comments from the database
    public static List<Comments> getAllComments() throws SQLException {
        List<Comments> commentsList = new ArrayList<>();
        // SQL query adjusted to include a JOIN with the user table to fetch user_name
        String query = "SELECT c.comment_id, c.comment_text, c.user_id, c.timestamp, c.poi_id, u.user_name "
                + "FROM comments c "
                + "JOIN user u ON c.user_id = u.user_id";

        try (Connection conn = ConnectionManagerDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            commentsList = getCommentsFromResultSet(rs);
        }
        return commentsList;
    }

    // Method to convert ResultSet into a List of Comments
    public static List<Comments> getCommentsFromResultSet(ResultSet rs) throws SQLException {
        List<Comments> commentsList = new ArrayList<>();
        while (rs.next()) {
            Comments comment = new Comments(
                    rs.getInt("comment_id"),
                    rs.getString("comment_text"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("timestamp"),
                    rs.getInt("poi_id"),
                    // Ensure that this method is only called with a ResultSet that includes the user_name
                    rs.getString("user_name") // Assuming the ResultSet includes user_name from a JOIN
            );
            commentsList.add(comment);
        }
        return commentsList;
    }

    // Method to add a new comment to the database
    public static void addComment(Comments comment) throws SQLException {
        String query = "INSERT INTO comments (comment_text, user_id, timestamp, poi_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, comment.getComment_text());
            stmt.setInt(2, comment.getUser_id());
            stmt.setTimestamp(3, comment.getTimestamp());
            stmt.setInt(4, comment.getPoi_id());

            stmt.executeUpdate();
        }
    }

    // Method to delete a comment from the database by comment ID
    public static void deleteComment(int commentId) throws SQLException {
        String query = "DELETE FROM comments WHERE comment_id = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, commentId);
            stmt.executeUpdate();
        }
    }
}
