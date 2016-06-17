package com.pmo.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pmo.service.TaskService;


@FacesConverter("com.pmo.ProjectTaskConverter")
public class ProjectTaskConverter implements Converter {

	@EJB
	private transient TaskService taskService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return taskService.getProjectTaskById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
