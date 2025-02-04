/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PointOfInterestDAO;
import Entities.PointOfInterest;
import java.io.IOException;
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
@WebServlet(name = "AddNewPointOfInterestServlet", urlPatterns = {"/AddNewPointOfInterestServlet"})
public class AddNewPointOfInterestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String poiName = request.getParameter("poi_name");
        String poiLocation = request.getParameter("poi_location");
        String poiType = request.getParameter("poi_type");

        // Initialize likes count with 0
        int poiLikes = 0;

        // Correctly initialize PointOfInterest object without rs.getInt("poi_likes")
        PointOfInterest poi = new PointOfInterest(poiLikes, poiName, poiLocation, poiType, poiLikes);

        try {
            // Call a method in the DAO to insert the new point of interest into the database
            PointOfInterestDAO.addNewPointOfInterest(poi);

            // Redirect the user to a success page or display a success message
            response.sendRedirect("ViewAllPointsOfInterestServlet");
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            // Redirect or forward to an error page
            request.setAttribute("errorMessage", "Error adding point of interest: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
