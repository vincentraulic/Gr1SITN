package com.pmo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Task;
import com.pmo.service.EmployeeService;
import com.pmo.service.TaskService;
import com.pmo.user.service.UserPmo;

@SessionScoped
@Named("userController")
public class UserController implements Serializable{

	private static final long serialVersionUID = 7465185353899089409L;

	@EJB
	private transient TaskService taskService;
	
	@EJB
	private transient UserDao userDao;
	
	@EJB
	private transient EmployeeService employeeService;
	
	private Employee employee;
	
	@PostConstruct
	private void init(){
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		employee = userDao.getUser(user.getUsername());
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public List<Task> getTasks(){
		return new ArrayList<Task>(employee.getTasks());
	}
	
	public List<Event> getEvents(){
		return new ArrayList<Event>(employee.getEvents());
	}
	
	public List<Event> getAbsences(){
		return new ArrayList<Event>(employeeService.getEvents(employee, EventType.ABSENCE));
	}
	
}
