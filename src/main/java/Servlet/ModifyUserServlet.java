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
@WebServlet(name = "ModifyUserServlet", urlPatterns = {"/ModifyUserServlet"})
public class ModifyUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

               // Proceed with modification logic
                String newUser_name = request.getParameter("newUser_name");
                String newEmail = request.getParameter("newEmail");
                String newPassword = request.getParameter("newPassword");

    }

    private void modifyUser(String newUser_name, String newEmail, String newPassword, String newUser_role)
            throws ServletException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE user SET user_name = ?, email = ?, password = ? WHERE user_id = ?");
            stmt.setString(1, newUser_name);
            stmt.setString(2, newEmail);
            stmt.setString(3, newPassword);
            stmt.setString(4, newUser_role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
