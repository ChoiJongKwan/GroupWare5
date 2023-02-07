/*
 * CREATE TABLE probono (
       probono_id           	VARCHAR2(50) PRIMARY KEY,
       probono_name     	VARCHAR2(50) NOT NULL,
       probono_purpose  VARCHAR2(200) NOT NULL
);  */
package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import probono.model.entity.Probono;
import util.DBUtil;


@Repository
public class ProbonoDAO {	
	
	//저장
	public static boolean addProbono(Probono probono) throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(probono);
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
	//프로보노 id로 프로보노 목적 수정하기
	public static boolean updateProbono(String probonoId, String probonoPurpose) throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Probono probono = null;
	try {
			
			tx.begin();
			probono = em.find(Probono.class, probonoId);
			probono.setProbonoPurpose(probonoPurpose);
			em.persist(probono);
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


	//삭제 
	public static boolean deleteProbono(String probonoId) throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Probono probono = em.find(Probono.class, probonoId);
			em.remove(probono);
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
	
	//프로포노 아이디로 해당 프로보노 모든 정보 검색
	public static Probono getProbono(String probonoId) throws SQLException{
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Probono probono = em.find(Probono.class, probonoId);
			
			if(probono != null){
				System.out.println();
				
				return new Probono(probono.getProbonoId(),probono.getProbonoName(),probono.getProbonoPurpose());
				
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

	//모든 프로보노 검색
	public static List<Probono> getAllProbonos() throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<Probono> all = null;
		
		try{
			tx.begin();
			
			all =(List<Probono>)em.createNamedQuery("Probono.allProbono").getResultList();
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
		return all;
	}
}
