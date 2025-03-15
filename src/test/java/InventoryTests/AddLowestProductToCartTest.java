package InventoryTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;




@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestProductToCartTest extends BaseClass {
     
		@Test(groups= "RegressionSuite")
		
	 public void tc_002_addLowestProductToCart() throws IOException {
		
		//Read data from files
		
		String SORTOPTION = fUtil.readDataFromExcelFile("Products", 7, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 7, 3);
		
		//Sort the product
		InventoryPage ip=new InventoryPage(driver);
		ip.getSortDropDown();
		String ProductToBeAdded = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
		
		//Add the product to cart
		
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		//Navigate to cart page
		
		ip.clickOnCartContainer();
		
		//Validate the product
		
		CartPage cp=new CartPage(driver);
		String ProductInCart = cp.getItemName();
		
		Assert.assertEquals(ProductInCart, ProductToBeAdded);
		System.out.println(PRODUCTNAME);
		
		
	
	}
}
