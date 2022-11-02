package com.infybuzz.report;

import java.util.HashMap;
import java.util.Map;

public class FirstReport {

	public static void main(String[] args) {
		
		try {
			String filePath = "/home/arnaldo/Desktop/Setting-Up-Java-Project-with-Jasper/src/main/resources/FirstReport.jrxml";
			Map<String, Object>  parameters = new HashMap<String, Object>();
			parameters.put("studentName", "John");
		} catch(Exception e) {
			System.out.println("Exception while creating report");
		}
	}

}
