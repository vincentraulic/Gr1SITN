package com.pmo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private static Pattern p = Pattern.compile("[^A-Za-z0-9]");
	
	/**
	 * @param str the candidate String
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
	
	public static boolean hasSpecialCharacter(String s) {
	     if (s == null || s.trim().isEmpty()) {
	         System.out.println("Incorrect format of string");
	         return false;
	     }
	     
	     Matcher m = p.matcher(s);
	    // boolean b = m.matches();
	     return m.find();

	 }
	
}
