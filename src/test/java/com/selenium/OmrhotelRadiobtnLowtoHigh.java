package com.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrhotelRadiobtnLowtoHigh {
	
	WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	

	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.omrbranch.com/");
	
	WebElement txtUser = driver.findElement(By.id("email"));
	txtUser.sendKeys("ananthpriyanan@gmail.com");
	
	WebElement txtPass = driver.findElement(By.id("pass"));
	txtPass.sendKeys("Kavinila@123");
	WebElement btnClick = driver.findElement(By.cssSelector("[type=submit][value=login]"));
	btnClick.click();
	
	// Select state
	WebElement state=driver.findElement(By.id("state"));
    state.click();
    Select sl=new Select(state);
    sl.selectByVisibleText("Tamil Nadu");
  
  
  // Select city
    WebElement city=driver.findElement(By.xpath("//span[text()='Select City *']"));
    city.click();
  
    WebElement citysel = driver.findElement(By.xpath("//input[@type='search']"));
    citysel.sendKeys("Chennai",Keys.ENTER);

    
    //Roomtype
    WebElement roomtype=driver.findElement(By.xpath("//textarea[@class='select2-search__field']"));
    roomtype.click();
    driver.findElement(By.xpath("//li[text()='Deluxe']")).click();
    roomtype.click();
    
    WebElement datein=driver.findElement(By.name("check_in"));
   // datein.click();
  //Check in date
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].setAttribute('value','2023-06-15')",datein);
    
  //Checkout date
  WebElement dateout=driver.findElement(By.name("check_out"));
  //dateout.click();
  JavascriptExecutor js1=(JavascriptExecutor)driver;
  js1.executeScript("arguments[0].setAttribute('value','2023-07-19')",dateout);
  

  WebElement numofroom = driver.findElement(By.id("no_rooms"));
  numofroom.click();
  Select sl2=new Select(numofroom);
  sl2.selectByVisibleText("2-Two");
  
  //Adults
  WebElement adult = driver.findElement(By.id("no_adults"));
  adult.click();
  Select sl3=new Select(adult);
  sl3.selectByVisibleText("2-Two");
 
  WebElement child = driver.findElement(By.id("no_child"));
  child.click();
  child.sendKeys("2");
  
  
  WebElement iframe = driver.findElement(By.id("hotelsearch_iframe"));
  driver.switchTo().frame(iframe);
  WebElement btnSearch = driver.findElement(By.xpath("//button[text()='Search']"));
 
  btnSearch.click();
  
  WebElement priceLowtoHigh = driver.findElement(By.xpath("//label[text()='Price low to high']"));
  priceLowtoHigh.click();
  
  Thread.sleep(3000);
  List<WebElement> lowToHigh = driver.findElements(By.xpath("//strong[@class='total-prize']"));
  int size = lowToHigh.size();
  
  for (int i = 0; i < size; i++) {
	  String text = lowToHigh.get(i).getText();
	  System.out.println(text);

}
  for (WebElement webElement : lowToHigh) {
	 
	  String text = webElement.getText();
	  System.out.println(text);
	
}

}
}