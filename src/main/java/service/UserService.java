package service;

import dao.UserDao;
import dto.User;

public class UserService {
	private UserService() {
	};

	private static UserService instance = new UserService();

	public static UserService getInstance() {
		return instance;
	}

	UserDao udao = UserDao.getInstance();

	public int join(User user) throws Exception {
		int result = udao.insert(user);
		if (result == 0) {
			throw new Exception("가입 실패");
		}
		return result;
	}

	public User find(String id, String pw) throws Exception {
		User result = udao.selectOne(id, pw);
		if (result == null) {
			throw new Exception("id 또는 password를 확인하세요.");
		}
		return result;
	}

	public int modifyInfo(String pw, String address, String id) throws Exception {
		int result = udao.updateOne(pw, address, id);
		if (result == 0) {
			throw new Exception("수정 실패");
		}
		return result;
	}

}