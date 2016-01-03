package com.pmo.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.AbsenceDao;
import com.pmo.dao.EmployeeDao;
import com.pmo.dao.UserDao;
import com.pmo.model.Absence;
import com.pmo.model.Employee;
import com.pmo.service.EmployeeService;

@Stateless
public class EmployeeServiceImpl implements EmployeeService{

	@EJB(mappedName="java:module/EmployeeDaoImpl")
	private EmployeeDao employeeDao;
	
	@EJB(mappedName="java:module/UserDaoImpl")
	private UserDao userDao;
	
	@EJB(mappedName="java:module/AbsenceDaoImpl")
	private AbsenceDao absenceDao;
	
	@Override
	public int createEmployee(String lastname, String firstname,
			String password, Date dateStart) {
		//to do verifier les champs
		
		return employeeDao.createEmployee(lastname, firstname, password, dateStart);
	}

	@Override
	public Employee getDetails(String username) {
		//to do gérer si l'username n'existe pas
		
		return userDao.getUser(username);
	}

	@Override
	public Employee getEmployee(int id) {
		//to do gérer si l'id n'existe pas
		
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public List<Absence> getAbsences(int idEmployee) {
		//to do gérer si l'id n'existe pas
		
		return absenceDao.getAbsences(idEmployee);
	}

}
