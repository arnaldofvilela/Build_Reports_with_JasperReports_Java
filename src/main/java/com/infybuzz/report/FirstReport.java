package com.infybuzz.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstReport {

	public static void main(String[] args) {
		
		try {
			String filePath = "/home/arnaldo/Desktop/Setting-Up-Java-Project-with-Jasper/src/main/resources/FirstReport.jrxml";

			Map<String, Object>  parameters = new HashMap<String, Object>();
			parameters.put("studentName", "John");

			Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street", "Delhi");
			Student student2 = new Student(2L, "Peter", "Smith", "Any Street", "Mumbai");

			List<Student> list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);

			JasperReport report = JasperCompileManager.compileReport(filePath);

			JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

			JasperExportManager.exportReportToPdfFile(print, "/home/arnaldo/Desktop/Exported-Reports/FirstReport.pdf");
//			JasperExportManager.exportReportToPdf(print);
			System.out.println("Report Created...");

		} catch(Exception e) {
			System.out.println("Exception while creating report");
		}
	}

}
