package team3.groupware5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.MessageDAO;
import team3.groupware5.vo.Message;

@Service
public class MessageService {

	@Autowired
	private MessageDAO messageDao;
	
	public Message getDetailMessage(Message messageVo) {
		
		return messageDao.getDetailMessage(messageVo);
		
	}
	public int sendMessage(Message messageVo) {
		
		int result = messageDao.sendMessage(messageVo);
		
		return result;
	}
	
	public int answerMessage(Message messageVo) {
		
		int result = messageDao.answerMessage(messageVo);
		
		return result;
	}
	
	public int deleteMessage(Message messageVo) {
		
		int result = messageDao.deleteMessage(messageVo);
		
		return result;
	}
	
	
	public List<Message> getMessage(Message messageVo) {
		
		List<Message> list = messageDao.getMessage(messageVo);
		
		return list;
	}
}
