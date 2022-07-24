package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazy_FetchJoin_Demo {

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
		
			//start the transaction
			session.beginTransaction();
			
			//get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
													+"JOIN FETCH i.courses "
													+"where i.id=:theInstructorId"
												,Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute the query
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code :  Instructor: " + tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\nThe session is closed!!!!\n");
			
			//option2 : Loading data using HQL

			// get courses for the instructor
			System.out.println("luv2code : Courses: " + tempInstructor.getCourses());
			
			
			System.out.println("saved.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
			factory.close();
		}
		
	}

}
