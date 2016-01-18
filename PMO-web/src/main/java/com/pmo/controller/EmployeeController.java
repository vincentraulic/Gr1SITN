package com.pmo.controller;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmo.service.EmployeeService;

@Controller
public class EmployeeController {

	@EJB(mappedName="java:module/pmo/EmployeeService")
	private EmployeeService employeeService;
	
    @RequestMapping(value="/user/employee", method = RequestMethod.GET)
    public String afficher() {
        
        return "employee";
    }
	
    @RequestMapping(value="/user/newemployee", method = RequestMethod.POST)
    public String supprimer(@RequestParam(value="lastname") final String lastname,
    						@RequestParam(value="firstname") final String firstname,
    						final ModelMap pModel) {
    	

    	Date date = Calendar.getInstance().getTime();

		//employeeService.createEmployee(lastname, firstname, date);
    	
        return "home";
    }
	
	
}
