/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DBConn.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aless
 */
@WebServlet(name = "DeleteCommentsServlet", urlPatterns = {"/DeleteCommentsServlet"})
public class DeleteCommentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get existing session if it exists
        if (session != null) {
            String userRole = (String) session.getAttribute("user_role"); // Retrieve user role

            // Check if the user role is admin or user
            if (userRole != null && (userRole.equalsIgnoreCase("admin") || userRole.equalsIgnoreCase("user"))) {
                // Get the comment ID from the request
                String commentIdStr = request.getParameter("comment_id");

                // Check if the comment ID is provided
                if (commentIdStr != null && !commentIdStr.isEmpty()) {
                    int commentId = Integer.parseInt(commentIdStr);

                    // Check if the user is admin or if it's a user trying to delete their own comment
                    if (userRole.equalsIgnoreCase("admin") || isUserComment(session, commentId)) {
                        // Delete the comment from the database
                        if (deleteComment(commentId)) {
                            // Redirect to a success page or notify the user about the deletion
                            response.sendRedirect("ViewAllCommentsServlet");
                        } else {
                            // Handle failure to delete comment
                            response.sendRedirect("error.jsp");
                        }
                    } else {
                        // User is not authorized to delete this comment
                        System.out.println("Sorry, you are not authorized.");
                        response.sendRedirect("error.jsp");
                    }
                } else {
                    // Comment ID parameter is missing or empty
                    System.out.println("Sorry, comment id is missing or empty");
                    response.sendRedirect("error.jsp");
                }
            } else {
                // Invalid user role
                System.out.println("Sorry, invalid user role");
                response.sendRedirect("error.jsp");
            }
        } else {
            // Session is null
            System.out.println("Sorry, please try again");
            response.sendRedirect("error.jsp");
        }
    }

    // Method to check if a comment belongs to the current user
    private boolean isUserComment(HttpSession session, int commentId) {
        // Implement logic to check if the comment belongs to the current user
        // For now, let's assume the comment belongs to the current user
        return true;
    }

    // Method to delete a comment from the database
    private boolean deleteComment(int commentId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM comments WHERE comment_id = ?");
            stmt.setInt(1, commentId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            return false;
        }
    }
}
