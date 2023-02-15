package team3.groupware5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.repository.MessageDAO;
import team3.groupware5.service.MessageService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Message;


@Controller
@RequestMapping("message")
@SessionAttributes({"employeeNo"})
public class MessageController {
	
	@Autowired
	public MessageService messageService;
	@Autowired
	public MessageDAO messageDao;
	@Autowired
	public EmployeeDAO emloyeeDao;

	
	@GetMapping(value =  "/allview", produces = "application/json; charset=UTF-8")
	public ModelAndView allview() throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", messageService.getMessage());
		mv.setViewName("../message/list");
		
		return mv;
	}
	
	
	@GetMapping(value =  "/viewmessage/{employeeNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView view(@PathVariable int employeeNo) throws SQLException {	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", messageService.getMessageOne(employeeNo));
		mv.setViewName("../message/list");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/send")
	public void send(Model model,
		@RequestParam("content") String content,
		@RequestParam("writedate") String writedate,
		HttpServletResponse res) throws SQLException, IOException  {
		
		int empno = (int) model.getAttribute("employeeNo");		
		Employee e = new Employee(empno);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());//오늘 날짜로 초기화
		
		Message message = new Message(e, content, now);
		messageService.sendMessage(message);
		model.addAttribute("message", message);
		
		res.sendRedirect("allview");
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam("no") int no, HttpServletResponse res, Model model) throws SQLException, IOException {
		messageService.delete(no);
		res.sendRedirect("viewmessage/" + (int) model.getAttribute("employeeNo"));
	}
	
	
	
	@ExceptionHandler
	public String exceptionHandler(SQLException e) {
		e.printStackTrace();
		return e.getMessage();
   }
}
