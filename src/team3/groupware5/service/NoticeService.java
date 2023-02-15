package team3.groupware5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.NoticeDAO;
import team3.groupware5.vo.Notice;
@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public boolean writeNotice(Notice notice) {
		
		return noticeDAO.writeNotice(notice);
	}
	
	public ArrayList<Notice> getAllNotices() {
		ArrayList<Notice> list = noticeDAO.getAllNotices();
		return list;
	}
	
	public Notice getNoticeNo(int no) {
		return noticeDAO.getNoticeNo(no);
	}
	
	public boolean updateNotice(Notice notice) {
		return noticeDAO.updateNotice(notice);
	}
	
	public boolean deleteNotice(int boardno) {
		return noticeDAO.deleteNotice(boardno);
	}
}
