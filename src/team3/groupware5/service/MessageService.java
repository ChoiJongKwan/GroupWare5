package team3.groupware5.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.MessageDAO;
import team3.groupware5.vo.Message;

@Service
public class MessageService {

	@Autowired
	public MessageDAO messageDao;
	
	private Message messageVo;
	
	
	public Message getDetailMessage(Message messageVo) throws SQLException {
		
		return messageDao.getDetailMessage(messageVo);
		
	}
	public boolean sendMessage(Message messageVo) {
		
		return messageDao.sendMessage(messageVo);
	}
	
	
	public boolean delete(int no) {
		
		return 	messageDao.deleteMessage(no);
	}
	
	
	public ArrayList<Message> getMessage() throws SQLException {
		
		ArrayList<Message> allMsg = messageDao.getMessageAll();	
		
		return allMsg;
	}

	public ArrayList<Message> getMessageOne(int employeeNo) {
		
		return messageDao.getMessageOne(employeeNo);
	}
}
