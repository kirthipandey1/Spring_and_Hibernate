package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			int studentId = 1;
			
			//saved student's primary key
			System.out.println("Saved student's primay key : "+studentId);
			
			//reading data of student from db
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			//delete the student
			System.out.println("Deleting student : "+myStudent);
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Delete student with id 2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Student is updated");
			
		}finally {
			factory.close();
		}
		
	}

}
