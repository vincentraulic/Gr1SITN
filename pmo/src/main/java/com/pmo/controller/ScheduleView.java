package com.pmo.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.pmo.event.type.EventType;
import com.pmo.exception.UnknownEmployeeException;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;
 
@ViewScoped
@Named
public class ScheduleView implements Serializable {

	private static final long serialVersionUID = -6062981628012210057L;
	
	public final static Logger LOG = Logger.getLogger(ScheduleView.class.getName());

	@EJB
	private transient EmployeeService employeeService;
	
	@Inject
	private transient UserController user;
	
	private transient Employee employee;
	
	private ScheduleModel eventModel;
 
    private ScheduleEvent scheduleEvent = new DefaultScheduleEvent();
    
    private Event ev = new Event();
 
    @PostConstruct
    public void init() {
		employee = user.getEmployee();
    	
		try {
	    	List<Event> events = employeeService.getEvents(employee.getId());
	    	
	        eventModel = new DefaultScheduleModel();
	        
	        for(Event e : events){
	        	ScheduleEvent schEv = new DefaultScheduleEvent(e.getTitle(), e.getStart(), e.getEnd());
	        	eventModel.addEvent(schEv);
	        	schEv.setId(String.valueOf(e.getId()));
	        }
	        
	        ev.setEmployee(employee);
		}
		catch(UnknownEmployeeException uee) {
			LOG.warning("Employee " + employee.getId() + " does not exist. " + uee);
		}
    }
     
     
    public Event getEv() {
		return ev;
	}


	public void setEv(Event ev) {
		this.ev = ev;
	}


	public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    public ScheduleEvent getEvent() {
        return scheduleEvent;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.scheduleEvent = event;
    }
     
    /**
     * Prise en compte remarque de O.Cailloux
     * Suppression du paramètre actionEvent
     */
    public void addEvent() {
		
        if(scheduleEvent.getId() == null){
            eventModel.addEvent(scheduleEvent);
            ev.setReason(scheduleEvent.getTitle());
            ev.setStart(scheduleEvent.getStartDate());
            ev.setEnd(scheduleEvent.getEndDate());
            ev.setAllDay(scheduleEvent.isAllDay());
            
            //create event
            employeeService.createEvent(ev);
            scheduleEvent.setId(String.valueOf(ev.getId()));
        }
        else{
        	eventModel.updateEvent(scheduleEvent);
        	ev.setId(Integer.parseInt(scheduleEvent.getId()));
            ev.setReason(scheduleEvent.getTitle());
            ev.setStart(scheduleEvent.getStartDate());
            ev.setEnd(scheduleEvent.getEndDate());
            ev.setAllDay(scheduleEvent.isAllDay());
            
            employeeService.updateEvent(ev);
        }
         
        scheduleEvent = new DefaultScheduleEvent();
        ev = new Event();
        ev.setEmployee(employee);
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
    	scheduleEvent = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
    	scheduleEvent = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        addMessage(message);
        
        ev.setId(Integer.parseInt(event.getScheduleEvent().getId()));
        ev.setStart(event.getScheduleEvent().getStartDate());
        ev.setEnd(event.getScheduleEvent().getEndDate());
        ev.setAllDay(event.getScheduleEvent().isAllDay());
        
        employeeService.updateEvent(ev);
        
        scheduleEvent = new DefaultScheduleEvent();
        ev = new Event();
        ev.setEmployee(employee);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        addMessage(message);

        ev.setId(Integer.parseInt(event.getScheduleEvent().getId()));
        ev.setStart(event.getScheduleEvent().getStartDate());
        ev.setEnd(event.getScheduleEvent().getEndDate());
        ev.setAllDay(event.getScheduleEvent().isAllDay());

        employeeService.updateEvent(ev);
        
        scheduleEvent = new DefaultScheduleEvent();
        ev = new Event();
        ev.setEmployee(employee);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public EventType[] getEventTypes()
    {
    	return EventType.values();
    }
   
}