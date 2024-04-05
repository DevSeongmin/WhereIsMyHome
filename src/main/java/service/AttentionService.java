package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AttentionDao;
import dto.Attention;

public class AttentionService {
	private AttentionService() {
	};

	private static AttentionService instance = new AttentionService();

	public static AttentionService getInstance() {
		return instance;
	}

	AttentionDao adao = AttentionDao.getInstance();

	public List<Attention> findList(String id) {
		List<Attention> result = adao.selectId(id);
		return result;
	}

	public List<Long> findAptList(String id) {
		List<Attention> list = adao.selectId(id);
		List<Long> aptList = new ArrayList<>();
		for (Attention att : list) {
			aptList.add(att.getAptCode());
		}
		return aptList;
	}

	public Attention getAttention(String aptCode, String id) throws SQLException {
		return adao.selectOne(aptCode, id);
	}

	public void addAttention(Attention attention) {
		adao.insert(attention);

	}

	public void delete(Attention attention) {
		adao.delete(attention);
	}
}