package com.luv2code.setterInjection;

import com.luv2code.constructorInjection.FortuneService;
import com.luv2code.springdemo.Coach;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//add private field for adding literal values
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach : Inside setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach : Inside setTeam");
		this.team = team;
	}
	
	//no arg constructor
	public CricketCoach() {
		System.out.println("Cricket Coach : Inside no-arg constructor");
	}

	//setter method which spring will call
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach : Inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
