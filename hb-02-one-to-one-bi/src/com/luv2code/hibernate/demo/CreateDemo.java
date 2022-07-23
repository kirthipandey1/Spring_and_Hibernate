package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a objects
		//	Instructor tempInstructor = new Instructor("chard","daby","daby@luv2code.com");
			
		//	InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com/youtube","Luv 2 Code!!!");
			
			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","Guitar!!!");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start the transaction
			session.beginTransaction();
			
			//save the objects
			//because of Cascadetype.all so it saves all associated objects
			System.out.println("Instructor saved : "+tempInstructor);
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("saved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
	}

}
