package com.pmo.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pmo.controller.UserController;
import com.pmo.event.type.EventType;

public class EventSpecificTest {
	
	public final static Logger LOG = Logger.getLogger(EventSpecificTest.class.getName());
	
	Employee emp = null;
	
	Set<Event> eventList = new HashSet<Event>();

	private Date currentDate;

	private Date futureDate;

	private Date oldDate;
	
	UserController uc = new UserController();
	
	@After
	public void afterTest() {
		eventList.clear();
	}
	
	@Before
	public void initTestEventTypes() {
		LOG.warning("Echouera car il manque un moyen de lier l'UserController "
				+ "de test à l'employé de test (nous ne voulons pas créer "
				+ "de setEmployee(), ce n'est pas sécurisé...");
		LOG.info("L'algo des tests est quand même OK, mais du coup à vérifier à la main");
		
		emp = uc.getEmployee();
		emp.setUsername("quentin.combier");
		emp.setFirstname("Quentin");
		emp.setLastname("Combier");
		// FIXME : Trouver un moyen de lier l'utilisateur de test à l'UserController
		// uc.setEmployee(emp);
		
		Calendar cal = Calendar.getInstance();
		currentDate = cal.getTime();
		
		cal.add(Calendar.MONTH, -1);
		oldDate = cal.getTime();
		
		cal.add(Calendar.MONTH, 2);
		futureDate = cal.getTime();
	}
	
	public void initCorrectAbsences() {
		// TODO : Prévoir la gestion des "allDay"
		
		Event e1 = new Event();
		e1.setType(EventType.ABSENCE);
		e1.setStart(oldDate);
		e1.setEnd(oldDate);
		e1.setReason("Reason1");
		e1.setEmployee(emp);

		Event e2 = new Event();
		e2.setType(EventType.RTT);
		e2.setStart(currentDate);
		e2.setEnd(currentDate);
		e2.setReason("Reason2");
		e2.setEmployee(emp);
		
		Event e3 = new Event();
		e3.setType(EventType.ABSENCE);
		e3.setStart(futureDate);
		e3.setEnd(futureDate);
		e3.setReason("Reason3");
		e3.setEmployee(emp);
		
		Event e4 = new Event();
		e4.setType(EventType.SICK_LEAVE);
		e4.setStart(currentDate);
		e4.setEnd(currentDate);
		e4.setReason("Reason4");
		e4.setEmployee(emp);
		
		Event e5 = new Event();
		e5.setType(EventType.LEAVE);
		e5.setStart(oldDate);
		e5.setEnd(oldDate);
		e5.setReason("Reason5");
		e5.setEmployee(emp);
		
		Event e6 = new Event();
		e6.setType(EventType.LEAVE);
		e6.setStart(futureDate);
		e6.setEnd(futureDate);
		e6.setReason("Reason6");
		e6.setEmployee(emp);
		
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		eventList.add(e4);
		eventList.add(e5);
		eventList.add(e6);
		
		emp.setEvents(eventList);
	}
	
	public void initIncorrectAndCorrectAbsences() {
		// TODO : Prévoir la gestion des "allDay"
		
		Event e1 = new Event();
		e1.setType(EventType.ABSENCE);
		e1.setStart(oldDate);
		e1.setEnd(oldDate);
		e1.setReason("Reason1");
		e1.setEmployee(emp);

		Event e2 = new Event();
		e2.setType(EventType.RTT);
		e2.setStart(currentDate);
		e2.setEnd(currentDate);
		e2.setReason("Reason2");
		e2.setEmployee(emp);
		
		Event e3 = new Event();
		e3.setType(EventType.MEETING);
		e3.setStart(futureDate);
		e3.setEnd(futureDate);
		e3.setReason("Reason3");
		e3.setEmployee(emp);
		
		Event e4 = new Event();
		e4.setType(EventType.SICK_LEAVE);
		e4.setStart(currentDate);
		e4.setEnd(currentDate);
		e4.setReason("Reason4");
		e4.setEmployee(emp);
		
		Event e5 = new Event();
		e5.setType(EventType.PROJECT_ENTRY);
		e5.setStart(oldDate);
		e5.setEnd(oldDate);
		e5.setReason("Reason5");
		e5.setEmployee(emp);
		
		Event e6 = new Event();
		e6.setType(EventType.LEAVE);
		e6.setStart(futureDate);
		e6.setEnd(futureDate);
		e6.setReason("Reason6");
		e6.setEmployee(emp);
		
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		eventList.add(e4);
		eventList.add(e5);
		eventList.add(e6);
		
		emp.setEvents(eventList);
	}
	
	@Test
	public void testGetAbsencesWithCorrectTypesInEntry() {
		initCorrectAbsences();

		for(Event e : uc.getAbsences()) {
			Assert.assertTrue(uc.getListTypeAbsence().contains(e.getType()));
		}
	}
	
	@Test
	public void testGetAbsencesWithIncorrectTypesInEntry() {
		initIncorrectAndCorrectAbsences();

		for(Event e : uc.getAbsences()) {
			Assert.assertTrue(uc.getListTypeAbsence().contains(e.getType()));
		}
	}
}
