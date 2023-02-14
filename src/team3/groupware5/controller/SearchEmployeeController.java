package team3.groupware5.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.repository.SearchEmployeeDAO;

@Controller
@RequestMapping("/search/SearchServlet")
@SessionAttributes({ "emp", "email" })
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
	
	
	//update - 사원번호로 찾아서 부서, 비번, 직급 수정
//	@RequestMapping(value = "/update", method=RequestMethod.POST)
//	public String update(@RequestParam("teamName") String teamName, 
//					     @RequestParam("password") String password,
//					     @RequestParam("positionName") String positionName,
//					     @ModelAttribute("evo") Employee evo) throws SQLException{
//		System.out.println("update() ---- " + evo);
//		
//		evo.setTeamName(teamName);
//		evo.setPassword(password);
//		evo.setPositionName(positionName);
//			
//		dao.updateEmp(employeeNo, teamName, password, positionName);
//				
//		return "forward:/updateSuccess.jsp";
//	}
	
	
	//delete
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String delete(Model model, @RequestParam("email") String email) throws SQLException {
		
		dao.deleteEmp(email);
		return "redirect:allView";   //url로 allView에 매핑된 controller의 메소드 
	}
	
	
	//searchEmp
	
	//얘외처리

}
