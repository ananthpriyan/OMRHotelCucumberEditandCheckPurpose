package com.baseclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReports {
	
	
	public static void generateJvmReports(String jsonFile) {
		
		
		File file=new File(System.getProperty("user.dir")+"\\target");
		
		Configuration con=new Configuration(file, "OMRBranchHotelAutomation");
		con.addClassifications("platform", "windows10");
		con.addClassifications("Sprint", "1");
		con.addClassifications("author", "Anandharaj");
		
		List<String> l= new ArrayList<String>();
		l.add(jsonFile);
		
		ReportBuilder report=new ReportBuilder(l, con);
		report.generateReports();
		

	}
	
	
	
	
	

}
