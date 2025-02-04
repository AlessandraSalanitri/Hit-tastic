/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PointOfInterestDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user_name") != null) {
            try {
                int poiId = Integer.parseInt(request.getParameter("poi_id"));
                int userId = (int) session.getAttribute("user_id");
                String commentText = request.getParameter("comments");

                PointOfInterestDAO dao = new PointOfInterestDAO();
                dao.addComment(poiId, commentText, userId);

                response.sendRedirect("SearchResults.jsp");
            } catch (NumberFormatException | SQLException ex) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing your request");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
