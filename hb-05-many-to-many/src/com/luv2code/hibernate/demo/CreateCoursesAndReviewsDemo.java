package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//start the transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How to score million points");
			
			tempCourse.addReview(new Review("Great course ..... loved it!"));
			tempCourse.addReview(new Review("cool course, job done well"));
			tempCourse.addReview(new Review("what a dumb course, you are idiot."));
			
			System.out.println("Saving the course.");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
			factory.close();
		}
		
	}

}
