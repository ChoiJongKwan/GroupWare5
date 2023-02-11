package team3.groupware5.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.service.NoticeService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Notice;

@Controller
@RequestMapping("NoticeServlet")
@SessionAttributes({"notice","email"})
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
		
	@RequestMapping(value = "/noticeinsert", method = RequestMethod.POST)
	public String insert(Model model,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("password") String password) throws SQLException  {
		
		String email =(String) model.getAttribute("email");
		EmployeeDAO dao = new EmployeeDAO();
		int a = dao.getEmployeeEmail(email);
		Employee e = new Employee(a);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());//오늘 날짜로 초기화
		Notice notice = new Notice(title,content,password,now,0,e);
		noticeService.writeNotice(notice);
		model.addAttribute("notice", notice);
		
		
		return "redirect:noticeallview";
	}
	
	@RequestMapping(value="/noticeallview", method = RequestMethod.GET)
	public ModelAndView getNotice() throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("../notice/list");
		
		return mv;
		
	}

	

}
