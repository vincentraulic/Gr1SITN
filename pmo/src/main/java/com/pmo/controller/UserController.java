package com.pmo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Project;
import com.pmo.model.Task;
import com.pmo.service.EmployeeService;
import com.pmo.service.TaskService;
import com.pmo.user.service.UserPmo;

@SessionScoped
@Named
public class UserController implements Serializable{

	public final static Logger LOG = Logger.getLogger(UserController.class.getName());
	
	private static final long serialVersionUID = 7465185353899089409L;
	
	@EJB
	private transient TaskService taskService;
	
	@EJB
	private transient UserDao userDao;
	
	@EJB
	private transient EmployeeService employeeService;
	
	@Inject
	private transient TaskController taskController;
	
	private UserPmo user;

	
	private List<EventType> listTypeAbsence = new ArrayList<>();
	
	@PostConstruct
	private void init(){
		
		getListTypeAbsence().add(EventType.ABSENCE);
		getListTypeAbsence().add(EventType.RTT);
		getListTypeAbsence().add(EventType.LEAVE);
		getListTypeAbsence().add(EventType.SICK_LEAVE);
		
		user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public Employee getEmployee() {
		return userDao.getUser(user.getUsername());
	}
	
	public List<Task> getTasks(){
		return new ArrayList<Task>(getEmployee().getTasks());
	}
	
	/**
	 * Get all tasks of all projects of the user
	 * @return list of tasks
	 */
	public List<Task> getAllTasksEmployees() {
		List<Task> tasks = new ArrayList<>();
		for(Project p : getEmployee().getProjects()) {
			tasks.addAll(taskController.getTasksOfProject(p));
		}
		
		//remove tasks of the user otherwise there are duplicate tasks
		tasks.removeAll(getTasks());
		return tasks;
	}
	
	public List<Event> getEvents(){
		return new ArrayList<Event>(getEmployee().getEvents());
	}
	
	// Get all the absences of the employee
	public List<Event> getAbsences(){
		return getAbsences(false);
	}
	
	// TODO : Prévoir la gestion des cas des demi-journées avec le booléen allDay lorsque ça sera implémenté
	// FIXME : On devrait faire event.getEnd().getTime() + 1 journée, car dans le cas d'une journée complète
	// 			la fin est le 17 par exemple, mais le retour n'est que le 18
	
	// Get all the absences of the employee
	// If the boolean fromNow is set to "true", will not return the absences already finished 
	public List<Event> getAbsences(boolean fromNow){
		List<Event> absences = new ArrayList<Event>();
		for(Event event : getEmployee().getEvents()){
			if(getListTypeAbsence().contains(event.getType()) 
				&& (!fromNow || fromNow && event.getEnd().getTime() >= Calendar.getInstance().getTimeInMillis())) {
				absences.add(event);
			}
		}
		return absences;
	}
	
	// FIXME : La méthode n'est jamais appelée par le rendu HOME (page d'accueil JSF). A corriger
	// FIXME : Même fixme que pour la méthode getAbsences(fromNow)
	public List<Event> getAbsencesEmployees() {
		Set<Employee> employees = new HashSet<>();
		for(Project p : getEmployee().getProjects()) {
			employees.addAll(p.getEmployees());
		}

		List<Event> absences = new ArrayList<Event>();
		for(Employee emp : employees){
			for(Event event : emp.getEvents()){
				// Get all absences from today
				if(getListTypeAbsence().contains(event.getType()) && event.getEnd().getTime() >= Calendar.getInstance().getTimeInMillis())
					absences.add(event);
			}
		}
		absences.sort(new Comparator<Event>() {
			@Override
			public int compare(Event o1, Event o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});

		return absences;
	}

	public List<EventType> getListTypeAbsence() {
		return listTypeAbsence;
	}

	
}
