/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ConnectionManagerDAO;
import DAO.UserDAO;
import Entities.User;
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message", "Please enter both email and password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Connection connection = null;
        try {
            connection = ConnectionManagerDAO.getConnection();
            UserDAO userDao = new UserDAO();
            User user = userDao.getUserByEmail(email);

            if (user == null || !user.getPassword().equals(password)) {
                request.setAttribute("message", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            HttpSession session = request.getSession();
            session.setAttribute("user_name", user.getUser_name());
            session.setAttribute("user_role", user.getUser_role().toUpperCase());
            session.setAttribute("user_id", user.getUser_id());

            if (user.getUser_role().equals("admin")) {
                response.sendRedirect("AdminPage.jsp");
            } else {
                response.sendRedirect("UserPage.jsp");
            }
        } catch (SQLException e) {
            // Redirect to error.jsp in case of database error
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            // Redirect to error.jsp in case of class not found error
            request.setAttribute("errorMessage", "Internal server error.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            ConnectionManagerDAO.closeConnection(connection);
        }
    }
}
