/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.CommentDAO;
import DBConn.DBConnection;
import Entities.Comments;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "ViewAllCommentsServlet", urlPatterns = {"/ViewAllCommentsServlet"})
public class ViewAllCommentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Comments> commentsList = CommentDAO.getAllComments();
            request.setAttribute("commentsList", commentsList);
            request.getRequestDispatcher("ViewAllComments.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching comments: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private List<Comments> getCommentsFromResultSet(ResultSet rs) throws SQLException {
        List<Comments> commentsList = new ArrayList<>();
        while (rs.next()) {
            Comments comment = new Comments(
                    rs.getInt("comment_id"),
                    rs.getString("comment_text"),
                    rs.getInt("user_id"), rs.getTimestamp("timestamp"),
                    rs.getInt("poi_id"), rs.getString("user_name")
            );
            commentsList.add(comment);
        }
        return commentsList;
    }
}
