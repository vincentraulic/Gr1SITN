package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Phase;
import com.pmo.model.Project;

@Local
public interface PhaseDao {
	
	public int createPhase(Phase phase);
	
	public Phase getPhase(int id);
	
	public void deletePhase(Phase phase);
	
	public List<Phase> getPhases(Project project);
	
}
