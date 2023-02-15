package team3.groupware5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.BoardDAO;
import team3.groupware5.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	
	public boolean writeBoard(Board board) {
		return boardDao.writeBoard(board);
	}
		
	public ArrayList<Board> getAllBoards() {
		ArrayList<Board> list = boardDao.getAllBoards();
		return list;
	}
	
	public Board getBoardNo(int boardno) {
		return boardDao.getBoardNo(boardno);
	}
	
	public boolean updateBoard(Board board) {
		return boardDao.updateBoard(board);
	}
	
	public boolean deleteBoard(int boardno) {
		return boardDao.deleteBoard(boardno);
	}

}
