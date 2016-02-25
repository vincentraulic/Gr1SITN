package com.pmo.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;

@RequestScoped
@Named("loginController")
public class LoginController {

	@EJB
	private transient UserDao userDao;
	
    public String doLogin() throws IOException, ServletException {   	
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }
    
    public String doLogout() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return "/login.jsf";
    }
    
	
	public String checkConnected(){
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (! user.toString().equals("anonymousUser"))
			return "/view/home/homeContent.jsf";
		else
			return null;
	}
}
