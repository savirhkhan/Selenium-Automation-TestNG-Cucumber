package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopContentPanel extends BasePage{

	public WebDriver driver;

	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.cssSelector(".cart-content-btn .btn-primary");

	public ShopContentPanel() throws IOException {
		super();
	}

	public WebElement getContinueShopBtn() {
		this.driver=getDriver();
		return driver.findElement(continueShoppingBtn);
	}

	public WebElement getCheckoutBtn() {
		this.driver=getDriver();
		return driver.findElement(checkoutBtn);
	}

}
