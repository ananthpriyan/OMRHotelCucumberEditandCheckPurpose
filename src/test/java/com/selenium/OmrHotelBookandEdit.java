package com.selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrHotelBookandEdit {
	WebDriver driver;
	
    public static void main(String[] args) {
		
	
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
    WebElement cityid=driver.findElement(By.id("city"));
    Select sc=new Select(state);
    sl.selectByVisibleText("Tamil Nadu");
  
    WebElement citysel = driver.findElement(By.xpath("//input[@type='search']"));
    citysel.sendKeys("Chennai",Keys.ENTER);

    
    //Roomtype
    WebElement roomtype=driver.findElement(By.id("room_type"));
   // roomtype.click();
    Select s2=new Select(roomtype);
    s2.selectByVisibleText("Deluxe");
    Select s3=new Select(roomtype);
    s3.selectByVisibleText("Suite");
    Select s4=new Select(roomtype);
    s4.selectByVisibleText("Luxury");
    
    
    
 //   driver.findElement(By.xpath("//li[text()='Deluxe']")).click();
   // roomtype.click();
    //driver.findElement(By.xpath("//li[text()='Suite']")).click();
   // roomtype.click();
  //  driver.findElement(By.xpath("//li[text()='Luxury']")).click();
    WebElement datein=driver.findElement(By.name("check_in"));
  //Check in date
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].setAttribute('value','2023-06-15')",datein);
    
  
  //Checkout date
  WebElement dateout=driver.findElement(By.name("check_out"));
  
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
  
  WebElement lowtohigh = driver.findElement(By.xpath("//label[text()='Price low to high']"));
 lowtohigh.click();
  WebElement btnContinue = driver.findElement(By.xpath("//a[text()='Continue']"));
  btnContinue.click();
  
  Alert alert = driver.switchTo().alert();
  alert.accept();
  
  WebElement radiobtn = driver.findElement(By.name("booking_for"));
  radiobtn.click();
  
  WebElement title = driver.findElement(By.id("user_title"));
  title.click();
  driver.findElement(By.xpath("//option[text()='Mr.']")).click();
  driver.findElement(By.id("first_name")).sendKeys("Anandharaj");
 
  //Last name
  WebElement lastname = driver.findElement(By.id("last_name"));
  JavascriptExecutor js2=(JavascriptExecutor)driver;
  js2.executeScript("arguments[0].setAttribute('value','Anbazhagan')",lastname);
  
  WebElement userph = driver.findElement(By.id("user_phone"));  
  js2.executeScript("arguments[0].setAttribute('value','9003845731')", userph);
  
  driver.findElement(By.id("user_email")).sendKeys("ananthpriyan@gmail.com");
  driver.findElement(By.xpath("//button[text()='Next']")).click();
  driver.findElement(By.xpath("//input[@id='high']")).click();
  driver.findElement(By.xpath("//button[@id='step2next']")).click();
  driver.findElement(By.xpath("//div[@class='credit-card pm']")).click();
  
  driver.findElement(By.id("payment_type")).click();
  driver.findElement(By.xpath("//option[text()='Debit Card']")).click();
  
  driver.findElement(By.id("card_type")).click();
  driver.findElement(By.xpath("//option[text()='Visa']")).click();
  

  driver.findElement(By.id("card_no")).sendKeys("5555555555552222");
  driver.findElement(By.id("card_name")).sendKeys("ANANDHARAJ");
  
  driver.findElement(By.id("card_month")).click();
  driver.findElement(By.xpath("//option[text()='June']")).click();
  
  
  driver.findElement(By.id("card_year")).click();
  driver.findElement(By.xpath("//option[text()='2025']")).click();
  driver.findElement(By.id("cvv")).sendKeys("456");
  driver.findElement(By.id("submitBtn")).click();
  
  driver.findElement(By.xpath("//button[text()='My Booking']")).click();
  //driver.findElement(By.xpath("//a[contains(text(),'Welcome Anandharaj')]")).click();
 // driver.findElement(By.xpath("//a[text()='My Account']")).click();
  driver.findElement(By.xpath("//button[text()='Edit']")).click();
  WebElement checkinEdit = driver.findElement(By.xpath("//input[@name='check_in']"));
  JavascriptExecutor js3=(JavascriptExecutor)driver; 
  js3.executeScript("arguments[0].setAttribute('value','2023-06-20')", checkinEdit);
  
  driver.findElement(By.xpath("//button[text()='Confirm']")).click();

}

	

}
