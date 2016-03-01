package com.pmo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmo.model.Phase;
import com.pmo.service.PhaseService;

@RequestScoped
@Named("phaseController")
public class PhaseController implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4566716205510425356L;
	@EJB
	private transient PhaseService phaseService;
	
	@Inject
	private Conversation conversation ;

	private Phase phase;

	@PostConstruct
	private void init(){
		setPhase(new Phase());
		conversation.begin();
	}

	public String create(){

		phaseService.createPhase(phase);

		conversation.end();

		return "home/homeContent";
	}	
	
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

}
