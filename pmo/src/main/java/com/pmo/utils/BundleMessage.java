package com.pmo.utils;

import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class BundleMessage {

	public ResourceBundle getBundle() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication().getResourceBundle(context, "msg");	
	}
}
