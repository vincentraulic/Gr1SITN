package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.pmo.dao.PhaseDao;
import com.pmo.model.Phase;
import com.pmo.model.Project;

@Stateless(name = "pmo/PhaseDao", mappedName = "pmo/PhaseDao")
public class PhaseDaoBean implements PhaseDao{
	
    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	@Override
	public int createPhase(Phase phase) {
		if(phase.getCost() < 0 || phase.getStart() == null || phase.getEnd() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");

		if(phase.getStart().compareTo(phase.getProject().getDateStart()) < 0 || (phase.getProject().getDateEnd() != null && phase.getEnd().compareTo(phase.getProject().getDateEnd()) > 0))
			throw new IllegalArgumentException("The interval of date of the phase is not included in the interval of date of the project");		
		
		try{
			em.getReference(Project.class, phase.getProject());
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't reference to project"
					+ " project not found in database");
		}
		
		em.persist(phase);
		
		return phase.getId();
	}

	@Override
	public Phase getPhase(int id) {
		return em.find(Phase.class, id);
	}

	@Override
	public void deletePhase(Phase phase) {
		try{
			phase = em.getReference(Phase.class, phase.getId());
			em.remove(phase);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Task not found in database");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Phase> getPhases(Project project) {
		List<Phase> list = em.createNamedQuery("Phase.findByProjectId")
				.setParameter("proj", project.getId())
				.getResultList();
		return list;
	}
	
}
