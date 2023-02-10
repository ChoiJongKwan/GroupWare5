package team3.groupware5.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.Empty;

import model.domain.CustomerVo;
import team3.groupware5.repository.TodolistDAO;
import team3.groupware5.service.TodolistService;
import team3.groupware5.vo.Todolist;

@RestController
public class TodolistController {
	static  ArrayList<CustomerVo> all = new ArrayList<>();
	public TodolistController() {
		all.add(new CustomerVo("user01", "재석"));
		all.add(new CustomerVo("user02", "연아"));
		all.add(new CustomerVo("user03", "미주"));
		System.out.println("생성자");
	}
	
	@Autowired
	public TodolistService tdSve;
	@Autowired
	public TodolistDAO tdDao;
	

	
	@Transactional
	@GetMapping(value =  "step01", produces = "application/json; charset=UTF-8")
	public ArrayList<Todolist> m1() throws SQLException {
		System.out.println("m1()");
		System.out.println("------------controller----------");

		return tdSve.getTodolist();
	}
	
	@GetMapping(value =  "step02", produces = "application/json; charset=UTF-8")
	public String m2() throws SQLException {
		System.out.println("m2()");
		System.out.println("------------controller----------");

		String result	= tdDao.getTodolistOne();
		System.out.println("controller: "+ result);
		return result;
	}
	
	@GetMapping("step03")
	public ArrayList<CustomerVo> m3() {
		System.out.println("m3()");
		
		return all; 
	}
	
	@ExceptionHandler
	public String exProcess(Exception e) {
		e.printStackTrace();
		return null;
		
	}
}
