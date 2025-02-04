/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.UserDAO;
import Entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "ViewAllUsersServlet", urlPatterns = {"/ViewAllUsersServlet"})
public class ViewAllUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String userRole = (String) session.getAttribute("user_role");
        boolean isLoggedIn = session.getAttribute("user_id") != null; // Check if user is logged in

        // Check if the user is logged in
        if (isLoggedIn) {
            // Check the user's role
            if (userRole != null && userRole.equalsIgnoreCase("admin")) {
                // If the user is an admin, display all users
                displayAllUsersForAdmin(request, response);
            } else {
                // If the user is not an admin, display their details
                displayCurrentUserDetails(request, response, session);
            }
        } else {
            // If the user is not logged in, redirect to the login page
            System.out.println("Sorry, to view your credential you need to login");
            response.sendRedirect("login.jsp");
        }
    }

    private void displayAllUsersForAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<User> userList = UserDAO.getAllUsers();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("viewAllUsersAdmin.jsp").forward(request, response);
        } catch (IOException | SQLException | ServletException e) {
            request.setAttribute("errorMessage", "Error fetching user list: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void displayCurrentUserDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        int currentUserId = (int) session.getAttribute("user_id");
        try {
            User currentUser = UserDAO.getUserById(currentUserId);
            if (currentUser != null) {
                request.setAttribute("currentUser", currentUser);
                request.getRequestDispatcher("EditUser.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } catch (IOException | SQLException | ServletException e) {
            request.setAttribute("errorMessage", "Error fetching user details: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
