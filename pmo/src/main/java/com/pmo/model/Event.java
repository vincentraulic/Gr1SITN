package com.pmo.model;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.pmo.event.type.EventType;

@NamedQueries({
	@NamedQuery(
	        name="Event.findAll",
	        query="SELECT a FROM Event a"),
	@NamedQuery(
        name="Event.findByEmployeeId",
        query="SELECT a FROM Event a "
				+ "WHERE a.employee.id = :id_e"),
    @NamedQuery(
        name="Event.findByEmployeeIdType",
        query="SELECT a FROM Event a "
				+ "WHERE a.employee.id = :id_e "
				+ "AND a.type = :typ")
})
@Entity
@Table(name="EVENT")
public class Event extends AbstractPersistent{

	public final static Logger LOG = Logger.getLogger(Event.class.getName());
	
	private static final long serialVersionUID = 5741436241683297737L;

	private String reason;
	
	@Enumerated(EnumType.STRING)
	private EventType type;
	
	@Column(name="datestart")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Column(name="dateend")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	private boolean allDay;
	
	@ManyToOne
	@JoinColumn(name="id_employee")
	private Employee employee;
	
	@Transient
	private String title;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
		LOG.info("changement reason event par : " + reason);
	}
	
	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date dateStart) {
		this.start = dateStart;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date dateEnd) {
		this.end = dateEnd;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getTitle() {
		return type + " : " + reason;
	}
	
	public boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Event a = (Event) obj;
		
		if(a.getId() != this.getId())
			return false;
		if( !a.reason.equals(this.reason))
			return false;
		if( !a.start.equals(this.start))
			return false;
		if( !a.end.equals(this.end))
			return false;
		if( !a.employee.equals(this.employee))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
        return result;
	}
	
	
	/**
	 * Returns true if the dates are filled, and if the start date is before the end date
	 * The start date can be the end date (for a one-day event)
	 * TODO : Update the function if it's a timestamp and not a simple date
	 **/
	public boolean checkIfDatesAreFilledAndConformed() {
		return start != null && end != null && (end.after(start) || end.equals(start));
	}

	public void setTitle(String t) {
		this.title = t;
	}


}
