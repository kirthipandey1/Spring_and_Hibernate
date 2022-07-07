package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create a string of array
	private String[] data = {"study","work hard","learn new stuff"};
	
	//create random generator
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		//pick a random value
		int index = random.nextInt(data.length);
		return data[index];
	}

}
