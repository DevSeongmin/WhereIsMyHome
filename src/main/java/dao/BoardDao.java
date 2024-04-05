package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import util.DBUtil;

public class BoardDao {

	private BoardDao() {
	};

	private static BoardDao boardDao = new BoardDao();

	public static BoardDao getInstance() {
		return boardDao;
	}

	public List<BoardDto> list() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> list = new ArrayList<>();

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from board \n");
			sql.append("order by post_date desc");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNo(rs.getString("board_no"));
				boardDto.setUserId(rs.getString("id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPostDate(rs.getString("post_date"));
				list.add(boardDto);
			}
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return list;
	}

	public void post(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board(id, subject, content) \n");
			sql.append("values(?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());

			pstmt.executeUpdate();

		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

	public BoardDto view(String boardNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from board \n");
			sql.append("where board_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardNo);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNo(rs.getString("board_no"));
				boardDto.setUserId(rs.getString("id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPostDate(rs.getString("post_date"));
				return boardDto;
			}
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}

		return null;
	}

}
