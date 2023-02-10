package team3.groupware5.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Todolist;

@Repository
public class TodolistDAO {
	public void createTodolist() {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Todolist todolist = new Todolist();
			em.persist(todolist);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	@Transactional
	public ArrayList<Todolist> getTodolistAll() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Todolist> all = null;
		try {
			all = em.createQuery("select t from Todolist t",Todolist.class).getResultList();
		} finally {
			em.close();

		}
		return  (ArrayList<Todolist>) all;
	}
	
	public String getTodolistOne() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		
		
		Todolist e1 = null;
		try {
			 e1 = em.find(Todolist.class, 1);
			
		} finally {
			em.close();
		}
		return  "제목:"+e1.getTitle()+", 내용:"+e1.getContent()+", 중요도:"+e1.getImportance()+", 해결여부:"+e1.getChecked()+", 시:"+e1.getDate()+", 분:"+e1.getTime();
	}
	

}
