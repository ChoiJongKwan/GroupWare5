/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */
package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import probono.model.entity.Activist;
import probono.model.entity.Probono;
import probono.model.entity.ProbonoProject;
import util.DBUtil;

@Repository
public class ProbonoProjectDAO {

	// 프로보노 프로젝트 저장
	public static boolean addProbonoProject(ProbonoProject probonoProject) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(probonoProject);
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

	// 수정
	// 프로보노 프로젝트 ID로 재능기부자 수정
	public static boolean updateProbonoProjectActivist(int projectId, @NonNull Activist activistId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ProbonoProject probonoProject = null;
		try {

			tx.begin();
			probonoProject = em.find(ProbonoProject.class, projectId);
			probonoProject.setActivist(activistId);
			em.persist(probonoProject);
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



	// 삭제
	// 프로보노 프로젝트 id로 프로보노 프로젝트 삭제
	public static boolean deleteProbonoProject(int probonoProjectId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ProbonoProject probonoProject = em.find(ProbonoProject.class, probonoProjectId);
			em.remove(probonoProject);
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



	// 모든 프로보노 프로젝트 검색
	public static List<ProbonoProject> getAllProbonoProjects() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<ProbonoProject> all = null;

		try {
			tx.begin();

			all = (List<ProbonoProject>) em.createNamedQuery("ProbonoProject.allProbonoProject").getResultList();

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return all;
	}
	
	@Test
	public void TestActivist() {
		
		Activist a1 = new Activist("aaa");
		Probono p1 = new Probono("aaa");
		try {
			addProbonoProject(new ProbonoProject("xx","xx",p1,a1));
			getAllProbonoProjects();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
