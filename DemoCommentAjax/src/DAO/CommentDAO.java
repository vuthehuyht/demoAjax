package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Comment;

public class CommentDAO {
	public static void insertComment(Connection conn, Comment comment) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		String sql = "INSERT INTO comment(content,username) VALUES(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			String content = comment.getContent();
			String username = comment.getUsername();
			
			stmt.setString(1, content);
			stmt.setString(2,username);
			
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Comment> displayComment(Connection conn){
		List<Comment> result = new ArrayList<>();
		String sql = "SELECT * FROM demo_comment.comment";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String content = rs.getString("content");
				String username = rs.getString("username");
				
				Comment cmt = new Comment(content, username);
				
				result.add(cmt);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
