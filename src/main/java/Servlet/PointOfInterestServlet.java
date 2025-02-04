/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PointOfInterestDAO;
import Entities.PointOfInterest;
import java.io.IOException;
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
@WebServlet(name = "PointOfInterestServlet", urlPatterns = {"/PointOfInterestServlet"})
public class PointOfInterestServlet extends HttpServlet {

    private PointOfInterestDAO pointOfInterestDAO; // Define pointOfInterestDAO as an instance variable

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the PointOfInterestDAO in the init() method
        pointOfInterestDAO = new PointOfInterestDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve ID of the point of interest from request parameters
            String poiId = request.getParameter("poi_id");

            // Check if the ID is provided
            if (poiId != null && !poiId.isEmpty()) {
                // Query the database to fetch details of the point of interest with the specified ID
                PointOfInterest poi = pointOfInterestDAO.getPointOfInterestById(Integer.parseInt(poiId));

                if (poi != null) {
                    // Forward the request to a JSP page to display the details of the point of interest
                    request.setAttribute("pointOfInterest", poi);
                    request.getRequestDispatcher("pointOfInterestDetails.jsp").forward(request, response);
                } else {
                    // Handle case where point of interest with the specified ID is not found
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Point of interest not found");
                }
            } else {
                // Handle case where ID parameter is missing or empty
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing or empty");
            }
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(PointOfInterestServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement functionality to handle form submissions for adding, editing, or deleting points of interest
        // For example, you can retrieve form parameters and call appropriate DAO methods to perform CRUD operations
    }
}
