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
import org.testng.annotations.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class launchApp {

	AndroidDriver driver;

	@BeforeTest
	public void BeforeTest() throws MalformedURLException {

		File app = new File(System.getProperty("user.dir") + "\\Apps\\MultiTouchTester.apk");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		// cap.setCapability("appPackage", "com.example.android.apis");
		// cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// @Test
	// public void f() {
	// /*Drag and drop
	//
	// System.out.println("app installed");
	// driver.findElement(MobileBy.AndroidUIAutomator("text(\"Basic usage
	// playground\")")).click();
	//
	//
	// WebElement e1 = (WebElement)
	// driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
	// WebElement e2 = (WebElement)
	// driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
	//
	// TouchAction act = new TouchAction(driver);
	// System.out.println("It is draging element");
	// act.longPress(e1).moveTo(e2).release().perform();
	// System.out.println("Element Dropped Successfully");
	// */
	//
	//
	//
	// }

	@Test
	public void TestMethod() {
		Dimension size = driver.manage().window().getSize();

		// x,y coordinate of action1(Top Left)
		int x1 = (int) (size.width * 0.20);
		int y1 = (int) (size.height * 0.20);

		// x,y coordinate of action2(Top Right)
		int x2 = (int) (size.width * 0.80);
		int y2 = (int) (size.height * 0.20);

		// x,y coordinate of action3( Bottom Left)
		int x3 = (int) (size.width * 0.20);
		int y3 = (int) (size.height * 0.80);

		// x,y coordinate of action4(Bottom Right)
		int x4 = (int) (size.width * 0.80);
		int y4 = (int) (size.height * 0.80);

		// x,y coordinate of action5(Middle Screen)
		int x5 = size.width / 2;
		int y5 = size.height / 2;
		
		
		MultiTouchAction mta = new MultiTouchAction(driver);
		
		TouchAction ta1 = new TouchAction(driver).longPress(x1,y1).waitAction(Duration.ofSeconds(5));
		TouchAction ta2 = new TouchAction((MobileDriver) driver).longPress(x2,y2).waitAction(Duration.ofSeconds(5));
		TouchAction ta3 = new TouchAction((MobileDriver) driver).longPress(x3,y3).waitAction(Duration.ofSeconds(5));
		TouchAction ta4 = new TouchAction((MobileDriver) driver).longPress(x4,y4).waitAction(Duration.ofSeconds(5));
		TouchAction ta5 = new TouchAction((MobileDriver) driver).longPress(x5,y5).waitAction(Duration.ofSeconds(5));
		
		mta.add(ta1).add(ta2).add(ta3).add(ta4).add(ta5).perform();

		
		
		

	}

	@AfterTest
	public void AfterTest() {

	}

}
