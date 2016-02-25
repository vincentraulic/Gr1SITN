package com.pmo.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;
import com.pmo.user.service.UserPmo;
 
@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {

	private static final long serialVersionUID = -6062981628012210057L;

	@EJB
	private transient EmployeeService employeeService;
	
	@EJB
	private transient UserDao userDao;
	
	private transient Employee employee;
	
	private ScheduleModel eventModel;
 
    private ScheduleEvent scheduleEvent = new DefaultScheduleEvent();
    
    private Event ev = new Event();
 
    @PostConstruct
    public void init() {
    	UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		employee = userDao.getUser(user.getUsername());
    	
    	List<Event> events = employeeService.getEvents(employee.getId());
    	
        eventModel = new DefaultScheduleModel();
        
        for(Event e : events){
        	ScheduleEvent schEv = new DefaultScheduleEvent(e.getTitle(), e.getStart(), e.getEnd());
        	eventModel.addEvent(schEv);
        	schEv.setId(String.valueOf(e.getId()));
        }
        
        ev.setEmployee(employee);
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
     
    public void addEvent(ActionEvent actionEvent) {
		
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
}