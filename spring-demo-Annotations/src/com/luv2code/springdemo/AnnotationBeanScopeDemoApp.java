package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//read the  bean from spring container
		Coach theCoach = context.getBean("cricketCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("cricketCoach",Coach.class);
		
		boolean result = (theCoach==alphaCoach);
		
		System.out.println(result);
		
		//if no annotation is there for scope then its singleton
		
		System.out.println(theCoach+"   ----difference----   "+alphaCoach);
		
		//close the context file
		context.close();
		
	}

}
