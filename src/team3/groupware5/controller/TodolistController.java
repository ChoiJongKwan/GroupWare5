package team3.groupware5.controller;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.repository.TodolistDAO;
import team3.groupware5.service.TodolistService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Todolist;

@RestController
@RequestMapping("todolist")
@SessionAttributes({ "empno" })
public class TodolistController {

	
	@Autowired
	public TodolistService tdSve;
	@Autowired
	public TodolistDAO tdDao;
	

	
	@Transactional
	@GetMapping(value =  "/allview", produces = "application/json; charset=UTF-8")
	public ModelAndView allview() throws SQLException {
		System.out.println("m1()");
		System.out.println("------------controller----------");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", tdSve.getTodolist());
		mv.setViewName("../todolist/list");
		
		
		return mv;
	}
	
	@GetMapping(value =  "/view", produces = "application/json; charset=UTF-8")
	public String view(Model model) throws SQLException {
		String email =(String) model.getAttribute("email");
		EmployeeDAO dao = new EmployeeDAO();
		int a = dao.getEmployeeEmail(email);
		Employee e = new Employee(a);

		String result	= tdDao.getTodolistOne();
		System.out.println("controller: "+ result);
		return result;
	}
	
	
	@PostMapping(value = "/insert")
	public String insert(Model model,
			@RequestParam("title") String title,
			@RequestParam("importance") String importance,
			@RequestParam("content") String content,
			@RequestParam("date") String date,
			@RequestParam("time") String time) throws SQLException  {
		String email =(String) model.getAttribute("email");
		EmployeeDAO dao = new EmployeeDAO();
		int a = dao.getEmployeeEmail(email);
		System.out.println(a);
		Employee e = new Employee(a);
		System.out.println(e);
		int imp= Integer.parseInt(importance);
		Todolist todolist = new Todolist(title,content,imp,date,time,e);
		tdSve.insert(todolist);
		model.addAttribute("todolist", todolist);
		
		
		System.out.println("insert() -----");
		return "redirect:allview";
	}
	
	@PostMapping(value = "/delete")
	public String delete(Model model,
			@RequestParam("num") int num) throws SQLException  {

		tdSve.delete(num);
				
		System.out.println("delete() -----");
		return "redirect:/allview";
	}
	
	
	
	@ExceptionHandler
	public String exProcess(Exception e) {
		e.printStackTrace();
		return null;
		
	}
}
