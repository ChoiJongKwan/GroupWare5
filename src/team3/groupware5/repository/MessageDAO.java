package team3.groupware5.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team3.groupware5.vo.Message;


@Repository
public class MessageDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public Message getDetailMessage(Message messageVo ) {
		
		return sqlSession.selectOne("message.getDetailMessage", messageVo);
	}
	
	
	public int sendMessage(Message messageVo ) {
		
		int count = sqlSession.insert("message.sendMessage", messageVo);
		
		return count;
	}
	
	
	public int answerMessage(Message messageVo ) {
		
		int count = sqlSession.insert("message.answerMessage", messageVo);
		
		return count;
	}
	
	
	public int deleteMessage(Message messageVo ) {
		
		int count = sqlSession.delete("message.deleteMessage", messageVo);
		
		return count;
	}
	
	
	public List<Message> getMessage(Message messageVo) {
		
		return sqlSession.selectList("message.getMessage", messageVo);
	}
}
