package com.pmo.service.bean;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pmo.dao.EmployeeDao;
import com.pmo.dao.EventDao;
import com.pmo.dao.UserDao;
import com.pmo.event.type.EventType;
import com.pmo.exception.EventTypeNotFoundException;
import com.pmo.exception.InvalidDateException;
import com.pmo.exception.UnknownEmployeeException;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;
import com.pmo.user.service.UserPmo;
import com.pmo.utils.Email;

@Stateless
public class EmployeeServiceBean implements EmployeeService{

	@EJB
	private EmployeeDao employeeDao;
	
	@EJB
	private UserDao userDao;
	
	@EJB
	private EventDao eventDao;
	
	@Override
	public int createEmployee(Employee employee) {

		//Setting a generate password
		SecureRandom random = new SecureRandom();
		String password = new BigInteger(120, random).toString(20);

		//send the password to the admin
		Email email = new Email();
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee admin = userDao.getUser(user.getUsername());
		List<String> recipients = new ArrayList<String>();
		recipients.add(admin.getEmail());
		email.send(recipients, "Compte de " + employee.getFirstname() + " " + employee.getLastname(),
					"Bonjour,\nVoici le mot de passe pour le compte de " + employee.getFirstname() + " " + employee.getLastname()
					+ " : " + password);
		
		//encrypt the password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		//TODO remettre l'encryptage par la suite
		//employee.setPassword(hashedPassword);
		employee.setPassword(password);
		
		//set the standard email
		//TODO mettre le domaine de l'email dans un fichier propriete
		String domaine = "gmail.com";
		employee.setEmail(employee.getFirstname() + "." + employee.getLastname() + "@" + domaine);
		
		return employeeDao.createEmployee(employee);
	}

	@Override
	public Employee getDetails(String username) {
		//TODO gérer si l'username n'existe pas
		
		return userDao.getUser(username);
	}

	@Override
	public Employee getEmployee(int id) throws UnknownEmployeeException {
		//TODO gérer si l'id n'existe pas
		
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public int createEvent(Event event) throws InvalidDateException {

		event.checkIfDatesAreFilledAndConformed();
		
		int id = eventDao.createEvent(event);
		return id;
	}
	
	@Override
	public List<Event> getEvents(int idEmployee) throws UnknownEmployeeException {
		//TODO gérer si l'id n'existe pas
		
		return eventDao.getEvents(idEmployee);
	}

	@Override
	public List<Event> getEvents(Employee employee, EventType type) throws UnknownEmployeeException, EventTypeNotFoundException {
		//TODO check si le type de Event existe
		return eventDao.getEvents(employee.getId(), type);
	}

	@Override
	public int updateEvent(Event event) throws InvalidDateException {

		event.checkIfDatesAreFilledAndConformed();
		
		return eventDao.updateEvent(event);
	}
	
	

}
