package com.luv2code.constructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.Coach;

public class SpringHelloApp1 {

	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container(applicatinContext.xml)
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call for new method
		System.out.println(theCoach.getDailyFortune());
		
		//close the application context
		context.close();
		
	}

}
