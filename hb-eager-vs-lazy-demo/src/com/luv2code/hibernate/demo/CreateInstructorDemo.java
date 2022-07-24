package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a objects
		
			Instructor tempInstructor = new Instructor("Susan","public","susan@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","Video Games!!!");
			
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
			
			session.close();
			factory.close();
		}
		
	}

}
