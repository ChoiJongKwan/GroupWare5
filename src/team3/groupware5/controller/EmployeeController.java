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
			@RequestParam("password") String password) throws Exception {

		boolean validate;
		try {
			validate = employeeservice.getLogin(email, password);
			if (validate != false) {
				sessionData.addAttribute("email", email);
				System.out.println(sessionData);
				return "redirect:/main.jsp";
			}else {
				return "redirect:/index.html";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("id pw invalidate");
		}


	}


//	@PostMapping(value="/logincheck", produces = "text/plain; charset=UTF-8")
//	public String login(@RequestParam("email") String email, 
//						@RequestParam("password") String password) {
//		String resData = email;
//
//		try {
//			
//			employeeservice.getEmployee(email, password);
//
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//			resData = e.getMessage();
//		}
//		return resData;
//
//	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		System.out.println("--------------------------");
		e.printStackTrace();
		return e.getMessage();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sess) {
		System.out.println("로그 아웃....");
		sess.setComplete();
		sess = null;

		return "redirect:/index.html";
	}
	


}
