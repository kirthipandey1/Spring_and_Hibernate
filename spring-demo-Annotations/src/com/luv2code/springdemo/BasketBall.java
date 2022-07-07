package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketBall implements Coach {
	
	//field injection
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "practice running everyday";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
