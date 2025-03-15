package ObjectRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryItemPage extends SeleniumUtility{
	
		@FindBy(id="add-to-cart")
		private WebElement addToCartBtn;
		
		public InventoryItemPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		public WebElement getAddToCartBtn() {
			return addToCartBtn;
		}
		
		//Business Library
		
	/**
	 * This method will click on add to cart button
	 */
		
		public void clickOnAddToCart()
		{
			addToCartBtn.click();
		}
}
