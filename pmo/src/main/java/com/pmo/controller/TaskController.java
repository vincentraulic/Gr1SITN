package com.pmo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;
import com.pmo.service.TaskService;

@ViewScoped
@Named
public class TaskController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148660482678453432L;

	@EJB
	private transient TaskService taskService;
	
	@Inject
	private transient UserController user;
	
	//primefaces library for chart
	private BarChartModel barModel;
	
	private ProjectTask projectTask;
	
	private Task task;

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int calculateProgression(Task task) {
		return taskService.calculateProgression(task);
	}
	
	@PostConstruct
	private void init(){	
		projectTask = new ProjectTask();
		task = new Task();
		barModel = initBarModel();
	}
	
	public void addProjectTask(Project project){
		projectTask.setProject(project);
		project.getProjectTasks().add(projectTask);
		taskService.createProjectTask(projectTask);
	}
	
	/**
	 * 
	 * @param project
	 * @return All the tasks of the project
	 */
	public List<Task> getTasksOfProject(Project project) {
		List<Task> tasks = taskService.getTasks(project);
		
		return tasks;
	}
	
	public void addTask() {
		task.getProjectTask().getTasks().add(task);
		taskService.createTask(task);
	}
	
    public void onEditTask(RowEditEvent event) { 
    	taskService.updateTask((Task) event.getObject());
        FacesMessage msg = new FacesMessage("Tâche editée",((Task) event.getObject()).getProjectTask().getName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancelTask(RowEditEvent event) {  
    	taskService.delete((Task) event.getObject());
        FacesMessage msg = new FacesMessage("Tâche supprimée");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    } 
    
    private BarChartModel initBarModel() {
        
 
        Employee employee = user.getEmployee();
        Set<Project> projects = employee.getProjects();
        
        
        ChartSeries costProjects = new ChartSeries();
        costProjects.setLabel("Coût JH du projet total");
        for(Project p : projects) {
        	Set<ProjectTask> pTs = p.getProjectTasks();
        	int cost = 0;
        	for(ProjectTask pT : pTs) {
        		cost += pT.getCost();
        	}
        	costProjects.set(p.getName(), cost);
        }
        
        ChartSeries costProjectsAffected = new ChartSeries();
        costProjectsAffected.setLabel("Coût JH du projet affecté");
        for(Project p : projects) {
        	Set<ProjectTask> pTs = p.getProjectTasks();
        	int cost = 0;
        	for(ProjectTask pT : pTs) {
        		Set<Task> ts = pT.getTasks();
        		for(Task t : ts) {
        			cost += t.getCost();
        		}
        	}
        	costProjectsAffected.set(p.getName(), cost);
        }
        
        ChartSeries costProjectsUsed = new ChartSeries();
        costProjectsUsed.setLabel("Coût JH du projet utilisé");
        for(Project p : projects) {
        	Set<ProjectTask> pTs = p.getProjectTasks();
        	int cost = 0;
        	for(ProjectTask pT : pTs) {
        		Set<Task> ts = pT.getTasks();
        		for(Task t : ts) {
        			cost += t.getMandayUsed();
        		}
        	}
        	costProjectsUsed.set(p.getName(), cost);
        }
 
        BarChartModel model = new BarChartModel();
        model.addSeries(costProjects);
        model.addSeries(costProjectsAffected);
        model.addSeries(costProjectsUsed);
        
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Projets");
         
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Coûts JH");
        
        return model;
    }

	public BarChartModel getBarModel() {
		return barModel;
	}

    

}
