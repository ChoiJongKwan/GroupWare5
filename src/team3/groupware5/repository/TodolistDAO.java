package team3.groupware5.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Employee;
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

	public ArrayList<Todolist> getTodolistAll() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Todolist> all = null;
		try {
			all = em.createQuery("select t from Todolist t order by importance desc",Todolist.class).getResultList();
		} finally {
			em.close();

		}
		return   (ArrayList<Todolist>) all;
	} 
	
	public ArrayList<Todolist> getTodolistOne(int employeeNo) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Todolist> all = null;
		try {
			all = em.createQuery("select t from Todolist t where t.employeeNo.employeeNo = :employeeNo",Todolist.class).setParameter("employeeNo", employeeNo).getResultList();
		} finally {
			em.close();

		}
		return   (ArrayList<Todolist>) all;
	} 
	
	
	

	public boolean insertTodolist(Todolist todolist) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			System.out.println(todolist);
			em.persist(todolist);
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

	public boolean deleteTodolist(int num) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Todolist td = em.find(Todolist.class, num);
			if (td != null) {
				em.remove(td);
			}else {
				System.out.println("삭제하려는 일정이 없습니다");
			}
			
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}


}

}
