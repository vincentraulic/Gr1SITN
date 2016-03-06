package com.pmo.controller;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Project;
import com.pmo.service.EmployeeService;
import com.pmo.service.ProjectService;
import com.pmo.user.service.UserPmo;
import com.pmo.utils.StringUtils;

@ConversationScoped
@Named("employeeController")
public class EmployeeController implements Serializable{

	private static final long serialVersionUID = 3445553454588895388L;

	@EJB
	private transient EmployeeService employeeService;

	@EJB
	private transient ProjectService projectService;	

	@EJB
	private transient UserDao userDao;

	@Inject
	private Conversation conversation ;

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Project> getProjects(){
		return new ArrayList<Project>(projectService.getProjects());
	}

	public List<Project> getProjectsUser(){

		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee currentEmployee = userDao.getUser(user.getUsername());

		return new ArrayList<Project>(projectService.getProjects(currentEmployee));
	}

	@PostConstruct
	private void init(){
		employee = new Employee();
		conversation.begin();
	}

	public String create(){

		employee.setPhone(StringUtils.removeHyphen(employee.getPhone()));

		employeeService.createEmployee(employee);

		conversation.end();

		String message = MessageFormat.format(StringUtils.getBundle().getString("createemployeesuccess"),employee.getFirstname(),employee.getLastname());

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		return "home/homeContent";
	}

	public void validateEmployeeCreation(ComponentSystemEvent event){
		FacesContext fc = FacesContext.getCurrentInstance();

		UIComponent components = event.getComponent();

		//get firstname
		UIInput uiInputFirstname = (UIInput) components.findComponent("firstname");
		String firstname = uiInputFirstname.getLocalValue() == null ? ""
				: uiInputFirstname.getLocalValue().toString();
		String firstnameId = uiInputFirstname.getClientId();

		//get lastname
		UIInput uiInputLastname= (UIInput) components.findComponent("lastname");
		String lastname= uiInputLastname.getLocalValue() == null ? ""
				: uiInputLastname.getLocalValue().toString();
		String lastnameId = uiInputLastname.getClientId();

		if (StringUtils.hasSpecialCharacter(firstname)) {
			FacesMessage msg = new FacesMessage("Firstname no valid");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(firstnameId, msg);
			fc.renderResponse();
		}

		if (StringUtils.hasSpecialCharacter(lastname)) {
			FacesMessage msg = new FacesMessage("Lastname no valid");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(lastnameId, msg);
			fc.renderResponse();
		}

	}


}




