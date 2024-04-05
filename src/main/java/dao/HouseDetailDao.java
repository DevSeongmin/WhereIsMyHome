package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HouseDetailDto;
import util.DBUtil;

public class HouseDetailDao {
	
	private HouseDetailDao() {
	};

	private static HouseDetailDao houseDetailDao = new HouseDetailDao();

	public static HouseDetailDao getInstance() {
		return houseDetailDao;
	}

	private DBUtil db = DBUtil.getInstance();

	public List<HouseDetailDto> DetailList(long aptCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseDetailDto> list = new ArrayList<>();
		System.out.println("Detail DTO load");

		try {
			conn = db.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select houseinfo.apartmentName, houseinfo.aptCode, concat(dealYear, \"-\" ,dealMonth, \"-\", dealDay) as dealDate, dealAmount, floor, area\n");
			sql.append("from houseinfo\n");
			sql.append("INNER JOIN housedeal\n");
			sql.append("ON houseinfo.aptCode = housedeal.aptCode\n");
			sql.append("where houseinfo.aptCode = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, aptCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HouseDetailDto houseDetailDto = new HouseDetailDto();
				houseDetailDto.setApartmentName(rs.getString("apartmentName"));
				houseDetailDto.setAptCode(rs.getLong("aptCode"));
				houseDetailDto.setDealDate(rs.getString("dealDate"));
				houseDetailDto.setDealAmount(rs.getString("dealAmount"));
				houseDetailDto.setFloor(rs.getString("floor"));
				houseDetailDto.setArea(rs.getString("area"));
				
				list.add(houseDetailDto);
			}

		} finally {
			db.close(rs, pstmt, conn);
		}
		
		System.out.println("Detail DTO완");
		
		return list;
	}

}
