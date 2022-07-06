package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		//this is explicit name for bean
		Coach theCoach = context.getBean("theSillyCoach",Coach.class);
		
		//this is default bean
		Coach coach = context.getBean("cricketCoach",Coach.class);
		
		//call a method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(coach.getDailyWorkout());
		
		//close the container
		context.close();

	}

}
