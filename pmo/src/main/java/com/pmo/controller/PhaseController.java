package com.pmo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.pmo.model.Phase;
import com.pmo.model.Project;
import com.pmo.service.PhaseService;
import com.pmo.service.ProjectService;

@ViewScoped
@Named("phaseController")
public class PhaseController implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4566716205510425356L;
	
	@EJB
	private transient PhaseService phaseService;
	
	@EJB
	private transient ProjectService projectService;

	private Phase phase;

	@PostConstruct
	private void init(){
		setPhase(new Phase());
	}

	public String create(){

		phaseService.createPhase(phase);

		return null;
	}	
	
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	public void addPhase(Project project){
		//phase.setProject(project);
		Project p = projectService.getProject(project.getId());
				p.getPhases().add(phase);
		//System.out.println(projectService.getProject(1).getPhases());
		setPhase(new Phase());
	}		
	
    public void onEditPhase(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Phase edit�e",((Phase) event.getObject()).getName());  
        //TODO update la phase
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancelPhase(RowEditEvent event) {     	
        FacesMessage msg = new FacesMessage("Phase supprim�e");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        //TODO supprimer la phase du projet
    } 

}
