package com.pmo.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.pmo.dao.AbsenceDao;
import com.pmo.model.Absence;
import com.pmo.model.Employee;

@Stateless
public class AbsenceDaoImpl implements AbsenceDao{

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createAbsence(int id_employee, String reason, Date dateStart,
			Date dateEnd) {
		if(StringUtils.isEmpty(reason) || dateStart == null 
				|| dateEnd == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		if(dateEnd.compareTo(dateStart) < 0)
			throw new IllegalArgumentException("dateStart must be before the dateEnd");
		
		Absence absence = new Absence();
		absence.setReason(reason);
		absence.setDateStart(dateStart);
		absence.setDateEnd(dateEnd);
		
		try{
			Employee employee = em.getReference(Employee.class, id_employee);
			absence.setEmployee(employee);
			em.persist(absence);
			return absence.getId_absence();
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Employee not found in database");
		}
	}

	public Absence getAbsence(int id) {
		return em.find(Absence.class, id);
	}

	public List<Absence> getAbsences(int id_employee) {
		try{
			em.getReference(Employee.class, id_employee);
		} catch(EntityNotFoundException e){
			return null;
		}
		
		List<Absence> list = (List<Absence>) em.createQuery("SELECT a FROM Absence a "
								+ "WHERE a.id_employee = :id_e")
								.setParameter("id_e", id_employee);
		return list;
	}

}
