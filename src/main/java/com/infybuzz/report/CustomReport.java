package com.infybuzz.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CustomReport {

    public static void main(String[] args) {
        try {
            String filePath = "/home/arnaldo/Desktop/Setting-Up-Java-Project-with-Jasper/src/main/resources/Student.jrxml";

            Subject subject1 = new Subject("Java", 80);
            Subject subject2 = new Subject("MySQL", 70);
            Subject subject3 = new Subject("PHP", 50);
            Subject subject4 = new Subject("MongoDB", 40);
            Subject subject5 = new Subject("C++", 60);

            List<Subject> list = new ArrayList<Subject>();
            list.add(subject1);
            list.add(subject2);
            list.add(subject3);
            list.add(subject4);
            list.add(subject5);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(list);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("studentName", "John");
            parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print =
                    JasperFillManager.fillReport(report, parameters, chartDataSource);

            JasperExportManager.exportReportToPdfFile(print, "/home/arnaldo/Desktop/Exported-Reports/student.pdf");

            System.out.println("Report Created...");

        } catch(Exception e) {
            System.out.println("Exception while creating report");
        }
    }

}
