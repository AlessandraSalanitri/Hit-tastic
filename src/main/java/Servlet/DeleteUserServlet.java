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
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdParam = request.getParameter("user_id");
        if (userIdParam != null && !userIdParam.isEmpty()) {
            try {
                int user_id = Integer.parseInt(userIdParam);

                // Proceed with deletion logic
                try (Connection conn = DBConnection.getConnection()) {
                    PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE user_id = ?");
                    stmt.setInt(1, user_id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    response.getWriter().println("Database error: " + e.getMessage());
                    return; // Exit method to prevent further execution
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid user ID format");
                return; // Exit method to prevent further execution
            }
        } else {
            response.getWriter().println("User ID parameter is missing");
            return; // Exit method to prevent further execution
        }

        // After deleting the user, redirect to ViewAllUsersServlet with a parameter to indicate success
        response.sendRedirect("ViewAllUsersServlet?deleted=true");
    }
}
