package com.luv2code.inject;

import org.springframework.beans.factory.DisposableBean;

import com.luv2code.ref.FortuneService;

public class TrackCoach implements Coach, DisposableBean {
	
	private FortuneService fortuneService;

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String[] facility() {
		String[] str = {"track value","no track"};
		return str;
	}
	
	public void initialize() {
		System.out.println("Before the bean gets initialized");
	}
	
	public void endingIt() {
		System.out.println("Once the bean is all done");
	}
	
	@Override
	public String[] getFortune() {
		return fortuneService.getMyFortune();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Once the bean is all done");
		
	}

}
