package com.pmo.controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmo.dao.EventDao;
import com.pmo.dao.UserDao;
import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Task;
import com.pmo.service.EmployeeService;
import com.pmo.service.TaskService;
import com.pmo.user.service.UserPmo;

@Controller
public class HomeController {

	@EJB(mappedName="java:module/pmo/TaskService")
	private TaskService taskService;
	
	@EJB(mappedName="java:module/pmo/UserDao")
	private UserDao userDao;
	
	@EJB(mappedName="java:module/pmo/EmployeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public String displayHome(ModelMap pModel) {
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Employee employee = userDao.getUser(user.getUsername());
		
		List<Task> tasks = taskService.getTasks(employee);
		
		List<Event> absences = employeeService.getEvents(employeeService.getDetails(user.getUsername()).getId_employee(), EventType.ABSENCE.getName());
				
		pModel.addAttribute("user", user);
		pModel.addAttribute("tasks", tasks);
		pModel.addAttribute("absences", absences);
		
		return "home/home";

	}
	
}
