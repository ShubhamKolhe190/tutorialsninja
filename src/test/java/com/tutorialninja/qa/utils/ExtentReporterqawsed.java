package com.tutorialninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterqawsed {
	public static ExtentReports generateExtentReport() throws IOException {
		
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentreportFile = new File(System.getProperty("user,dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentreportFile);

		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialNinja Extent Report");
		sparkReporter.config().setDocumentTitle("TutorialNinja Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File fisConfigfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\turorialsninja\\qa\\config\\config.properties");
		FileInputStream fisConfigProp= new FileInputStream(fisConfigfile);
		configProp.load(fisConfigProp);
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("EmailAddress", configProp.getProperty("validemailaddress"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validpassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("user name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
	
		return extentReport;
	}

}
