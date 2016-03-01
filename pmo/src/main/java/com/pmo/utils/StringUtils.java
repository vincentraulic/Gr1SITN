package com.pmo.utils;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

public class StringUtils {

	private static Pattern p = Pattern.compile("[^A-Za-z0-9]");
	
	static FacesContext context = FacesContext.getCurrentInstance();
	private static ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
	
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
	
	public static String removeHyphen (String s){
		return s.replace("-", "");
	}

	public static ResourceBundle getBundle() {
		return bundle;
	}

}
