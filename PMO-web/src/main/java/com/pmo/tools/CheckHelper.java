package com.pmo.tools;

import com.mysql.jdbc.StringUtils;
import com.pmo.event.type.EventType;

public abstract class CheckHelper {
	
	public static boolean checkEventType(String event) {
		if(StringUtils.isNullOrEmpty(event)) {
			return false;
		}

		for(EventType eventType : EventType.values()) {
			if(eventType.toString().toLowerCase().equals(event.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
