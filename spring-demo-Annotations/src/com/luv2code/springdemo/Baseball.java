package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Baseball implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public Baseball() {
		System.out.println("Default constructor pf baseball");
	}

	@Override
	public String getDailyWorkout() {
		return "practice balling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//define init method
	@PostConstruct
	public void doMystartupstuff() {
		System.out.println("In baseball : do my startupstuff method.");
	}
	
	//define destroy method
	@PreDestroy
	public void doMycleanupstuff() {
		System.out.println("In baseball : do my doMycleanupstuff method.");
	}
}
