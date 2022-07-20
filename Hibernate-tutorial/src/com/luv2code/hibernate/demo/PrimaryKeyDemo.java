package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create 3 student objects
			
			System.out.println("Creating 3 student objects.");
			Student tempStudent1 = new Student("John","Doe","john@luv2code.com",DateUtils.parseDate("31/12/1975"));
			Student tempStudent2 = new Student("Mary","public","mary@luv2code.com",DateUtils.parseDate("31/12/1944"));
			Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com",DateUtils.parseDate("31/12/1923"));
			
			//start the transaction
			session.beginTransaction();
			
			System.out.println("Saving the students");
			//save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student is saved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			factory.close();
		}

	}

}
