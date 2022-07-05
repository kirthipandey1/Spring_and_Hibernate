package com.luv2code.MainClass;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.inject.Coach;

public class BeanLifeCycleMainClass {

	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();
		
	}

}
