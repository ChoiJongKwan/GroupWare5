package test;


import model.ActivistDAO;
import model.ProbonoDAO;
import model.ProbonoProjectDAO;
import probono.model.entity.Activist;
import probono.model.entity.Probono;
import probono.model.entity.ProbonoProject;

public class TestData {
	
	public static boolean addTestData() {
		
		try {
			
			
			ActivistDAO.addActivist(new Activist("aaa12","유재석","1234","디자인과"));
			ActivistDAO.addActivist(new Activist("aaa34","김연아","1234","체육과학과"));
			ActivistDAO.addActivist(new Activist("aaa35","오은영","1234","심리학과"));
			
			ProbonoDAO.addProbono(new Probono("가","슈바이처 프로젝트","의료, 보건, 건강과 관련된 분야 지원"));
			ProbonoDAO.addProbono(new Probono("나","오드리햅번 프로젝트","문화, 예술 관련 분야 지원"));
			ProbonoDAO.addProbono(new Probono("다","키다리아저씨 프로젝트","멘토링, 상담, 교육, 결연 분야 지원"));
			
			
			Activist a1 = new Activist("aaa12");
			Activist a2 = new Activist("aaa35");
			Activist a3 = new Activist("aaa34");
			
			
			Probono p1 = new Probono("나");
			Probono p2 = new Probono("다");
			Probono p3 = new Probono("가");
			
			ProbonoProjectDAO.addProbonoProject(new ProbonoProject("예술가와의 만남","예술가와 귀여운 고양이 그리기",p1,a1));
			ProbonoProjectDAO.addProbonoProject(new ProbonoProject("독거 노인 식사 제공","OO구의 독거노인 분들께 반찬 배달",p2,a1));
			ProbonoProjectDAO.addProbonoProject(new ProbonoProject("청소년 상담센터","청소년들이 쉽게 접근할 수 있도록 부스 운영",p2,a2));
			ProbonoProjectDAO.addProbonoProject(new ProbonoProject("청소년 재활","청소년들이 쉽게 접근할 수 있도록 부스 운영",p3,a3));
			
			
			return true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
		}
	
		return false;
	}

}
