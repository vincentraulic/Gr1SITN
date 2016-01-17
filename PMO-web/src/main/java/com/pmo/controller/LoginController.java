package com.pmo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return new ModelAndView("forward:/user/home");
		}
		
		else {
			
			ModelAndView model = new ModelAndView();
		
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}
	
			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("login");
	
			return model;
		}

	}
	
}
