package genericUtilities;

import java.io.IOException;





import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import genericUtilities.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * This class implementation to ITestListener Interface of TestNG
 * @author Najira
 */

public class ListenersImplementation implements ITestListener {
		
		ExtentReports report;
		ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+ " - @Test is execution Started");
		
		//Intimate the start of @Test to Extent Reports
		test= report.createTest(methodname);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+ " - @Test is execution PASS");
		
		//Intimate Extent Reports @Test is PASS- log the status
		
		test.log(Status.PASS, methodname+ "- @Test is execution PASS");		
	}

	
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+ " - @Test is execution FAIL");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log the Fail Status in Extend Reports
		
		test.log(Status.FAIL, methodname+"-@Test is Execution FAIL");
		
		//Log the Exception in Extent Reports
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture ScreenShot
		
		 SeleniumUtility s1= new SeleniumUtility();
		 JavaUtility j1=new JavaUtility();
		
		//Configure Screenshot name
		
		String screenshotName =methodname+ "-"+ j1.getSystemDateInFormat();
		
		try {
			
			String path = s1.captureScreenshot(BaseClass.sDriver, screenshotName);
			
			//Attach the screenshot to Extent Report
			test.addScreenCaptureFromPath(path);	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+ " - @Test is execution SKIP");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log the Status as SKIP in Extent Reports
		test.log(Status.SKIP, methodname + " -@Test is exeution SKIP");
		
		//Log the Exception in Extent Reports
		
		test.log(Status.WARNING,result.getThrowable());
	}
		
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Suite is Execution  Started");
		
		//Configuration of Extent Reports
		
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\AutomationFamework.QCO-SOEAJD-A10\\ExtentReports" + new JavaUtility().getSystemDateInFormat()+ ".html");
		esr.config().setDocumentTitle("SauceLabs Execution Report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		//Load the Basic Configuration to Extent Reports class
		
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser","Microsoft Edge");
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Base URL", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Najira");
		
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Suite is Execution Finished");
		
		//Flush the report
		
		report.flush();
		
	}

}
	
