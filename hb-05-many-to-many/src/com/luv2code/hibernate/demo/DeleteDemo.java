package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			//get instructor by primary key
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor : "+tempInstructor);
			
			//delete the instructor
			if(tempInstructor!=null) {
				System.out.println("Deleting instructor : "+tempInstructor);
				
				//it will also delete instructorDetail becuase of cascadetype.all
				session.delete(tempInstructor);
			}
	
			
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
