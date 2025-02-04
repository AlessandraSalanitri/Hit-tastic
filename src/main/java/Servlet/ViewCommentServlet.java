/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ConnectionManagerDAO;
import Entities.Comments;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
@WebServlet(name = "ViewCommentServlet", urlPatterns = {"/ViewCommentServlet"})
public class ViewCommentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int poiId = Integer.parseInt(request.getParameter("poiId"));
        List<Comments> commentsList = new ArrayList<>();

        try (Connection conn = ConnectionManagerDAO.getConnection()) {
            String sql = "SELECT comments.*, user.user_name FROM comments INNER JOIN user ON comments.user_id = user.user_id WHERE poi_id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, poiId);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Comments comment = new Comments(
                            rs.getInt("comment_id"),
                            rs.getString("comment_text"),
                            rs.getInt("user_id"),
                            rs.getTimestamp("timestamp"),
                            poiId,
                            rs.getString("user_name"));
                    commentsList.add(comment);
                }
            }
        } catch (Exception e) {
            // Handle exceptions

        }

        request.setAttribute("commentsList", commentsList);
        request.getRequestDispatcher("/Comments.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int poiId = Integer.parseInt(request.getParameter("poi_id"));
        List<Comments> commentsList = new ArrayList<>();

        // Fetch comments from the database similar to previous examples
        // Assume commentsList is populated with the comments for the given poiId
        request.setAttribute("commentsList", commentsList);
        request.getRequestDispatcher("/Comments.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
