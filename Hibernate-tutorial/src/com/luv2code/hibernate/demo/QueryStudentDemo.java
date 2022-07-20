package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().
								configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//start the transaction
			session.beginTransaction();
			
			//query students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayMethods(students);
			
			//query student to find all the students whose last name is doe
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			System.out.println("Students whose lastname is doe : ");
			displayMethods(students);
			
			//query student with lastname="doe" or firstname="daffy"
			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Dafy'").getResultList();
			System.out.println("Students whose lastname is doe or firstname is daffy : ");
			displayMethods(students);
			
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
		
			System.out.println("The students having email as gmail.com");
			displayMethods(students);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}finally {
			factory.close();
		}
		
	}

	private static void displayMethods(List<Student> students) {
		//display students
		for(Student tempStudent:students) {
			System.out.println(tempStudent);
		}
	}

}
