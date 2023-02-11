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


}
