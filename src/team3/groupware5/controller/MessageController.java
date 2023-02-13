package team3.groupware5.controller;

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

import team3.groupware5.repository.MessageDAO;
import team3.groupware5.service.MessageService;
import team3.groupware5.vo.Message;


@Controller
@RequestMapping( "message" )
@SessionAttributes({ "message", "employeeNo" })
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(value ="/index")
	public String message(Model model) {
//	@RequestMapping( "")
//	public String message(@AuthUser UserVo authUser, Model model) {
		
		//String nick = (String) session.getAttribute("nick");
		//to setNick(nick);
		
		Message messageVo= new Message();

		messageVo.setEmployeeNo(authUser.getEmployeeNo());
		
		List<Message> list = messageService.getMessage( messageVo );
		
		model.addAttribute( "list", list );
		
		
		return "message/index";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam(value="no", required=true) int no,	Model model) {
		
		Message messageVo = new Message();
		messageVo.setNo(no);
		Message resVo = messageService.getDetailMessage(messageVo);
		
		model.addAttribute("employeeNo", resVo.getEmployeeNo());
		model.addAttribute("content", resVo.getContent());
		
		return "message/view";
	}
	
	
	@RequestMapping(value="/deleteMessage", method=RequestMethod.POST)
	public String deleteMessage(@ModelAttribute Message messageVo) {
		
		int count = messageService.deleteMessage(messageVo);
		
		return "message/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute Message messageVo) {
		
		int count = messageService.sendMessage(messageVo);
		
		return JSONResult.success(count);
	}
	
	@ResponseBody
	@RequestMapping(value="/answerMessage", method=RequestMethod.POST)
	public String answerMessage(@ModelAttribute Message messageVo) {
		
		int count = messageService.answerMessage(messageVo);
		
		return JSONResult.success(count);
	}
}
