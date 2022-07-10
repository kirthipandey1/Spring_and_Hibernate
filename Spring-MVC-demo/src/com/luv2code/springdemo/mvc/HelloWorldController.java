package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//method to show initial page
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//method to process the form
	@RequestMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
	
	//method to read form data
 	@RequestMapping("/processformVersiontwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		//read the request parameter from HTML form
		String theName = request.getParameter("studentname");
		
		//convert the data to caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! "+theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	} 
	
	//making use of @requestParam annotation here
  	@RequestMapping("/processformVersionthree")
	public String processformVersionthree(@RequestParam("studentname") String theName,Model model) {
		
		//convert the data to caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hey my friend from v3 ! "+theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
}
