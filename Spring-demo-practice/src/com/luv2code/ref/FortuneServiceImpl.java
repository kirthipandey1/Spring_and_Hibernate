package com.luv2code.ref;

public class FortuneServiceImpl implements FortuneService {

	@Override
	public String[] getMyFortune() {
		String[] arr = {"Have a nice day","Its your lucky day","Work hard"};
		return arr;
	}

}
