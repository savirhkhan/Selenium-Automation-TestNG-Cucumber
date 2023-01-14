package WebAutomation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomePage;
import PageObjects.ShopProductPage;
import PageObjects.ShoppingCart;
import base.BasePage;
import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

	public AddRemoveItemBasketTest() throws IOException {
		super();
	}

	@Test
	public void addRemoveItem() throws InterruptedException, IOException {

		ExtentManager.log("Starting AddRemoveItemBasketTest....");
		HomePage home = new HomePage();
		// home.getToggle().click();
		// Thread.sleep(2000);
		home.getTestStoreLink().click();

		ShopHomePage shophome = new ShopHomePage();
		ExtentManager.pass("Reached the shop HomePage");
		shophome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Reached the shop ProductPage");
		Select options = new Select(shopProd.getSizeOption());
		options.selectByVisibleText("M");
		ExtentManager.pass("Have succefully selected the Product Size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have succefully increase Quantity");
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Have succefully added the Product to basket");

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shophome.getProdTwo().click();
		shopProd.getQuantDecrease().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
		waitForElementToInvisible(cart.getDeleteItemTwo(), 10);

		String actualTotalAmount = cart.getTotalAmount().getText();
		String expectedTotalAmount = "$26.13";
		
		try {
			Assert.assertEquals(actualTotalAmount, expectedTotalAmount);
			ExtentManager.pass("The Total amount matches the expected amount");
		}catch (AssertionError e) {
			Assert.fail("Cart Amount did not match the expected amount "+cart.getTotalAmount().getText()+"expected $26.13");
			ExtentManager.fail("Total Amount Did not match the expected Amount");
		}
		

	}

}
