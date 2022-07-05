package com.luv2code.Main;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.inject.CoachImpl;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		CoachImpl bean = context.getBean("theCoach",CoachImpl.class);
		
		Random ran = new Random();
		
		int i= ran.nextInt(3);
		
		System.out.println(bean.facility()[i]);
		
		context.close();

	}

}
