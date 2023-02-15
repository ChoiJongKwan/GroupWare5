package team3.groupware5.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Notice;
@Repository
public class NoticeDAO {
	
	public boolean writeNotice(Notice notice) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
	
			try {
				tx.begin();
				System.out.println(notice);
				em.persist(notice);
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
	
	public ArrayList<Notice> getAllNotices(){
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		ArrayList<Notice> list = null;

		try {
			tx.begin();
			
			list = (ArrayList<Notice>) em.createNamedQuery("Notice.allNotice").getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public Notice getNoticeNo(int no){
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Notice notice = null;
		try {
			tx.begin();
			notice = em.find(Notice.class, no);
			em.persist(notice);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return notice;
	}
	
	public boolean updateNotice(Notice notice) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Notice n = null;
		try {
			tx.begin();
			n = em.find(Notice.class,notice.getNo());
			if(n.getPassword().equals(notice.getPassword())){
				n.setContent(notice.getContent());
				n.setTitle(notice.getTitle());
			}else {
				System.out.println("비밀번호 틀림");//에러로 넘겨야함 !!(수정필요)
			}
			
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return false;
	}
	
	public boolean deleteNotice(int boardno) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		try {
			tx.begin();
			Notice notice = em.find(Notice.class, boardno);
			em.remove(notice);
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
