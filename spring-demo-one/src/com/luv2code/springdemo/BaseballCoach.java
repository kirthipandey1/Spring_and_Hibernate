package com.luv2code.springdemo;

import com.luv2code.constructorInjection.FortuneService;

public class BaseballCoach implements Coach {
	
	//define private field for dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	public BaseballCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "spend 30 min in practice";
	}

	@Override
	public String getDailyFortune() {
		//use my fortune service to get fortune
		return fortuneService.getFortune();
	}
}
