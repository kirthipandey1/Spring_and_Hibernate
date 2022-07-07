package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//default constructor
	public CricketCoach() {
		System.out.println("Inside default constructor : CricketCoach");
	}
	
	//define a setter method for  -- setter injection
/*	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method : CricketCoach");
		this.fortuneService=fortuneService;
	} */
	
	//any method could be autowired method -- method injection
		@Autowired
		@Qualifier("happyFortuneService")
		public void doSomeCrazystuff(FortuneService fortuneService) {
			System.out.println("Inside doSomeCrazystuff method : CricketCoach");
			this.fortuneService=fortuneService;
		}
	
	@Override
	public String getDailyWorkout() {
		return "practice batting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


}
