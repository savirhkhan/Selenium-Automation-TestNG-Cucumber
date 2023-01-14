package WebAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dataList {
	public WebDriver driver;
	String url = "https://www.selenium.dev/selenium/web/web-form.html";

	@Test
	public void testDataList() {
		driver = new ChromeDriver();
		driver.get(url);

		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"my-options\"]/option"));
		for (WebElement i : findElements) {
			System.out.println(i.getAttribute("value"));

		}

	}

}
