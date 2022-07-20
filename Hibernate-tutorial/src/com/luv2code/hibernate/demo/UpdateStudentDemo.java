package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			System.out.println("Updating Student : ");
			
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating Email for Paul");
			session.createQuery("update Student set email='foo@gmail.com' where firstName='Paul'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Student is updated");
			
		}finally {
			factory.close();
		}
		
	}

}
