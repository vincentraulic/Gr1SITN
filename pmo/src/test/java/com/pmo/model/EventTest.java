package com.pmo.model;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pmo.exception.InvalidDateException;

public class EventTest {
	
	Date currentDate;
	
	Date oldDate;
	
	Event event;
	
	@Before
	public void initTestDates() {
		Calendar cal = Calendar.getInstance();
		currentDate = cal.getTime();
		
		cal.add(Calendar.YEAR, -1);
		oldDate = cal.getTime();
		
		event = new Event();
	}
	
	@Test
	public void testDateOk() {
		event.setStart(oldDate);
		event.setEnd(currentDate);
		
		try {
			Assert.assertTrue(event.checkIfDatesAreFilledAndConformed());
		} catch(InvalidDateException ide) {
			Assert.assertTrue("You should not have an InvalidDateException here", false);
		}
	}
	
	@Test
	public void testStartDateNotFilled() {
		event.setEnd(currentDate);
		
		try {
			event.checkIfDatesAreFilledAndConformed();
		} catch(InvalidDateException ide) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testEndDateNotFilled() {
		event.setStart(oldDate);
		
		try {
			event.checkIfDatesAreFilledAndConformed();
		} catch(InvalidDateException ide) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testNoDateFilled() {
		try {
			event.checkIfDatesAreFilledAndConformed();
		} catch(InvalidDateException ide) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testStartDateAfterEndDate() {
		event.setStart(currentDate);
		event.setEnd(oldDate);
		
		try {
			event.checkIfDatesAreFilledAndConformed();
		} catch(InvalidDateException ide) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testSameDate() {
		event.setStart(currentDate);
		event.setEnd(currentDate);
		
		try {
			Assert.assertTrue(event.checkIfDatesAreFilledAndConformed());
		} catch(InvalidDateException ide) {
			Assert.assertTrue("You should not have an InvalidDateException here", false);
		}
	}
}
