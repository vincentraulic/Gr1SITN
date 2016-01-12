package com.pmo.controller;

import javax.ejb.EJB;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pmo.event.type.EventType;
import com.pmo.service.EmployeeService;
import com.pmo.user.service.UserPmo;

@Controller
public class EventController {

	@EJB(mappedName="java:module/EmployeeDaoImpl")
	private EmployeeService employeeService;
	
	@RequestMapping(value="/mycalendar", method = RequestMethod.GET)
    public String afficher() {
        
        return null;
    }
	
	@RequestMapping(value="/event/new", method = RequestMethod.POST)
	public @ResponseBody String newEvent(@RequestParam(value="type") final String type,
			@RequestParam(value="title") final String motif,
			@RequestParam(value="startdate") final String startDate,
			@RequestParam(value="enddate") final String endDate,
			final ModelMap pModel) {

		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(! StringUtils.isEmpty(type) && type.equals(EventType.ABSENCE)){
			
			int id = employeeService.createEvent(employeeService.getDetails(user.getUsername()).getId_employee(), 
													type, motif, startDate, endDate);
			return id + "";
		}
		
		return "error";

	}

}
