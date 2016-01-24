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
 
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    private Event ev = new Event();
 
    @PostConstruct
    public void init() {
    	UserPmo user = (UserPmo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		employee = userDao.getUser(user.getUsername());
    	
    	List<Event> events = employeeService.getEvents(employee.getId());
    	
        eventModel = new DefaultScheduleModel();
        
        for(Event e : events){
        	eventModel.addEvent(new DefaultScheduleEvent(e.getTitle(), e.getStart(), e.getEnd()));
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
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
		
        if(event.getId() == null){
            eventModel.addEvent(event);
            ev.setReason(event.getTitle());
            ev.setStart(event.getStartDate());
            ev.setEnd(event.getEndDate());
            ev.setAllDay(event.isAllDay());
            //create event
            int id = employeeService.createEvent(ev);
            event.setId(String.valueOf(id));
        }
        else{
        	eventModel.updateEvent(event);
        	ev.setId(Integer.parseInt(event.getId()));
            ev.setReason(event.getTitle());
            ev.setStart(event.getStartDate());
            ev.setEnd(event.getEndDate());
            ev.setAllDay(event.isAllDay());
        }
         
        event = new DefaultScheduleEvent();
        ev = new Event();
        ev.setEmployee(employee);
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}