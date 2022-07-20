package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating student object.");
			Student tempStudent = new Student("Dafy","Duck","dafy@luv2code.com",DateUtils.parseDate("31/12/1999"));
			
			//start the transaction
			session.beginTransaction();
			
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			//save the student object
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//saved student's primary key
			System.out.println("Saved student's primay key : "+tempStudent.getId());
			
			//reading data of student from db
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Student information : "+myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Student is saved and retrieved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			factory.close();
		}
		
	}

}
