package com.pmo.controller;


import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.pmo.event.type.EventType;
import com.pmo.exception.InvalidDateException;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;
import com.pmo.utils.StringUtils;

@RequestScoped
@Named
public class EventController implements Serializable {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = -8392497429459702995L;

		public final static Logger LOG = Logger.getLogger(EventController.class.getName());
		
		@EJB
		private transient EmployeeService employeeService;
		
		private Event event;
		
		public Event getEvent() {
			LOG.info("passage par GET Event");
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		@PostConstruct
		private void init(){
			event = new Event();
			event.setType(EventType.ABSENCE);
			event.setTitle("test");
			LOG.info("initialisation objet event");
		}

		public String create() {
			LOG.info("Passage create event controller ");
			LOG.info("objet event raison: " + event.getReason());
			LOG.info("objet event date start et end : " + event.getStart() + " et " + event.getEnd());
			try {
				
				employeeService.createEvent(event);
				
				String message = MessageFormat.format(StringUtils.getBundle().getString("createeventsuccess"),event.getEmployee().getFirstname(),event.getEmployee().getLastname());
	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			}
			catch(InvalidDateException ide) {
				LOG.warning("Une erreur s'est produite lors de la création de l'event : " + ide);
			}
			return "home/homeContent";
		}


	}
