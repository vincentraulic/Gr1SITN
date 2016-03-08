package com.pmo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Phase;
import com.pmo.model.Project;
import com.pmo.service.EmployeeService;
import com.pmo.service.ProjectService;
import com.pmo.user.service.UserPmo;

@ViewScoped
@Named("projectController")
public class ProjectController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372999549377720106L;
	
	@EJB
	private transient ProjectService projectService;
	
	@EJB
	private transient EmployeeService employeeService;
	
	@EJB
	private transient UserDao userDao;
	
	private DualListModel<Employee> employees;
	
	private Project project;
	
	private Phase phase;

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public List<Project> getProjects() {
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee currentEmployee = userDao.getUser(user.getUsername());
		
		return new ArrayList<Project> (currentEmployee.getProjects());
	}
	
	public DualListModel<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(DualListModel<Employee> employees) {
		this.employees = employees;
	}
	
	public void deletePhase(Phase p){
		Set<Phase> lp = project.getPhases();
		lp.remove(p);
		project.setPhases(lp);
	}
	
	public void addPhase(){
		//TODO check le cout ne dépasse pas le cout total, ...
		phase.setProject(project);
		project.getPhases().add(phase);
		phase = new Phase();
	}	
	
	@PostConstruct
	private void init(){	
		project = new Project();
		
		phase = new Phase();
		
		List<Employee> _employees = employeeService.getEmployees();
		
		UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee currentEmployee = userDao.getUser(user.getUsername());
		
		//we remove the user in the employee list
		_employees.remove(currentEmployee);
		
		employees = new DualListModel<Employee>(_employees, new ArrayList<Employee>());
	}
	
	public String create(){
		
		project.setEmployees(new HashSet<Employee>(employees.getTarget()));
		
		projectService.createProject(project);
		
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
    
    public void onEditPhase(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Phase editée",((Phase) event.getObject()).getName());  
        //TODO update la phase
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancelPhase(RowEditEvent event) {     	
        FacesMessage msg = new FacesMessage("Phase supprimée");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        project.getPhases().remove((Phase) event.getObject());
    } 

	
}
