package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private String url;
	private Properties prop;
	public static String screenShotDestinationPath;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(data);
	}

	public static WebDriver getDriver() {
		return WebDriverInstance.getDriver();
	}

	public String getUrl() {
		url = prop.getProperty("url");
		return url;
	}

	public String takeSnapShot(String string) throws IOException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String desFile = System.getProperty("user.dir") + "\\target\\ScreenShots" + timeStamp() + ".png";
		screenShotDestinationPath = desFile;

		FileUtils.copyFile(srcFile, new File(desFile));
		return string;
	}
	
	public static String getScreenshotDestinationPath() {
		return screenShotDestinationPath;
	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date());
	}

	public static void waitForElementToInvisible(WebElement element, int timer) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
