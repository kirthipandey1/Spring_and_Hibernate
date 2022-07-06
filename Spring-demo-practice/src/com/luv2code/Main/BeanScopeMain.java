package com.luv2code.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.inject.TrackCoach;

public class BeanScopeMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("beanScope-LifeCycle-applicationContext.xml");
		
		TrackCoach bean = context.getBean("theCoach",TrackCoach.class);
		
		TrackCoach beanTwo = context.getBean("theCoach",TrackCoach.class);
		
		System.out.println(bean.facility()[0]);
		
		System.out.println(beanTwo.facility()[1]);
		
		System.out.println(bean.getFortune());
		
		System.out.println(bean.getFortuneService());
		
		context.close();

	}

}
