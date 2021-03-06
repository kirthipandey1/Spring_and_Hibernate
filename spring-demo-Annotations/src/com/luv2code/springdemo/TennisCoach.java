package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theSillyCoach")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//constructor injection
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
