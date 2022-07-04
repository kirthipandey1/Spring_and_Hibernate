package com.luv2code.springdemo;

import com.luv2code.constructorInjection.FortuneService;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public TrackCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it : "+fortuneService.getFortune();
	}

}
