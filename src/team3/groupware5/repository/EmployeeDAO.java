package team3.groupware5.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Employee;

@Repository
public class EmployeeDAO {

	// 로그인
	public int findLogin(String email, String password) throws SQLException {

		EntityManager em = DBUtil.getEntityManager();

		try {

			Employee data = (Employee) em.createNamedQuery("Employee.findLoginByEmp").setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			System.out.println(data);
			return data.getEmployeeNo();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			em.close();

		}
		return 0;
	}

	// 회원가입
	public boolean JoinEmployee(Employee employee) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			System.out.println(employee);
			em.persist(employee);
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

	//아이디찾기
	public String findEmail(int employeeNo, String password) throws SQLException {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		String data = null;
		try {

			tx.begin();

			data = (String) em.createNamedQuery("Employee.findEmail").setParameter("employeeNo", employeeNo)
					.setParameter("password", password).getSingleResult();

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			em.close();

		}
		return data;
	}
	//비밀번호찾기
	public String findPw(String email, String employeeName) throws SQLException {

		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		String data = null;
		try {

			tx.begin();

			data = (String) em.createNamedQuery("Employee.findPw").setParameter("email", email)
					.setParameter("employeeName", employeeName).getSingleResult();

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			em.close();

		}
		return data;
	}
	
	//역할 찾기
	public String findrole(int employeeNo) throws SQLException {

	      EntityManager em = DBUtil.getEntityManager();
	      String role = null;

	      try {

	    	  role = (String) em.createNamedQuery("Employee.getEmployeeRole").setParameter("employeeNo", employeeNo).getSingleResult();

	      } catch (Exception e) {
	         e.printStackTrace();

	      } finally {
	         em.close();

	      }
	      return role;
	   }


//이름 찾기
		public String findName(int employeeNo) throws SQLException {

		      EntityManager em = DBUtil.getEntityManager();
		      String name = null;

		      try {

		    	  name = (String) em.createNamedQuery("Employee.getEmployeeName").setParameter("employeeNo", employeeNo).getSingleResult();

		      } catch (Exception e) {
		         e.printStackTrace();

		      } finally {
		         em.close();

		      }
		      return name;
		   }


}