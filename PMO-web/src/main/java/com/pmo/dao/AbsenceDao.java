package com.pmo.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Absence;


@Local
public interface AbsenceDao {

	public int createAbsence(int id_employee,
							 String reason,
							 Date dateStart,
							 Date dateEnd);
	
	public Absence getAbsence(int id);
	
	public List<Absence> getAbsences(int id_employee);
	
}
