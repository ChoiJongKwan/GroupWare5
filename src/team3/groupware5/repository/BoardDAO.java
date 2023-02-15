package team3.groupware5.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Board;

@Repository
public class BoardDAO {

	public boolean writeBoard(Board board) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(board);
			tx.commit();
			return true;

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return false;
	}

	public ArrayList<Board> getAllBoards() {
		EntityManager em = DBUtil.getEntityManager();

		ArrayList<Board> list = null;

		try {

			list = (ArrayList<Board>) em.createNamedQuery("Board.allBoard").getResultList();
			//tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public Board getBoardNo(int boardno) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Board board = null;
		try {
			tx.begin();
			board = em.find(Board.class, boardno);
			System.out.println("보드객체에 저장된 값 : " + board);
			em.persist(board);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return board;
	}

	public boolean updateBoard(Board board) {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Board b = null;
		try {
			tx.begin();
			b = em.find(Board.class, board.getNo());
			if (b.getPassword().equals(board.getPassword())) {
				b.setContent(board.getContent());
				b.setTitle(board.getTitle());
			} else {
				System.out.println("비밀번호 틀림");// 에러로 넘겨야함 !!(수정필요)
			}

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return false;
	}
	
	public boolean deleteBoard(int boardno) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println("이거ㅜ뭐냐고");
		
		try {
			tx.begin();
			Board board = em.find(Board.class, boardno);
			em.remove(board);
			tx.commit();
			return true;

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

}
