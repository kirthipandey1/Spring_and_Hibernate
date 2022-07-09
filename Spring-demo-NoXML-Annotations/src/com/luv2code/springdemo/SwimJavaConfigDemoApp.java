package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		
		//name swimCoach is from config file
		//Coach theCoach = context.getBean("swimCoach",Coach.class);
		
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//calling the property value 
		
		System.out.println(theCoach.getEmail()+"     "+theCoach.getTeam());
		
		context.close();
		
	}

}
