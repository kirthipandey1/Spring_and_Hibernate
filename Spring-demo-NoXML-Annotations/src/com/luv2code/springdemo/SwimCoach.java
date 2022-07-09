package com.luv2code.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService thefortuneService) {
		fortuneService=thefortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters everyday";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
