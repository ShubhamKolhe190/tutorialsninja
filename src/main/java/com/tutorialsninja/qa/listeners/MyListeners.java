package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.tutorialninja.qa.utils.ExtentReporterclass;


public class MyListeners implements ITestListener{
//	public static ExtentReports extentReport;
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//	
//	@Override
//	public void onStart(ITestContext context) {
//		try 
//		{
//			ExtentReporterclass.generateExtentReport();
//		} 
//		catch (IOException e) 
//		{
//		e.printStackTrace();
//		}
//	}
//		
//	
//	@Override
//	public void onTestStart(ITestResult result) {
//		extentTest.set(extentReport.createTest(result.getName()));	
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		String  Testname = result.getName();
//		extentTest.get().log(Status.PASS, Testname+ "Successfully executed");
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		String  Testname = result.getName();
//		System.out.println("taken screenshot");
//		WebDriver driver=null;
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			e.printStackTrace();
//		}
//		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\+Testname.png";
//		
//		try {
//			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
//		extentTest.log(Status.INFO, result.getThrowable());
//		extentTest.log(Status.FAIL, " got failed");
//		
//		
//	}
//		String testName = result.getName();
//	    System.out.println("Taking screenshot for failed test: " + testName);
//
//	    WebDriver driver = null;
//	    try {
//	        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	    String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
//
//	    try {
//	        FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//
//	    // Logging to Extent Report
//	    extentTest.get().addScreenCaptureFromPath(destinationScreenshotPath);
//	    extentTest.get().log(Status.INFO, result.getThrowable());
//	    extentTest.get().log(Status.FAIL, "Test failed");
//	    
//	    if (extentTest.get() != null) {
//            extentTest.get().addScreenCaptureFromPath("path/to/screenshot");
//        }
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		String  Testname = result.getName();
//		extentTest.get().log(Status.INFO, result.getThrowable());
//		extentTest.get().log(Status.SKIP, Testname+ " - got skipped");
//	}
	
//	@Override
//	public void onTestFinish(ITestResult result) {
//		extentTest.remove();
//	}
//
//	
//
//	@Override
//	public void onFinish(ITestContext context) {
//		if (extentReport != null) {
//            extentReport.flush();  // Ensure extentReport is not null before calling flush()
//        }
//	}
	 public static ExtentReports extentReport;
	    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        try {
	            extentReport = ExtentReporterclass.generateExtentReport(); // Set the global extentReport here
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        extentTest.set(extentReport.createTest(result.getName()));
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        String testName = result.getName();
	        extentTest.get().log(Status.PASS, testName + " successfully executed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        String testName = result.getName();
	        System.out.println("Taking screenshot for failed test: " + testName);

	        WebDriver driver = null;
	        try {
	            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";

	        try {
	            FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Ensure that extentTest is not null before using it
	        if (extentTest.get() != null) {
	            extentTest.get().addScreenCaptureFromPath(destinationScreenshotPath);
	            extentTest.get().log(Status.INFO, result.getThrowable());
	            extentTest.get().log(Status.FAIL, "Test failed");
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        String testName = result.getName();
	        extentTest.get().log(Status.INFO, result.getThrowable());
	        extentTest.get().log(Status.SKIP, testName + " - got skipped");
	    }


	    @Override
	    public void onFinish(ITestContext context) {
	        if (extentReport != null) {
	            extentReport.flush();  // Ensure extentReport is not null before calling flush
	        }
	        System.out.println("finished exceuting");
	        String pathofExtentReport = System.getProperty("user.dir")+"\\null\\test-output\\ExtentReports\\extentReport.html";
	        File extentReport = new File(pathofExtentReport);
	        try {
	        	Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
}
