package com.luv2code.practice1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeMain1 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		Movie movie = context.getBean("movieGenre",Movie.class);
		
		System.out.println(movie.getGerne());
		
		context.close();

	}

}
