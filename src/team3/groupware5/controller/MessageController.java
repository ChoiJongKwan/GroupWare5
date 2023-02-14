package team3.groupware5.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.service.MessageService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Message;


@Controller
@RequestMapping("message")
@SessionAttributes({"employeeNo"})
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(value ="/list")
	public String message(Model model) {
		
		Message messageVo= new Message();
		
		Employee emp = new Employee();
		emp.setEmployeeNo(1);

		messageVo.setEmployeeNo(emp);
		
		List<Message> list = messageService.getMessage( messageVo );
		
		model.addAttribute( "list", list );
		
		
		return "message/list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam(value="no", required=true) int no,	Model model) throws SQLException {
		
		Message messageVo = new Message();
		messageVo.setNo(no);
		Message resVo = messageService.getDetailMessage(messageVo);
		
//		model.addAttribute("employeeNo", resVo.getEmployeeNo());
		model.addAttribute("content", resVo.getContent());
		
		return "message/view";
	}
	
	
	@RequestMapping(value="/deleteMessage", method=RequestMethod.POST)
	public String deleteMessage(@ModelAttribute Message messageVo) {
		
		boolean succeed = messageService.deleteMessage(messageVo);

		return "message/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	public String sendMessage(Model model,
		@RequestParam("content") String content,
		@RequestParam("writedate") String writedate) throws SQLException  {
	
		String email =(String) model.getAttribute("email");
		EmployeeDAO dao = new EmployeeDAO();
		int a = dao.getEmployeeEmail(email);
		Employee e = new Employee(a);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());//오늘 날짜로 초기화
//		Message message = new Message(content, now, e);
//		messageService.sendMessage(message);
//		model.addAttribute("message", message);
		
		
		return "redirect:message/list";
	}
	
//	@ResponseBody
//	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
//	public String sendMessage(@ModelAttribute Message messageVo) {
//		
//		Message msgOne = new Message();
//		boolean succeed = messageService.sendMessage(msgOne);
//		
//		return "message/sendmessage";
//	}
	
	@ResponseBody
	@RequestMapping(value="/answerMessage", method=RequestMethod.POST)
	public String answerMessage(@ModelAttribute Message messageVo) {
		
		int count = messageService.answerMessage(messageVo);
		
//		return JSONResult.success(count);
		return "";
	}
}
