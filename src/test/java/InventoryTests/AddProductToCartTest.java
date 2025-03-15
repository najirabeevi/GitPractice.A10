package InventoryTests;

	import java.io.IOException;



	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	import genericUtilities.BaseClass;
	import ObjectRepository.CartPage;
	import ObjectRepository.InventoryItemPage;
	import ObjectRepository.InventoryPage;

@Listeners(genericUtilities.ListenersImplementation.class) //for all classes listeners are mandatory 
public class AddProductToCartTest extends BaseClass{

	@Test(groups ="SmokeSuite")
  public void tc_001_addProductToCart() throws IOException {
	
	//Read the Data from files
	
	 String PRODUCTNAME = fUtil.readDataFromExcelFile("Products",1,2);
	
	//click on product
	
	InventoryPage ip=new InventoryPage(driver);
	String ProductToBeAdded = ip.clickOnProduct(driver, PRODUCTNAME);
	
	//Assert.fail();
	
	//Addproduct in Cart
	
	InventoryItemPage iip=new InventoryItemPage(driver);
	iip.clickOnAddToCart();
	
	//Navigate to cart
	
	ip.clickOnCartContainer();
	
	//Validate in Cart page
	
	CartPage cp=new CartPage(driver);
	String ProductInCart = cp.getItemName();
	
	Assert.assertEquals(ProductInCart, ProductToBeAdded);
	//Assert.assertTrue(ProductInCart.equals(ProductToBeAdded));
	System.out.println(PRODUCTNAME);
}
}
