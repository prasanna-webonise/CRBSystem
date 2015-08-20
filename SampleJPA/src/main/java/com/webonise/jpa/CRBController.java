package com.webonise.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CRBController {

	
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcome");

		model.addObject("welcomeMessage",
				"Welcome to Conference Room Booking System");
		
		return model;
	}
}
