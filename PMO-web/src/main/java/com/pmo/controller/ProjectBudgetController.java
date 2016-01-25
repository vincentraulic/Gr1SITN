package com.pmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectBudgetController {
	@RequestMapping(value = "/user/projectbudget", method = RequestMethod.GET)
	public ModelAndView displayHome(ModelMap pModel) {
		ModelAndView m = new ModelAndView();
		m.setViewName("pages/projectbudget");
		return m;
	}
}

