package CartTests;

	import java.io.IOException;

	import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import genericUtilities.BaseClass;
	import ObjectRepository.CartPage;
	import ObjectRepository.InventoryItemPage;
	import ObjectRepository.InventoryPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class RemoveProductFromCartTest extends BaseClass {

		@Test
		
		public void tc_003_RemoveProductFromCart() throws IOException {
			
			//Read data from files
			
			String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 2);
			
			//Click on Product
			
			InventoryPage ip=new InventoryPage(driver);
			String ProductToBeAdded = ip.clickOnProduct(driver, PRODUCTNAME);
			
			//Add Product to cart
			
			InventoryItemPage iip=new InventoryItemPage(driver);
			iip.clickOnAddToCart();
			
			//Navigate to cart 
			
			ip.clickOnCartContainer();
			
			//Validate the Product
			
			CartPage cp=new CartPage(driver);
			String ProductInCart = cp.getItemName();
			
			Assert.assertEquals(ProductInCart,ProductToBeAdded);
			System.out.println(PRODUCTNAME);

			//Remove the Product in Cart
			
			cp.clickOnRemoveBtn();	
		}
}
