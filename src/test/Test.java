package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import team3.groupware5.vo.Approval;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Todolist;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("dbinfo");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Todolist> all = em.createQuery("select t from Todolist t",Todolist.class).getResultList();
//		Todolist e1 = em.find(Todolist.class, 1);		
//		System.out.println(e1);
//		Approval a1 = em.find(Approval.class, 2);
         
//         System.out.println(a1.getEmployeeNo());

		
//		List<Employee> all = em.createQuery("select t from Employee t",Employee.class).getResultList();
		all.forEach(System.out::println);
		tx.commit();
		
		em.close();
		emf.close();
	}

}
