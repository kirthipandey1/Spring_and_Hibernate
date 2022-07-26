package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//start the transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How to score million points");
			
			System.out.println("\n Saving the course");
			session.save(tempCourse);
			System.out.println("Course saved : "+tempCourse);
			
			Student student1 = new Student("John","Doe","John@luv2code.com");
			Student student2 = new Student("Mary","Public","Mary@luv2code.com");
			
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			System.out.println("Saving student");
			
			session.save(student1);
			session.save(student2);
			
			System.out.println("students saved : "+tempCourse.getStudent());
			
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
