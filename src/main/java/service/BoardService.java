package service;

import java.sql.SQLException;
import java.util.List;

import dao.BoardDao;
import dto.BoardDto;

public class BoardService {

	private BoardService() {
	};

	private static BoardService boardService = new BoardService();

	public static BoardService getInstance() {
		return boardService;
	}

	BoardDao boardDao = BoardDao.getInstance();

	public List<BoardDto> list() throws SQLException {

		return boardDao.list();
	}

	public void post(BoardDto boardDto) throws SQLException {
		boardDao.post(boardDto);
	}

	public BoardDto view(String boardNo) throws SQLException {
		return boardDao.view(boardNo);
	}

}
