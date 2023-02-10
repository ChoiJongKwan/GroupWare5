package team3.groupware5.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.groupware5.repository.TodolistDAO;
import team3.groupware5.vo.Todolist;

@Service
public class TodolistService {
	@Autowired
	public TodolistDAO tdDao;
	
	@Transactional
	public ArrayList<Todolist> getTodolist() throws SQLException{
		System.out.println("------------service----------");
		return tdDao.getTodolistAll();
	}
}
