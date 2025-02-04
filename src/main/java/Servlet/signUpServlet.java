/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ConnectionManagerDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
@WebServlet(name = "signUpServlet", urlPatterns = {"/signUpServlet"})
public class signUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("user_name");
        String email = request.getParameter("email");
        String userRole = request.getParameter("user_role"); // Change to match form field name
        String password = request.getParameter("password");

        Connection connection = null; // Declare connection
        try {
            // Open a connection
            connection = ConnectionManagerDAO.getConnection();

            // Create a UserDAO instance
            UserDAO userDAO = new UserDAO();

            // Register the user
            boolean registrationSuccessful = userDAO.registerUser(username, email, userRole, password); 
            if (registrationSuccessful) {
                // If registration is successful, redirect to a success page
                response.sendRedirect("registrationSuccess.jsp");
            } else {
                // If registration fails, redirect back to the sign-up page with an error message
                response.sendRedirect("signUp.jsp?error=true");
            }
        } catch (SQLException ex) {
            Logger.getLogger(signUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("errorPage.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close the connection 
            ConnectionManagerDAO.closeConnection(connection);
        }
    }
}
