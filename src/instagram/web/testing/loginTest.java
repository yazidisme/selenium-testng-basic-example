package instagram.web.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class loginTest {
  //Create driver variable of WebDriver
  private WebDriver driver;
  //Chrome driver
  private String keyChromeDriver = "webdriver.chrome.driver";
  //Chrome driver location
  private String valueChromeDriver = "driver/chromedriver";
  //URL address
  private String urlAddress = "https://www.instagram.com/";
	
  //Test section
  @Test
  public void validLogin() {
	  //Get URL Address
	  driver.get(urlAddress);
	  //Find element of login link using CSS selector, then click it
	  driver.findElement(By.cssSelector("p._g9ean>a")).click();
	  
	  //Find element of username field using CSS selector, then type username
	  driver.findElement(By.cssSelector("form._3jvtb>div._t296e:nth-child(1)>div._sjplo>div._ev9xl>input._ph6vk._jdqpn._o716c")).sendKeys("YOUR_USERNAME");
	  //Find element of password field using CSS selector, then type password
	  driver.findElement(By.cssSelector("form._3jvtb>div._t296e:nth-child(2)>div._sjplo>div._ev9xl>input._ph6vk._jdqpn._o716c")).sendKeys("YOUR_PASSWORD");
	  //Find element of login button using CSS selector, then click it
	  driver.findElement(By.cssSelector("button._qv64e._gexxb._4tgw8._njrw0")).click();
	  //Wait for 15 seconds after click login button
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  //Test pass if there is notification element displayed
	  Assert.assertTrue(driver.findElement(By.cssSelector("div._dzwdj._rga4h")).isDisplayed());
  }
  //Will be executed before run each test section
  @BeforeTest
  public void beforeTest() {
	  //Set property of chrome driver
	  System.setProperty(keyChromeDriver, valueChromeDriver);
	  //Create object of chrome driver
	  driver = new ChromeDriver();
  }
  //Will be executed after run each test section
  @AfterTest
  public void afterTest() {
	  //Destroy the driver instance
	  driver.quit();
  }

}
