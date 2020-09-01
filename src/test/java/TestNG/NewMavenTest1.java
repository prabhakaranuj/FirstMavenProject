package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class NewMavenTest1 {
	WebDriver driver = null;

	//@BeforeMethod 
	@BeforeClass 
	public void openChromeAndLoginWebshop() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	//Thread.sleep(5000); // 5 sec
		
		//EPD
		driver.get("https://uschiter02.nventco.com:56601/b2b_ecom/init.do");
		//DPP
		//driver.get("https://uschitpp01.nventco.com:55701/b2b_ecom/init.do");
		
		driver.findElement(By.id("userid")).sendKeys("B2BTEST_USTH");
		driver.findElement(By.id("password")).sendKeys("Welcome@001");
		driver.findElement(By.xpath("//*[@id=\"button-logon\"]")).submit();
	} 
	  //@Test
	  public void searchTransaction() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("isaTop"); Thread.sleep(1000);
		  driver.switchTo().frame("organizer_content"); Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/table/tbody/tr[1]/td[2]/select")).sendKeys("Order"); Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys("1090910265"); Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/table/tbody/tr[3]/td[2]/select")).sendKeys("Last 12 Months"); Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/a")).click();
	  }

	  @Test
	  public void openShopAndCreateQuotation() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(1000);
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("isaTop"); Thread.sleep(1000);
		  driver.switchTo().frame("work_history"); Thread.sleep(1000);
		  driver.switchTo().frame("form_input"); Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id=\"b2b-create-basket\"]")).click(); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\'poNumber\']")).sendKeys("test-AP-2020-08-14"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"shipCond\"]")).sendKeys("Domestic Surface"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"product[1]\"]")).sendKeys("SUB3"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"buttons\"]/ul[1]/li[2]/a")).click(); Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@id=\"simulSel\"]")).sendKeys("Quotation"); Thread.sleep(1000);

		  //driver.findElement(By.xpath("")).sendKeys("");
	  }
	  
	  //@Test
	  public void openShopAndCreateOrder() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(1000);
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("isaTop"); Thread.sleep(1000);
		  driver.switchTo().frame("work_history"); Thread.sleep(100);
		  driver.switchTo().frame("form_input"); Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id=\"b2b-create-basket\"]")).click(); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\'poNumber\']")).sendKeys("test-AP-2020-08-14"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"shipCond\"]")).sendKeys("Domestic Surface"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"product[1]\"]")).sendKeys("SUB3"); Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"buttons\"]/ul[1]/li[2]/a")).click(); Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@id=\"simulSel\"]")).sendKeys("Quotation"); Thread.sleep(1000);

		  //driver.findElement(By.xpath("")).sendKeys("");
	  }
  //@AfterMethod
  @AfterClass
  public void closeChrome() {
	  driver.close();
  }
}
