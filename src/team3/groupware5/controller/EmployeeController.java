package team3.groupware5.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.service.EmployeeService;
import team3.groupware5.vo.Employee;

@Controller
@RequestMapping("company")
@SessionAttributes({ "emp","employeeNo", "employeeName"})
public class EmployeeController extends HttpServlet {

	@Autowired
	private EmployeeService employeeService;

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model sessionData, @RequestParam("email") String email,
			@RequestParam("password") String password
			
			
			) throws Exception {

		int employeeNo = 0;
		String url = "redirect:../index.html";
		try {
			employeeNo = employeeService.getLogin(email, password);
			if (employeeNo != 0) {
				sessionData.addAttribute("employeeNo", employeeNo);
				sessionData.addAttribute("employeeName", employeeService.findName(employeeNo));
				
				System.out.println(sessionData);
				url = "redirect:/main.jsp";
			} else {
				System.out.println("----++========");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("id pw invalidate");
		}
		
		return url;

	}


	// 사원등록
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String insert(Model sessionData, Employee emp) throws SQLException {
		System.out.println("insert()---" + emp);
		employeeService.getJoin(emp);
		sessionData.addAttribute("emp", emp);
		return "forward:../employee/joininfo.jsp";
	}

	
	//아이디찾기
	@RequestMapping(value = "/findEmail", method = RequestMethod.POST)
	   public ModelAndView findEmail(@RequestParam("employeeNo") int employeeNo,
	                        @RequestParam("password") String password) throws Exception {
	      ModelAndView mv = new ModelAndView();
	      
	      String data = null; 
	      data = employeeService.getEmail(employeeNo, password);
	      mv.addObject("data", data);
	      mv.setViewName("../employee/findEmailSucecess");
	      
	      return mv;
	   }
	
	// 비밀번호찾기
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	   public ModelAndView findPw(@RequestParam("email") String email,
	                        @RequestParam("employeeName") String employeeName) throws Exception {
	      ModelAndView mv = new ModelAndView();
	      
	      String data = null; 
	      data = employeeService.getPw(email, employeeName);
	      mv.addObject("data", data);
	      mv.setViewName("../employee/findPwSucecess");
	      
	      return mv;
	   }
	
	


	// 예외
	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		System.out.println("--------------------------");
		e.printStackTrace();
		return e.getMessage();
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sess) {
		System.out.println("로그 아웃....");
		sess.setComplete();
		sess = null;

		return "redirect:/index.html";
	}

}
