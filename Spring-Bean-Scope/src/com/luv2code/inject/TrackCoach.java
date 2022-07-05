package com.luv2code.inject;

import com.luv2code.ref.FortuneService;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run everyday 5k";
	}

	@Override
	public String getFortuneService() {
		return fortuneService.getFortuneService();
	}

}
