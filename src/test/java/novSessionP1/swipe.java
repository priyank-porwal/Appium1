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
		driver.findElementByXPath("//android.widget.CheckBox").click();
		driver.findElementById("android:id/button1").click();
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	
	}

@Test
public void swipeHorizontal() throws InterruptedException {
	
	Dimension size = driver.manage().window().getSize();
	  System.out.println(size);
	  int startx = (int)(size.width*0.70);
	  int endx = (int)(size.width * 0.30);
	  int starty = size.height/2;
	  System.out.println("startx =" + startx +" ,endx= "+endx +", starty = "+starty);
	  driver.swipe(startx, starty, endx, starty, 3000);
	  driver.swipe(endx,starty,startx,starty,3000);
	  Thread.sleep(2000); 
	
	
}

@Test
public void swipeVertical() throws InterruptedException {
	
	Dimension size = driver.manage().window().getSize();
	  System.out.println(size);
	  int startx = (int)(size.height*0.70);
	  int endx = (int)(size.height * 0.30);
	  int starty = size.width/2;
	  System.out.println("startx =" + startx +" ,endx= "+endx +", starty = "+starty);
	  driver.swipe(startx, starty, endx, starty, 3000);
	  driver.swipe(endx,starty,startx,starty,3000);
	  Thread.sleep(2000); 
}
	  @Test(enabled=false)
	  public void scrollUsingTouchAction1(){
		  
		  driver.findElementByXPath("android.widger.TextView[@text='Views']").click();
		  
		  TouchAction action = new TouchAction((MobileDriver) driver);
		  
		  WebElement ele1 = driver.findElementByXPath("//android.widget.TextView[@text = ]");
		  int x = ele1.getLocation().getX();
		  int y = ele1.getLocation().getY();
		  
		  action.press(x,y).waitAction(10000).moveTo(x, y+200).release().perform();
		  
		  
	  }
	
	

	
		

	

	
	@AfterTest
	public void AfterTest() {

	}

}
