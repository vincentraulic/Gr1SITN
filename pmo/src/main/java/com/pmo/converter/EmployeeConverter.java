package com.pmo.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pmo.exception.UnknownEmployeeException;
import com.pmo.model.Employee;
import com.pmo.service.EmployeeService;

@FacesConverter("com.pmo.EmployeeConverter")
public class EmployeeConverter implements Converter{

	@EJB
	private transient EmployeeService employeeService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws UnknownEmployeeException {
		Employee employee = employeeService.getEmployee(Integer.valueOf(value));
		
		//TODO check l'employé existe
		
		return employee;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
