package team3.groupware5.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Reply;

@Repository
public class ReplyDAO {
	
	public ArrayList<Reply> getReplyNo(int boardNo){
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println(boardNo);
		ArrayList<Reply> list = null;
		try {
			tx.begin();
			list = (ArrayList<Reply>) em.createNamedQuery("Reply.findReplyNo").setParameter("boardNo", boardNo).getResultList();
			list.forEach(v -> System.out.println());
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public boolean writeReply(Reply reply) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
			try {
				tx.begin();
				System.out.println(reply);
				
				em.persist(reply);
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
