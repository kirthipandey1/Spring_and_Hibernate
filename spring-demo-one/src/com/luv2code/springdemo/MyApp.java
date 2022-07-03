package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach theCoach = new BaseballCoach();
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
		
		Coach theCoach2 = new TrackCoach();
		
		System.out.println(theCoach2.getDailyWorkout());
		
	//	Note : we are hard coding here the coach as new Baseball and new track coach
		
	}

}
