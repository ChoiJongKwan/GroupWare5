package team3.groupware5.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import team3.groupware5.util.DBUtil;
import team3.groupware5.vo.Employee;


@Repository
public class SearchEmployeeDAO {
	
	//전체 직원 조회 - 사번,부서,이름,메일,직급 + 탈퇴,수정
	public ArrayList<Employee> getEmployees() throws SQLException{
		
		EntityManager em = DBUtil.getEntityManager();
		List<Employee> allEmp = null;
		
		try {
			
			allEmp = em.createQuery("SELECT E FROM Employee E", Employee.class).getResultList();
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return (ArrayList<Employee>) allEmp;
	}
	
	
	//개별 직원 조회 - 사번(EMPLOYEENO)으로 찾기
	public Employee getEmpOneNo(int employeeNo) throws SQLException {
		
		EntityManager em = DBUtil.getEntityManager();
		Employee empOne = null;
		
		try {
			
			empOne = em.find(Employee.class, employeeNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return empOne;
	}
	
	
	
	//직원 정보 업데이트 - 사원번호로 찾아서 부서, 비번, 직급 수정
	public boolean updateEmp(int employeeNo, String teamName, String password, String positionName) throws SQLException {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Employee employee = null;
		
		try {
			tx.begin();
			employee = (Employee) em.createQuery("UPDATE EMPLOYEE SET teamName=?, password=?, positionName=? WHERE employeeNo=?").setParameter("employeeNo", employeeNo);
			
			if (employee != null) {
				// before update
				System.out.println("update 전 : " + employee);
				employee.setTeamName(teamName);
			}else {
				System.out.println("업데이트 하려는 사람의 정보를 찾지 못하였습니다");
			}
			tx.commit();
			// after update
			System.out.println("update 후 : " + employee);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return false;
	}
	
	
	
	//직원 삭제
	public int deleteEmp(int employeeNo) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			tx.begin();
			Employee empDel = em.createQuery("DELETE FROM Employee WHERE employeeNo=?", Employee.class).getSingleResult();
			
			if (empDel != null) {
				em.remove(empDel);
				System.out.println("----------");
			}else {
				System.out.println("삭제하려는 사원이 없습니다.");
			}
			
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return 0;
		
	}
}
