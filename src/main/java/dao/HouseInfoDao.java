package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HouseInfo;
import util.DBUtil;

public class HouseInfoDao {
	private HouseInfoDao() {
	};

	private static HouseInfoDao dao = new HouseInfoDao();

	public static HouseInfoDao getInstance() {
		return dao;
	}

	private DBUtil db = DBUtil.getInstance();

	public HouseInfo selectOne(String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HouseInfo result = null;

		try {
			conn = db.getConnection();
			String sql = "select aptCode, buildYear, roadName, roadNameBonbun, roadNameBubun, roadNameSeq, roadNameBasementCode, roadNameCode, dong, bonbun, bubun, sigunguCode, eubmyundongCode, dongCode, landCode, apartmentName, jibun, lng, lat"
					+ " from houseinfo where dongCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int idx = 1;
				result = new HouseInfo(rs.getLong(idx++), rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++));
			}

		} finally {
			db.close(rs, pstmt, conn);
		}

		return result;
	}

	public HouseInfo selectOneByAptCode(String aptCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HouseInfo result = null;

		try {
			conn = db.getConnection();
			String sql = "select aptCode, buildYear, roadName, roadNameBonbun, roadNameBubun, roadNameSeq, roadNameBasementCode, roadNameCode, dong, bonbun, bubun, sigunguCode, eubmyundongCode, dongCode, landCode, apartmentName, jibun, lng, lat"
					+ " from houseinfo where aptCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, Long.parseLong(aptCode));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int idx = 1;
				result = new HouseInfo(rs.getLong(idx++), rs.getInt(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getString(idx++), rs.getString(idx++));
			}

		} finally {
			db.close(rs, pstmt, conn);
		}

		return result;
	}

	public List<Long> selectAllAptCode(String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Long> result = new ArrayList<Long>();

		try {
			conn = db.getConnection();
			String sql = "select aptCode from houseinfo where dongCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(rs.getLong(1));
			}

		} finally {
			db.close(rs, pstmt, conn);
		}

		return result;
	}

}
