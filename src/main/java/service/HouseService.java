package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.HouseDealDao;
import dao.HouseInfoDao;
import dao.HouseDetailDao;
import dto.HouseDeal;
import dto.HouseDetailDto;
import dto.HouseInfo;

public class HouseService {
	private HouseService() {
	};

	private static HouseService service = new HouseService();

	public static HouseService getInstance() {
		return service;
	}

	private HouseInfoDao houseInfoDao = HouseInfoDao.getInstance();
	private HouseDealDao houseDealDao = HouseDealDao.getInstance();
	private HouseDetailDao houseDetailDao = HouseDetailDao.getInstance();
	
	// 동코드, 연, 월이 일치하는 housedeal 리스트 반환
	public List<HouseDeal> getHouseDealList(String dongCode, String year, String month) throws SQLException {
		List<HouseDeal> result = new ArrayList<HouseDeal>();

		List<Long> codes = houseInfoDao.selectAllAptCode(dongCode);
		for (long code : codes) {
			result.addAll(houseDealDao.selectAllByAptCode(code, year, month));
		}

		return result;
	}

	public HouseInfo getAptName(String aptCode) throws SQLException {
		return houseInfoDao.selectOneByAptCode(aptCode);
	}

	public HouseDeal getHouseDeal(String no) throws SQLException {
		return houseDealDao.selectOne(no);
	}
	
	public List<HouseDetailDto> getHouseDetail(long aptCode) throws SQLException {
		return houseDetailDao.DetailList(aptCode);
	}

}
