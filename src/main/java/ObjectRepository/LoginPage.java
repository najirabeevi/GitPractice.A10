package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Rule 1: Create a POM class for every WebPage
	
	//Rule 2: Identify the web elements- Declaration
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(id="login-button")
	private WebElement LoginBtn;
	
	//Rule 3: Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//Rule 4:Utilization
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Rule 5: Business library- generic method but related to scenario
	
	/**
	 * This method will perform login operation
	 * 
	 */
	
	public void LoginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		LoginBtn.click();
	}
	
	
	
	
}


