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
	@Transactional
	public ArrayList<Employee> getEmployees() throws SQLException{
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Employee> allEmp = null;
		
		try {
			tx.begin();
			
			allEmp = em.createQuery("SELECT E FROM Employee E", Employee.class).getResultList();
			
			tx.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return (ArrayList<Employee>) allEmp;
	}
	
	
	//개별 직원 조회 - 사번(EMPLOYEENO)으로 찾기
	public String getEmpOneNo() throws SQLException {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Employee empOne = null;
		
		try {
			
			tx.begin();
			empOne = em.createQuery("SELECT E FROM EMPLOYEE E WHERE EMPLOYEENO=?", Employee.class).getSingleResult();
			
			if(empOne != null) {
				System.out.println(empOne);
			}else {
				System.out.println("검색 요청한 직원은 미존재합니다");
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return empOne.toString();
//		return "사번 : " + empOne.getEmployeeNo()+ "\n" + "부서 : " + empOne.getTeamName() + "\n" + "이름 : " + empOne.getEmployeeName() + "\n" + "메일 : " + empOne.getEmail() + "\n" + "비번 : " + empOne.getPassword()+ "\n" + "직급 : " + empOne.getPositionName();
	}
	
	
	//개별 직원 조회 - 이름(EMPLOYEENAME)으로 찾기
	public String getEmpName() throws SQLException {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Employee empOneName = null;
		
		try {
			
			tx.begin();
			empOneName = em.createQuery("SELECT E FROM EMPLOYEE E WHERE EMPLOYEENAME=?", Employee.class).getSingleResult();
			
			if(empOneName != null) {
				System.out.println(empOneName);
//				System.out.println("사번 : " + empOne.getEmployeeNo()+ "\n" + "부서 : " + empOne.getTeamName() + "\n" + "이름 : " + empOne.getEmployeeName() + "\n" + "메일 : " + empOne.getEmail() + "\n" + "비번 : " + empOne.getPassword()+ "\n" + "직급 : " + empOne.getPositionName());
			}else {
				System.out.println("검색 요청한 직원은 미존재합니다");
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	return empOneName.toString();
	}
	
	
//	//부서 검색 - team 내용이 아무것도 없는데 부서 검색이 의미 있나...? 부서별 회원 모아 보기...??
//	public void searchTeam() {
//		
//		EntityManager em = DBUtil.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		try {
//			tx.begin();
//			Employee employee = em.find(Employee.class, 1L);
//			if(employee != null) {
//				System.out.println("employee ID = " + employee.getEid()+ "\n" + "employee NAME = " + employee.getEname() + "\n" + "employee SALARY = " + employee.getSalary() + "\n" + "employee DESIGNATION = " + employee.getDepartmentid());
//			}else {
//				System.out.println("검색 요청한 직원은 미존재합니다");
//			}
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}
	
	
	//직원 정보 업데이트 - 사원번호로 찾아서 부서, 비번, 직급 수정
//	public boolean updateEmp(int employeeNo, String teamName, String password, String positionName) throws SQLException {
//		
//		EntityManager em = DBUtil.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		Employee employee = null;
//		
//		try {
//			tx.begin();
//			employee = em.createQuery("UPDATE EMPLOYEE SET teamName=?, password=?, positionName=? WHERE employeeNo=?").setParameter("employeeNo", employeeNo);
//			
//			if (employee != null) {
//				// before update
//				System.out.println("update 전 : " + employee);
//				employee.setTeamName(teamName);
//			}else {
//				System.out.println("업데이트 하려는 사람의 정보를 찾지 못하였습니다");
//			}
//			tx.commit();
//			// after update
//			System.out.println("update 후 : " + employee);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//		
//		return false;
//	}
	
	
	
	
	//직원 삭제
	public boolean deleteEmp(String email) {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			tx.begin();
			Employee empDel = em.find(Employee.class, email);
			
			if (empDel != null) {
				em.remove(empDel);
				System.out.println(empDel);
			}else {
				System.out.println("삭제하려는 사원이 없습니다.");
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			em.close();
		}
		
		return false;
	}
}
