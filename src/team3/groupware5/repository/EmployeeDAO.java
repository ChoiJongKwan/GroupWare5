package team3.groupware5.repository;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Employee;

@Repository
public class EmployeeDAO {

	public boolean FindLogin(String email, String password) throws SQLException {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

		Employee data = (Employee) em.createNamedQuery("Employee.findLoginByEmp").setParameter("email", email).setParameter("password", password).getSingleResult();
			em.persist(data);
			System.out.println(data);

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
	//세션 저장 값 no로 변환
	public int getEmployeeEmail(String email) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println(email);
		
		int id = 0;
		try {
			tx.begin();
			id = (Integer)em.createNamedQuery("Employee.getEmployee").setParameter("email", email).getSingleResult();
	
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return id;
	}

	
}