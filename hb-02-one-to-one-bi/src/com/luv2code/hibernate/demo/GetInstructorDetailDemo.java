package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
		
			
			//start the transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 2;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail value is : "+tempInstructorDetail);
			
			//print instructor
			System.out.println("the associated instructor is : "+tempInstructorDetail.getInstructor());
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("saved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			//in order to handle connection leak
			session.close();
			
			factory.close();
		}
		
	}

}
