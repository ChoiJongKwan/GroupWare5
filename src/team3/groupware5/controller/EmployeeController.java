package team3.groupware5.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import team3.groupware5.service.EmployeeService;
import team3.groupware5.vo.Employee;

@Controller
@RequestMapping("company")
@SessionAttributes({ "emp", "email" })
public class EmployeeController extends HttpServlet {

	@Autowired
	private EmployeeService employeeservice;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model sessionData, @RequestParam("email") String email,
			@RequestParam("password") String password) throws SQLException {

		boolean validate = employeeservice.getEmployee(email, password);

		if (validate == true) {
			sessionData.addAttribute("email", email);
			System.out.println(sessionData);
		
			return "redirect:/main.jsp";
		} else {
			return "redirect:/index.html";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sess) {
		System.out.println("로그 아웃....");
		sess.setComplete();
		sess = null;

		return "redirect:/index.html";
	}
	


}
