package com.luv2code.springdemo.mvc.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model themodel) {
		
		//create student object
		Student thestudent = new Student();
		
		//add student object as model attribute
		themodel.addAttribute("student",thestudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student thestudent) {
		
		//log input data
		System.out.println(thestudent.getFirstName()+"  "+thestudent.getLastName());
		
		return "student-confirmation";
	}
	
}
