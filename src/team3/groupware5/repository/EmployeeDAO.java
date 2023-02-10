package team3.groupware5.repositoy;

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
	
//	public boolean findEmployee(String email, String password) throws Exception {
//
//		EntityManager em = DBUtil.getEntityManager();
//		boolean r = false;
//		try {
//
//			Object data = em.createNamedQuery("Employee.findLoginByEmp").setParameter("email", email)
//					.setParameter("password", password).getSingleResult();
//			System.out.println("---- " + data);
//
//			r = true;
//		} finally {
//			em.close();
//		}
//		
//		return r;
//	}
//	
	

}