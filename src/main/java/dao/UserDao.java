package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import util.DBUtil;

public class UserDao {
	private UserDao() {
	};

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	DBUtil util = DBUtil.getInstance();

	public int insert(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = util.getConnection();
			String sql = "insert into userinfo values(?,?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddress());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("user insert error");
			e.printStackTrace();
			throw e;
		} finally {
			util.close(conn, pstmt);
		}
		return result;
	}

	public User selectOne(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User result = null;

		try {
			conn = util.getConnection();

			String sql = "select id, pw, name, address from userinfo where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) //
				result = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

		} catch (SQLException e) {
			System.out.println("user find error");
			e.printStackTrace();

		} finally {
			util.close(rs, conn, pstmt);
		}
		return result;
	}

	public int updateOne(String pw, String address, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			String sql = "update userinfo set pw=?, address=?\r\n" + "where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, address);
			pstmt.setString(3, id);

			result = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("insert error");
			ex.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

}