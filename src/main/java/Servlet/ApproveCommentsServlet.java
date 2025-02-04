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

/**
 *
 * @author aless
 */
@WebServlet(name = "ApproveCommentsServlet", urlPatterns = {"/ApproveCommentsServlet"})
public class ApproveCommentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the comment ID from the request parameters
        String commentIdParam = request.getParameter("comment_id");
        if (commentIdParam != null && !commentIdParam.isEmpty()) {
            try {
                int commentId = Integer.parseInt(commentIdParam);

                // Proceed with approval logic (e.g., update comment status in the database)
                if (approveComment(commentId)) {
                    // Redirect the user to the ViewAllCommentsServlet after approval
                    response.sendRedirect("ViewAllCommentsServlet");
                } else {
                    // Handle failure to approve comment (delete the comment)
                    if (deleteComment(commentId)) {
                        // Redirect the user to the ViewAllCommentsServlet after deleting the comment
                        response.sendRedirect("ViewAllCommentsServlet");
                    } else {
                        // Handle failure to delete comment
                        System.out.println("Sorry, is not possible delete this comment.");
                        response.sendRedirect("error.jsp");
                    }
                }
            } catch (NumberFormatException e) {
                // Handle invalid comment ID format
                System.out.println("Sorry, invalid comment id.");
                response.sendRedirect("error.jsp");
            }
        } else {
            // Handle missing comment ID parameter
            System.out.println("Sorry, your request can't be executed. Missing comment ID");
            response.sendRedirect("error.jsp");
        }
    }

    // Method to update the comment status as approved in the database
    private boolean approveComment(int commentId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE comments SET status = 'approved' WHERE comment_id = ?");
            stmt.setInt(1, commentId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete the comment from the database
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
