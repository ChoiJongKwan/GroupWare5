package team3.groupware5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.ReplyDAO;
import team3.groupware5.vo.Reply;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	public ArrayList<Reply> getReplyNo(int boardNo) {
		ArrayList<Reply> list = replyDAO.getReplyNo(boardNo);
		return list;
	}
	
	public boolean writeReply(Reply reply) {
		return replyDAO.writeReply(reply);
	}

}
