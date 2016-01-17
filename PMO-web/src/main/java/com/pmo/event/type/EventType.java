package com.pmo.event.type;

public enum EventType {

	ABSENCE("Absence"),
	OTHER("Autre"),
	MEETING("Réunion");
	
	private String name = "";
	
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
