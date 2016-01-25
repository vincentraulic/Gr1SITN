package com.exos.transactionEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pmo.model.Project;

/** 
 * 
 * @author Vincent
 * Reviewer Roland
 * Transaction pour projet
 *
 */

@Stateless
@LocalBean
public class ProjectTransaction {	

	// May need an addition of a maven library
	//@Transactional(isolation = Isolation.READ_COMMITTED)
	
	public Project initCostProject(int idProject){	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pmodb_local") ;

		EntityManager em = emf.createEntityManager() ;
		EntityTransaction transaction = em.getTransaction();

		Project project = null;

		try {
			transaction.begin();

			project = em.find(Project.class, idProject);
			if(project != null && project.getCost() != 0){
				project.setCost(0);
				em.merge(project) ;
				transaction.commit();
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}


		return project;
	}
}
