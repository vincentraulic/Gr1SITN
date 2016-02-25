package com.pmo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.service.EmployeeService;
import com.pmo.service.ProjectService;
import com.pmo.user.service.UserPmo;

@RequestScoped
@Named("projectController")
public class ProjectController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372999549377720106L;
	
	@Inject
	private Conversation conversation ;
	
	@EJB
	private transient ProjectService projectService;
	
	@EJB
	private transient EmployeeService employeeService;
	
	@EJB
	private transient UserDao userDao;
	
	private DualListModel<Employee> employees;
	
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public DualListModel<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(DualListModel<Employee> employees) {
		this.employees = employees;
	}
	
	@PostConstruct
	private void init(){
		project = new Project();
		
		List<Employee> _employees = employeeService.getEmployees();
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee currentEmployee = userDao.getUser(user.getUsername());
		
		//we remove the user in the employee list
		_employees.remove(currentEmployee);
		
		employees = new DualListModel<Employee>(_employees, new ArrayList<Employee>());
		
		conversation.begin();
	}
	
	public String create(){
		
		project.setEmployees(new HashSet<Employee>(employees.getTarget()));
		
		projectService.createProject(project);
		
		conversation.end();
		
		//TODO mettre dans fichier propriete
		String message = "Le projet " + project.getName() + " " + "a bien été créé";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		return "home/homeContent";
	}
	
	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Employee) item).getFirstname()).append(" ")
            .append(((Employee) item).getLastname())
            .append("<br />");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

	
}
