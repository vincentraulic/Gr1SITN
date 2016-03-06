package com.pmo.event.type;

public enum EventType {

	ABSENCE("Absence"),
	RTT("RTT"),
	LEAVE("Leave"),
	SICK_LEAVE("Sick leave"),
	FORMATION("Formation"),
	PROJECT_ENTRY("Project entry"),
	PROJECT_EXIT("Project exit"),
	MEETING("Reunion"),
	OTHER("Autre");
	
	private String name;
	
	EventType(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
