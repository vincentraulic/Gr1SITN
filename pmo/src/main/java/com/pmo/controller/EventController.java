package com.pmo.controller;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmo.dao.UserDao;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;
import com.pmo.utils.StringUtils;

@ManagedBean
@Named("eventController")
public class EventController {

		@EJB
		private transient EmployeeService employeeService;
		
		@EJB
		private transient UserDao userDao;

		@Inject
		private Conversation conversation ;

		private Event event;

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		@PostConstruct
		private void init(){
			event = new Event();
			conversation.begin();
		}

		public String create(){

			// Récupérer l'employée en cours
			// event.setEmployee(employeeService.getEmployee());

			employeeService.createEvent(event);

			conversation.end();

			String message = MessageFormat.format(StringUtils.getBundle().getString("createeventsuccess"),event.getEmployee().getFirstname(),event.getEmployee().getLastname());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			return "home/homeContent";
		}


	}
