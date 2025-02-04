/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PointOfInterestDAO;
import Entities.PointOfInterest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
@WebServlet(name = "ViewAllPointsOfInterestServlet", urlPatterns = {"/ViewAllPointsOfInterestServlet"})
public class ViewAllPointsOfInterestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch all points of interest from the database
            List<PointOfInterest> pointsOfInterest = PointOfInterestDAO.getAllPointsOfInterest();

            // Pass the list of points of interest to the JSP page
            request.setAttribute("pointsOfInterest", pointsOfInterest);

            // Forward the request to the JSP page for rendering
            request.getRequestDispatcher("viewAllPointsOfInterest.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            // Redirect or forward to an error page
            request.setAttribute("errorMessage", "Error fetching points of interest: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
