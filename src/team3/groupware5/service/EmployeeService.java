package team3.groupware5.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeedao;

<<<<<<< Updated upstream
	public boolean getLogin(String email, String password) throws Exception {
		return employeedao.FindLogin(email, password);
	}
=======
	
	public boolean getLogin(String email,String password) throws Exception {
		return employeedao.FindLogin(email, password);
	}

	
	
	
	
	
//	public boolean getEmployee(String email, String password) throws Exception {
//		try {
//			employeedao.findEmployee(email, password);
//			System.out.println("080808");
//			
//		}catch(Exception e) {
//			System.out.println("++++++++++++++++++++++++++++++++");
//			e.printStackTrace();
//			throw new Exception("id pw invalidate입니다");
//		}
//		System.out.println("000000----------------------------");
//		return true;
//	}
>>>>>>> Stashed changes

}