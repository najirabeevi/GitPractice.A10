package genericUtilities;

import java.io.File;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium tool
 * @author Najira
 */
public class SeleniumUtility {

	
	/**
	 * This method will maximize window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	

	/**
	 * This method will minimize window
	 * @param driver
	 */
	

	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait of 10 seconds
	 * @param driver
	 */
	
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 *  @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 seconds for element to be Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * This method will handle dropdown by Value
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by VisibleText
	 * @param element
	 * @param visibletext
	 */
	
	public void handleDropdown(String visibletext,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	/**
	 * This method will perform mouse hovering action on web element
	 * @param driver
	 * @param element 
	 */

	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse drag and drop action on web element
	 * @param driver
	 * @param element 
	 */

	public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement targetelement)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(srcelement,targetelement).perform();
	}
	/**
	 * This method will perform mouse double click action on web element
	 * @param driver
	 * @param element 
	 */

	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	
	
	/**
	 * This method will perform mouse right click action on web element
	 * @param driver
	 * @param element 
	 */

	public void contextClickAction(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method will perform mouse click on particular web element
	 * @param driver
	 * @param element
	 */
		
	public void click(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
	/**
	 * This method will send the keys to particular Web element
	 * @param driver
	 * @param element
	 * @param CharSequence
	 */
 
	public void sendkeys(WebDriver driver,WebElement element,String CharSequence)
	{
		Actions action=new Actions(driver);
		action.click(element).sendKeys(CharSequence).perform();
		
	}
	
	/**
	 * This method will send the keys to particular Web element
	 * @param driver
	 * @param element
	 * @param CharSequence
	 */
 
	public void sendKeysWithElementAndData(WebDriver driver,WebElement element,String data)
	{
		Actions action=new Actions(driver);
		action.sendKeys(element, data).perform();
	}
	
	/**
	 * This method will perform scrollTo  particular web element
	 * @param driver
	 * @param element 
	 */

	public void scrollToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.scrollToElement(element).perform();
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */

	public void handlingFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
		
 /**
  *This method will switch to frame based on string name or id 
  * @param driver
  * @param nameorID
  */
	
	public void handlingFrame(WebDriver driver,String nameorID)
	{
	
		driver.switchTo().frame(nameorID);
	}
		
/**
 * This method will switch to frame based on webelement
 * 		
 */
	public void handlingFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * This method will switch the control to parentFrame
	 * @param driver
	 */
	
	public void switchToParentWindow(WebDriver driver)
	{
		driver.switchTo().parentFrame();
		
	}	
	
	/**
	 * This method will switch to window
	 * @param driver
	 * @param windowID
	 */
	public void switchToWindow(WebDriver driver,String windowID)
	{
		driver.switchTo().window(windowID);
		
	}	
	

	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the alert text
	 * @param driver
	 * @return
	 */

	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
		
	/**
	 * 	This method will enter the data to alert popup
	 * @param driver
	 * @param data
	 */
	
	public void enterDataToAlert(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenshot(WebDriver driver,String screenshotName)throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShots\\"+screenshotName+".png");
		FileHandler.copy(src,dst);
		
		return dst.getAbsolutePath();  //For Extent Reports
		
		//addProductToCart  -ts- addProductToCart-22-02-2025-14-21-32.png;
		//addProductToCart  -ts- addProductToCart-22-02-2025-14-22-13.png;(time changes in every screenshot.So no duplicates)
	
	}

	
	
}

