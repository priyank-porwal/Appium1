package novSessionP1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;

public class swipe {

	AndroidDriver driver;

	@BeforeTest
	public void BeforeTest() throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "\\Apps\\SwipeListView.apk");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		// cap.setCapability("appPackage", "com.example.android.apis");
		// cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//to handle pop up
		driver.findElementByXPath("//android.widget.Checkbox").click();
		driver.findElementById("andoid:id/button1").click();
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	
	}

@Test
public void swipeHorizontal() {
	
	
	
}

	
		

	

	@AfterTest
	public void AfterTest() {

	}

}
