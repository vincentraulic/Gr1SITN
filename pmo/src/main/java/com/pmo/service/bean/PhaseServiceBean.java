package com.pmo.service.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.PhaseDao;
import com.pmo.dao.ProjectDao;
import com.pmo.model.Phase;
import com.pmo.model.Project;
import com.pmo.service.PhaseService;

/**
 * 
 * @author Roland
 * Remarque de O.Cailloux : supprimer ce service et utiliser directement le phaseDao
 * Pour nous, ce n'est pas justifié car on est ammené à ajouter des éléments métiers dans le code
 */
@Stateless
public class PhaseServiceBean implements PhaseService{

	@EJB
	private PhaseDao phaseDao;
	
	@EJB
	private ProjectDao projectDao;
	
	@Override
	public int createPhase(Phase phase) {
		return phaseDao.createPhase(phase);
	}

	@Override
	public List<Phase> getPhases(Project project) {
		return phaseDao.getPhases(project);
	}

	@Override
	public void updatePhase(Phase phase) {
		throw new UnsupportedOperationException("The method is not implemented yet");
	}

}
