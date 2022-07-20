package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudent {

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
			
			 String theDateOfBirthStr = "31/12/1998";
	         Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			System.out.println("Creating student object.");
			Student tempStudent = new Student("Paul","wall","paulwall@luv2code.com",theDateOfBirth);
			
			//start the transaction
			session.beginTransaction();
			
			System.out.println("Saving the student");
			//save the student object
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student is saved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
	}

}
