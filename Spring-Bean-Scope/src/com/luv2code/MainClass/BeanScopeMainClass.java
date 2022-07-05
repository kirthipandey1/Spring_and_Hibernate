package com.luv2code.MainClass;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.inject.Coach;

public class BeanScopeMainClass {

	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		//check if they are same bean
		boolean result = (theCoach==alphaCoach);
		
		System.out.println("Result : "+result);
		
		System.out.println("Memory location of theCoach : "+theCoach);
		
		System.out.println("Memory location of alphaCoach : "+alphaCoach);
		
		//close the context
		context.close();
		
	}

}
