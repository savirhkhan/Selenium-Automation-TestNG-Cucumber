package WebAutomation;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.OrderFormDelivery;
import PageObjects.OrderFormPayment;
import PageObjects.OrderFormPersInfo;
import PageObjects.OrderFormShippingMethod;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomePage;
import PageObjects.ShopProductPage;
import PageObjects.ShoppingCart;
import base.BasePage;
import base.ExtentManager;
import base.Hooks;


@Listeners(resources.Listeners.class)


public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}

	
	@Test
	public void endToEndTest() throws InterruptedException, IOException {
		ExtentManager.log("Starting OrderCompleteTest....");
		HomePage home = new HomePage();
		//home.getToggle().click();
		//Thread.sleep(2000);
		home.getTestStoreLink().click();
		ExtentManager.pass("Have successfully reached Store HomePage");

		ShopHomePage shophome = new ShopHomePage();
		shophome.getProdOne().click();
		ExtentManager.pass("Have successfully clicked on Product");

		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Have successfully reached Shop product Page");
		Select options = new Select(shopProd.getSizeOption());
		options.selectByVisibleText("M");
		ExtentManager.pass("Have succefully selected the Product Size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have succefully increase Quantity");
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Have succefully added the Product to basket");

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		ExtentManager.pass("Have successfully reached Shopping cartPage");
		cart.getHavePromo().click();
		ExtentManager.pass("Have successfully selected the promo button");
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		cart.getProceedCheckoutBtn().click();
		ExtentManager.pass("Have successfully selected CheckOut Button");

		OrderFormPersInfo pinfo = new OrderFormPersInfo();
		pinfo.getGenderMr().click();
		pinfo.getFirstNameField().sendKeys("savir");
		pinfo.getLastnameField().sendKeys("Khan");
		pinfo.getEmailField().sendKeys("test@testsavir.com");
		pinfo.getTermsConditionsCheckbox().click();
		pinfo.getContinueBtn().click();

		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("U 123");
		orderDelivery.getCityField().sendKeys("Delhi");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Florida");
		orderDelivery.getPostcodeField().sendKeys("12345");
		orderDelivery.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered the delevery info");

		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("Please leave at the shop below apartments");
		shipMethod.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered the shipping method");

		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
		ExtentManager.pass("Have successfully closed the order");

	}

}
