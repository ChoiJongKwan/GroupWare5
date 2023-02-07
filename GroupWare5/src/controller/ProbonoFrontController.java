package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import model.ActivistDAO;
import model.ProbonoDAO;
import model.ProbonoProjectDAO;
import probono.model.entity.Activist;
import probono.model.entity.Probono;
import probono.model.entity.ProbonoProject;
import test.TestData;

@Controller
@RequestMapping("probono")
@SessionAttributes({"activist"})
public class ProbonoFrontController extends HttpServlet {
	
	@Autowired
	public ActivistDAO activistDao;
	
	@RequestMapping(value="/activistall", method = RequestMethod.GET)
	public ModelAndView activistAll() throws SQLException{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("allData", activistDao.getAllActivists());
		mv.setViewName("activistList");
		return mv;
	}
	@RequestMapping(value = "/activistinsert", method=RequestMethod.POST)
	public String insert(Model sessionData,Activist activist) throws SQLException{
		System.out.println("insert "+ sessionData);
		activistDao.addActivist(activist);
		return "forward:/activistDetail.jsp";
	}
	
	@RequestMapping(value = "/activistdelete", method=RequestMethod.POST)
	public String delete(@RequestParam("id") String deleteId) throws SQLException {
		activistDao.deleteActivist(deleteId);
		return "redirect:activistall";
	}
	
	@RequestMapping(value = "/activistupdate", method=RequestMethod.GET)
	public String update( @RequestParam("id") String id,
					     @RequestParam("major") String major,
					     @ModelAttribute("activist") Activist activist) throws SQLException{
		System.out.println("update() ---- " + activist);
		
		activist.setId(id);
		activist.setMajor(major);
		
		activistDao.updateActivist(id,major);
		
		return "forward:/update.jsp";
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// command pattern
		String command = request.getParameter("command");

		try {

			if (command.equals("probonoProjectAll")) {// 모든 probono project 정보 검색
				probonoProjectAll(request, response);
			} /*
				 * else if (command.equals("activistAll")) {// 모든 재능 기부자 검색 activistAll(request,
				 * response); }
				 */ else if (command.equals("activist")) {// 특정 재능 기부자 정보 검색
				activist(request, response);
			} /*
				 * else if (command.equals("activistInsert")) {// 재능 기부자 추가 등록
				 * activistInsert(request, response); }
				 */ /*
					 * else if (command.equals("activistUpdateReq")) {// 재능 기부자 정보 수정요청
					 * activistUpdateReq(request, response); } else if
					 * (command.equals("activistUpdate")) {// 재능 기부자 정보 수정 activistUpdate(request,
					 * response); }
					 *//* else if (command.equals("activistDelete")) {// 재능 기부자 탈퇴[삭제]
				activistDelete(request, response);
			}*/ else if (command.equals("probonoInsert")) {//probono 추가
				probonoInsert(request, response);
			}  else if (command.equals("probonoProjectInsert")) {//probonoProject추가
				probonoProjectInsert(request, response);
			} else if (command.equals("addTestData")) {//테스트 데이터 추가
				addTestData(request, response);
			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	// 모두 ProbonoProject 검색 메소드
	public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("probonoProjectAll", ProbonoProjectDAO.getAllProbonoProjects());
			url = "probonoProjectList.jsp";
		} catch (SQLException s) {
			request.setAttribute("errorMsg", "죄송합니다. 잠시후 재 실행해주세요");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 모든 재능 기부자 검색 - 검색된 데이터 출력 화면[activistList.jsp]
//	public void activistAll(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			request.setAttribute("activistAll", ActivistDAO.getAllActivists());
//			url = "activistList.jsp";
//		} catch (Exception s) {
//			s.printStackTrace();
//			request.setAttribute("errorMsg", s.getMessage());
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}

	// 재능 기부자 검색
	public void activist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", ActivistDAO.getActivist(request.getParameter("activistId")));
			url = "activistDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 재능 기부자 가입 메소드
//	protected void activistInsert(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String url = "showError.jsp";
//
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String pw = request.getParameter("pw");
//		String major = request.getParameter("major");
//
//		Activist activist = new Activist(id, name, pw, major);
//		try {
//			boolean result = ActivistDAO.addActivist(activist);
//			if (result) {
//				request.setAttribute("activist", activist);
//				request.setAttribute("successMsg", "가입 완료");
//				url = "activistDetail.jsp";
//			} else {
//				request.setAttribute("errorMsg", "다시 시도하세요");
//			}
//		} catch (Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}

	// 재능 기부자 수정 요구
//	public void activistUpdateReq(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			request.setAttribute("activist", ActivistDAO.getActivist(request.getParameter("activistId")));
//			url = "activistUpdate.jsp";
//		} catch (Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//			s.printStackTrace();
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}
//
//	// 재능 기부자 수정 - 상세정보 확인 jsp[activistDetail.jsp]
//	public void activistUpdate(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			String activistId = request.getParameter("activistId");
//			String major = request.getParameter("major");
//			ActivistDAO.updateActivist(activistId, major);
//			request.setAttribute("activist", ActivistDAO.getActivist(request.getParameter("activistId")));
//			url = "activistDetail.jsp";
//		} catch (Exception s) {
//			request.setAttribute("errorMsg", s.getMessage());
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//	}

//	//재능 기부자 삭제
	public void activistDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String activistId = request.getParameter("activistId");
			if (ActivistDAO.deleteActivist(activistId)) {
				request.setAttribute("activistAll", ActivistDAO.getAllActivists());
				url = "activistList.jsp";
			} else {
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", "진행중인 Probono Project가 있습니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//Probono 추가
	protected void probonoInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String probonoId = request.getParameter("probonoId");
		String probonoName = request.getParameter("probonoName");
		String probonoPurpose = request.getParameter("probonoPurpose");

		Probono probono = new Probono(probonoId, probonoName, probonoPurpose);
		try {
			boolean result = ProbonoDAO.addProbono(probono);
			if (result) {
				request.setAttribute("Probono", probono);
				request.setAttribute("successMsg", "가입 완료");
				url = "probonoDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//ProbonoProject 추가
	protected void probonoProjectInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		
		String probonoProjectName = request.getParameter("probonoProjectName");
		String projectContent = request.getParameter("projectContent");
		String probonoId = request.getParameter("probonoId");
		String ActivistId = request.getParameter("ActivistId");

		Activist a1 = new Activist(ActivistId);
		Probono p1 = new Probono(probonoId);

		ProbonoProject probonoPj = new ProbonoProject(probonoProjectName, projectContent, p1, a1);
		try {
			boolean result = ProbonoProjectDAO.addProbonoProject(probonoPj);
			if (result) {
				request.setAttribute("Probonoproject", probonoPj);
				request.setAttribute("successMsg", "가입 완료");
				url = "probonoProjectDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//테스트 데이터 추가
	private void addTestData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "showError.jsp";

		try {
			
			boolean result = TestData.addTestData();
			if (result) {
				request.setAttribute("successMsg", "가입 완료");
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
