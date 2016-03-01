package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Phase;
import com.pmo.model.Project;

@Local
public interface PhaseService {

	public int createPhase(Phase phase);
	
	public List<Phase> getPhases(Project project);
	
	public void updatePhase(Phase phase);
}
