package com.pmo.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Task;
import com.pmo.service.EmployeeService;
import com.pmo.service.TaskService;
import com.pmo.user.service.UserPmo;

@Controller
public class EventController {

	@EJB(mappedName="java:module/pmo/EmployeeService")
	private EmployeeService employeeService;
	
	@EJB(mappedName="java:module/pmo/TaskService")
	private TaskService taskService;
	
	@EJB(mappedName="java:module/pmo/UserDao")
	private UserDao userDao;
	
	@RequestMapping(value="/user/mycalendar", method = RequestMethod.GET)
	public String displayCalendar(ModelMap pModel) {
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Employee employee = userDao.getUser(user.getUsername());
		
		List<Task> tasks = taskService.getTasks(employee);
		
		pModel.addAttribute("user", user);
		pModel.addAttribute("tasks", tasks);

		return "calendar/calendar";
    }
	
	@RequestMapping(value="/user/event/new", method = RequestMethod.POST)
	public @ResponseBody int newEvent(@RequestParam(value="type") final String type,
			@RequestParam(value="reason") final String reason,
			@RequestParam(value="startdate") final String startDate,
			@RequestParam(value="enddate") final String endDate,
			@RequestParam(value="allDay") final String allDay) {

		System.out.println(type + " " + reason + " " + startDate + " " + endDate + " ");
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		int id = -1;
		
		//to do check le type de Event
		
		id = employeeService.createEvent(employeeService.getDetails(user.getUsername()).getId_employee(), 
										 type, 
										 reason, 
										 new Date(Long.parseLong(startDate)), 
										 new Date(Long.parseLong(endDate)),
										 Boolean.parseBoolean(allDay));
		return id;

		//to do faire exception si erreur
	}
	
	@ResponseBody
	@RequestMapping(value="/user/event/events", method = RequestMethod.POST)
	public List<Event> getEvents() {

		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<Event> events = employeeService.getEvents(employeeService.getDetails(user.getUsername()).getId_employee());
		
		return events;
	}
	
	@RequestMapping(value="/user/event/update", method = RequestMethod.POST)
	public @ResponseBody int updateEvent(@RequestParam(value="eventid") final String eventId,
			@RequestParam(value="startdate") final String startDate,
			@RequestParam(value="enddate") final String endDate,
			@RequestParam(value="allDay") final String allDay) {

		System.out.println(startDate + " " + endDate + " ");
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		int id = -1;
		
		id = employeeService.updateEvent(Integer.parseInt(eventId), 
										 new Date(Long.parseLong(startDate)), 
										 new Date(Long.parseLong(endDate)),
										 Boolean.parseBoolean(allDay));
		
		return id;
	}
	
	//delete

}
