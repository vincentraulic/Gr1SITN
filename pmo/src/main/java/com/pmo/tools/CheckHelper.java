package com.pmo.tools;

import com.pmo.event.type.EventType;
import com.pmo.exception.EventTypeNotFoundException;
import com.pmo.utils.StringUtils;

public abstract class CheckHelper {
	
	public static void checkEventType(String event) throws EventTypeNotFoundException {
		if(StringUtils.isEmpty(event)) {
			throw new EventTypeNotFoundException("Empty event.");
		}
		boolean found = false;

		for(EventType eventType : EventType.values()) {
			if(eventType.toString().toLowerCase().equals(event.toLowerCase())) {
				found = true;
				break;
			}
		}
		
		if(!found) throw new EventTypeNotFoundException("Event " + event + " can not be found.");
	}
}
