package Cucumber.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomePage;
import PageObjects.ShopProductPage;
import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImp {
	public Hooks hk;
	HomePage home;
	ShopHomePage shophome;
	ShopProductPage shopProd;
	ShopContentPanel cPanel;

	@Given("I landed on WebPage  ")
	public void I_landed_on_webPage() throws IOException {
		hk = new Hooks();
		hk.setUp();
	}

	@Given("Navigate to test Store Web Page")
	public void navigate_to_test_store_web_page() throws IOException {
		hk = new Hooks();
		hk.setUp();
		home = new HomePage();
		home.getTestStoreLink().click();

	}

	@When("I Add the product to cart")
	public void I_add_the_product_to_cart() throws IOException {
		shophome = new ShopHomePage();
		shophome.getProdOne().click();
		shopProd = new ShopProductPage();

		Select options = new Select(shopProd.getSizeOption());
		options.selectByVisibleText("M");

		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

	}

	@And("I click on Checkout")
	public void I_Click_Check_out() throws IOException {
		cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();
	}
	
	 
	@Then("Landed on page with title {string}")
	public void land_on_page_with_title(String string) {
		String actualTitle = hk.getDriver().getTitle();
		Assert.assertTrue(actualTitle.equalsIgnoreCase(string));
		hk.tearDown();
	}
	

}
