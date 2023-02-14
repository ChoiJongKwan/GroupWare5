package team3.groupware5.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.MessageDAO;
import team3.groupware5.vo.Message;

@Service
public class MessageService {

	@Autowired
	private MessageDAO messageDao;
	
	public Message getDetailMessage(Message messageVo) throws SQLException {
		
		return messageDao.getDetailMessage(messageVo);
		
	}
	public boolean sendMessage(Message messageVo) {
		
		return messageDao.sendMessage(messageVo);
	}
	
	public int answerMessage(Message messageVo) {
		
		int result = messageDao.answerMessage(messageVo);
		
		return result;
	}
	
	public boolean deleteMessage(Message messageVo) {
		
		return 	messageDao.deleteMessage(messageVo);
	}
	
	
	public List<Message> getMessage(Message messageVo) {
		
		List<Message> list = messageDao.getMessage(messageVo);
		
		return list;
	}
}
