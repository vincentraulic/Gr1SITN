package com.pmo.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pmo.model.Project;
import com.pmo.service.ProjectService;

@FacesConverter("com.pmo.ProjectConverter")
public class ProjectConverter implements Converter{

	@EJB
	private transient ProjectService projectService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Project project = projectService.getProject(value);
		
		//TODO gérer si projet non trouvé
		
		return project;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
