package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Comment;
import DAO.CommentDAO;
import DB.ConnectionUtil;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getCharacterEncoding() != null) {
			request.setCharacterEncoding("utf-8");
		}
		try {

			Connection conn = ConnectionUtil.createConnection();
			String content = request.getParameter("content");
			String username = request.getParameter("username");

			Comment cmt = new Comment(content, username);

			CommentDAO.insertComment(conn, cmt);
			List<Comment> res = CommentDAO.displayComment(conn);
			request.setAttribute("commentList", res);
			RequestDispatcher rd = request.getRequestDispatcher("View/DisplayComment.jsp");
			rd.forward(request, response);

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
