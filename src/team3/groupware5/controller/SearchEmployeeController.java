package team3.groupware5.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.repository.SearchEmployeeDAO;
import team3.groupware5.vo.Employee;

@Controller
@RequestMapping("/search/SearchServlet")
@SessionAttributes({ "emp", "email","employeeNo" })
public class SearchEmployeeController {
	
	@Autowired
	private SearchEmployeeDAO dao;
	
	
	//전체 직원 검색
	@RequestMapping(value = "/allView", method = RequestMethod.GET)
	public ModelAndView getEmployee() throws SQLException {
		
		ModelAndView mv = new ModelAndView();
			
		mv.addObject("allData", dao.getEmployees());
		mv.setViewName("/list");
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "/updateview", method=RequestMethod.GET)
	public ModelAndView updateView(@RequestParam("employeeNo") int employeeNo) throws SQLException{
			
		ModelAndView mv = new ModelAndView();		
		mv.addObject("evo", dao.getEmpOneNo(employeeNo));
		mv.setViewName("/update");
		
		return mv;
	}
	
	
	//update - 사원번호로 찾아서 부서, 비번, 직급 수정
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(@RequestParam("teamName") String teamName, 
					     @RequestParam("password") String password,
					     @RequestParam("positionName") String positionName,
					     @RequestParam("employeeNo") int employeeNo,
					     @ModelAttribute("evo") Employee evo) throws SQLException{
		System.out.println("update() ---- " + evo);
		
		evo.setTeamName(teamName);
		evo.setPassword(password);
		evo.setPositionName(positionName);
			
		dao.updateEmp(employeeNo, teamName, password, positionName);
				
		return "updateSuccess.jsp";
	}
	
	
	
	//delete
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String delete(Model model, @RequestParam("employeeNo") int employeeNo) throws SQLException {
		dao.deleteEmp(employeeNo);
		return "redirect:allView";   //url로 allView에 매핑된 controller의 메소드 
	}
	
	
	//searchEmp
//	@RequestMapping(value = "/view", method = RequestMethod.GET)
//	public int view(Model model) throws SQLException {
//		int employeeNo =(int) model.getAttribute("employeeNo");
//		Employee e = new Employee(a);
//
//		int result	= dao.getEmployeeEmail(employeeNo);
//		System.out.println("controller: "+ result);
//		return result;
//	}
	
	
	//예외처리
	@ExceptionHandler
	public String exProcess(Exception e) {
		e.printStackTrace();
		return null;
		
	}

}
