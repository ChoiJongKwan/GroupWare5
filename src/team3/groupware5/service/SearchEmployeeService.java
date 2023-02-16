package team3.groupware5.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.SearchEmployeeDAO;
import team3.groupware5.vo.Employee;

@Service
public class SearchEmployeeService {
	
	@Autowired
	public SearchEmployeeDAO dao;
	
	private Employee vo;
	
	
	//전직원
	public ArrayList<Employee> getEmployees() throws SQLException{
		ArrayList<Employee> all = dao.getEmployees();
		return all;
	}
	
	
	//삭제
	public boolean deleteEmp(int employeeNo) {
		return dao.deleteEmp(employeeNo);
	}
	
	
	//update
	public boolean updateEmp(int employeeNo, String teamName, String password, String positionName) throws SQLException {
		return dao.updateEmp(employeeNo, teamName, password, positionName);
	}

}
