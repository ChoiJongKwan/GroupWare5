/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import probono.model.entity.Activist;
import util.DBUtil;

@Repository
public class ActivistDAO {
	
	public static boolean addActivist(Activist activist) throws SQLException{
			EntityManager em = DBUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				em.persist(activist);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			return false;
		}
	
		//수정  
		//기부자 id로 주요 기부 내용 수정하기
		public static boolean updateActivist(String activistId, String major) throws SQLException{
			EntityManager em = DBUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();
		try {
				tx.begin();
				Activist activist = em.find(Activist.class, activistId);
				activist.setMajor(major);
				em.persist(activist);
				tx.commit();
				
				return true;
			} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			}finally{
				
				em.close();
		}
			return false;
		}

	

		
		public static boolean deleteActivist(String activistId) throws SQLException{
			EntityManager em = DBUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				Activist activist = em.find(Activist.class, activistId);
				em.remove(activist);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			return false;
		}	
		//id로 해당 기부자의 모든 정보 반환
		public static Activist getActivist(String activistId) throws SQLException{
			
			EntityManager em = DBUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			try {
				tx.begin();
				Activist activist = em.find(Activist.class, activistId);
				
				if(activist != null){
					System.out.println();
					
					return new Activist(activist.getId(),activist.getName(),activist.getPassword(),activist.getMajor());
					
				}
				tx.commit();
				}catch (Exception e) {
					tx.rollback();
					e.printStackTrace();
				}finally {
					em.close();
				}
			return null;
			}
			
	
 
		//???모든 기부자 검색해서 반환
		//sql - select * from activist/
		public static List<Activist> getAllActivists() throws SQLException {
			EntityManager em = DBUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			List<Activist> all = null;
			
			try{
				tx.begin();
				
				all =(List<Activist>)em.createNamedQuery("Activist.allActivist").getResultList();
				
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}finally{
				em.close();
			}
			return all;
		}
		
		@Test
		public void TestActivist() {
			try {
				updateActivist("aaa","bbb");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

}
