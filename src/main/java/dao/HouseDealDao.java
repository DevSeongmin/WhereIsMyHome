package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HouseDeal;
import util.DBUtil;

public class HouseDealDao {
	private HouseDealDao() {
	};

	private static HouseDealDao dao = new HouseDealDao();

	public static HouseDealDao getInstance() {
		return dao;
	}

	private DBUtil db = DBUtil.getInstance();

	public List<HouseDeal> selectAllByAptCode(long aptCode, String year, String month) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseDeal> result = new ArrayList<HouseDeal>();

		try {
			conn = db.getConnection();
			String sql = "";
			if ("all".equals(year)) {
				sql = "select * from housedeal where aptCode = ?";
			} else if ("all".equals(month)) {
				sql = "select * from housedeal where aptCode = ? and dealYear = ?";
			} else {
				sql = "select * from housedeal where aptCode = ? and dealYear = ? and dealMonth = ?";
			}

			pstmt = conn.prepareStatement(sql);

			if ("all".equals(year)) {
				pstmt.setLong(1, aptCode);
			} else if ("all".equals(month)) {
				pstmt.setLong(1, aptCode);
				pstmt.setString(2, year);
			} else {
				pstmt.setLong(1, aptCode);
				pstmt.setString(2, year);
				int m = Integer.parseInt(month);
				pstmt.setString(3, m + "");
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = 1;
				HouseDeal h = new HouseDeal(rs.getLong(idx++), rs.getString(idx++), rs.getInt(idx++), rs.getInt(idx++),
						rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getLong(idx++));
				result.add(h);
			}

		} finally {
			db.close(rs, pstmt, conn);
		}

		return result;
	}

	public HouseDeal selectOne(String no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HouseDeal result = null;

		try {
			conn = db.getConnection();
			String sql = "select * from housedeal where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Long.parseLong(no));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int idx = 1;
				HouseDeal h = new HouseDeal(rs.getLong(idx++), rs.getString(idx++), rs.getInt(idx++), rs.getInt(idx++),
						rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getLong(idx++));
				result = h;
			}

		} finally {
			db.close(rs, pstmt, conn);
		}

		return result;
	}
}
