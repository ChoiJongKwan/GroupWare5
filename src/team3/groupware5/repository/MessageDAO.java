package team3.groupware5.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
//import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Message;


@Repository
public class MessageDAO {
	

	@Transactional
	public Message getDetailMessage(Message messageVo) throws SQLException{
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Message msgOne = null;
		
		try {
			tx.begin();
			
			msgOne = em.createQuery("SELECT M FROM Message M WHERE no=:no", Message.class).setParameter("no", messageVo.getNo()).getSingleResult();
			
			if(msgOne != null) {
				System.out.println(msgOne);
			}else {
				System.out.println("검색 요청한 메세지는 미존재합니다");
			}

			tx.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return (Message) msgOne;
	}
	
	public boolean sendMessage(Message messageVo ) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(messageVo);
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
	
	
	public int answerMessage(Message messageVo ) {
		
//		int count = sqlSession.insert("message.answerMessage", messageVo);

//		return count;
		return 1;
	}
	
	
	public boolean deleteMessage(Message messageVo) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			tx.begin();
			Message msgDel = em.find(Message.class, messageVo);
			
			if (msgDel != null) {
				em.remove(msgDel);
			}else {
				System.out.println("삭제하려는 메시지가 없습니다.");
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			em.close();
		}
		
		return false;
	}
	
	
	public ArrayList<Message> getMessage(Message messageVo) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Message> allMsg = null;
		
		try {
			tx.begin();
			
			allMsg = em.createQuery("SELECT M FROM Message M", Message.class).getResultList();
			
			tx.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return (ArrayList<Message>) allMsg;
	}
}
