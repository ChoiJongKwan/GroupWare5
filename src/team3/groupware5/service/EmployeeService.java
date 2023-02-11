package team3.groupware5.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeedao;

	public boolean getLogin(String email, String password) throws Exception {
		return employeedao.FindLogin(email, password);
	}

}