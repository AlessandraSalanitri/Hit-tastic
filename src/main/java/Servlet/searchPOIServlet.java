/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ConnectionManagerDAO;
import DAO.PointOfInterestDAO;
import Entities.PointOfInterest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
@WebServlet(name = "searchPOIServlet", urlPatterns = {"/searchPOIServlet"})
public class searchPOIServlet extends HttpServlet {

    private PointOfInterestDAO pointOfInterestDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        pointOfInterestDAO = new PointOfInterestDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(searchPOIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(searchPOIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String searchType = request.getParameter("searchType");
        List<PointOfInterest> searchResults = null;

        try (Connection conn = ConnectionManagerDAO.getConnection()) {
            pointOfInterestDAO.setConnection(conn);

            if ("type".equals(searchType)) {
                String poiType = request.getParameter("poi_type");
                searchResults = pointOfInterestDAO.searchByType(poiType);
            } else if ("locationLetter".equals(searchType)) {
                String letter = request.getParameter("letter");
                searchResults = pointOfInterestDAO.getPointsOfInterestByLetter(letter);
            }

            request.setAttribute("searchResults", searchResults);

            // Decide which JSP to forward to based on searchType
            String forwardJsp = "type".equals(searchType) ? "TypeSelection.jsp" : "LocationLetterSelection.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardJsp);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException("DB error", ex);
        }
    }
}
