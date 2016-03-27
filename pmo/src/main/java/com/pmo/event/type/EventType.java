package com.pmo.event.type;

public enum EventType {

	ABSENCE("ABSENCE"),
	RTT("RTT"),
	LEAVE("LEAVE"),
	SICK_LEAVE("SICK_LEAVE"),
	FORMATION("FORMATION"),
	PROJECT_ENTRY("PROJECT_ENTRY"),
	PROJECT_EXIT("PROJECT_EXIT"),
	MEETING("MEETING"),
	OTHER("OTHER");
	
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
