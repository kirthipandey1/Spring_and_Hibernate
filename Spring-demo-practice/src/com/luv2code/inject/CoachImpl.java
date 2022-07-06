package com.luv2code.inject;

import com.luv2code.ref.FortuneService;

public class CoachImpl implements Coach {
	
	private FortuneService fortuneService;
	
	public CoachImpl(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}

	@Override
	public String[] facility() {
		return fortuneService.getMyFortune();
	}
	
	public String[] getFortune() {
		String[] str = {};
		return str;
	}

}
