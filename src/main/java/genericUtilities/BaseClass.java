package genericUtilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

/**
 * This class consists of all basic Configuration annotations
 * of TestNG
 * @author Najira N
 *
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	public WebDriver driver;

	// For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun=true) 
	public void bsConfig()
	{
		System.out.println("---- Database Connection Successful ----");
		
	} 
	
	
	
	//@Parameters("browser")

	//@BeforeTest //for parallel execution
	@BeforeClass(alwaysRun=true)  
	//@BeforeClass(groups= {" SmokeSuite"," RegressionSuite"})  // example of multiple suites in base class
	//public void bcConfig(String Bvalue) throws IOException//Cross Browser execution
	public void bcConfig() throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
		/*For Cross Browser Execution*/
//		if(Bvalue.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(Bvalue.equalsIgnoreCase("chrome"))
//		{
//			driver= new ChromeDriver();
//		}
//		else
//		{
//			driver=new EdgeDriver();
//		}
		/*-------------------------------------------------------*/
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("---- Browser Launch Successful ----");
		
		//For Listeners
		
		sDriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		System.out.println("---- Login to App Successful ----");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("---- Logout of App Successful ----");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("---- Browser closure Successful ----");
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("---- Database closure Successful ----");
		
	}

}