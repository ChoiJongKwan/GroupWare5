package team3.groupware5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	//로그인
	public int getLogin(String email, String password) throws Exception {
		return employeeDao.findLogin(email, password);
	}
	
	//가입
	public boolean getJoin(Employee employee) {

		return employeeDao.JoinEmployee(employee);
	}
	
	//이메일찾기
	public String getEmail(int employeeNo, String password) throws Exception {
		String id = employeeDao.findEmail(employeeNo, password);

		if (id == null) {

			return null;
		} else {
			return id;
		}
	}

	//비번찾기
	public String getPw(String email, String employeeName) throws Exception {
		String pw = employeeDao.findPw(email, employeeName);

		if (pw == null) {
			return null;
		} else {
			return pw;
		}
	}
	//역할 찾기
	public String fineRole(int employeeNo) throws Exception {
	      return employeeDao.findrole(employeeNo);
	   }
	
		//이름 찾기
		public String findName(int employeeNo) throws Exception {
		      return employeeDao.findName(employeeNo);
	
}