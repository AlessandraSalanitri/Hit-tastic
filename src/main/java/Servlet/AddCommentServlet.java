/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ConnectionManagerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
@WebServlet(name = "AddCommentServlet", urlPatterns = {"/AddCommentServlet"})
public class AddCommentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int poiId = Integer.parseInt(request.getParameter("poi_id"));
        int userId = Integer.parseInt(request.getParameter("user_id")); 
        String commentText = request.getParameter("comment_text");

        try (Connection conn = ConnectionManagerDAO.getConnection()) {
            String sql = "INSERT INTO comments (comment_text, user_id, poi_id) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, commentText);
                pstmt.setInt(2, userId);
                pstmt.setInt(3, poiId);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            // Handle exceptions

        }

        response.sendRedirect("ViewCommentsServlet?poiId=" + poiId); // Redirect back to view comments
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
