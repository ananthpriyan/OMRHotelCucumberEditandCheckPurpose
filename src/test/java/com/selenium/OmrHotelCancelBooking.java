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

public class OmrHotelCancelBooking {
	
	
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
	WebElement state=driver.findElement(By.id("state"));
	 
     Select sl=new Select(state);
	 sl.selectByVisibleText("Tamil Nadu");
	 state.click();
	 WebElement city=driver.findElement(By.xpath("//span[text()='Select City *']"));
	 city.click();
	  
	 WebElement citysel = driver.findElement(By.xpath("//input[@type='search']"));
	 citysel.sendKeys("Chennai",Keys.ENTER);
	 
	 WebElement searchBox = driver.findElement(By.id("room_type"));
     Select s2 = new Select(searchBox);
     s2.selectByIndex(1);
     s2.selectByIndex(2);
     s2.selectByIndex(3);
     WebElement checkIn = driver.findElement(By.xpath("//input[@type='text']"));
     checkIn.click();
	 

      WebElement checkin = driver.findElement(By.xpath("//input[@name='check_in']"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].setAttribute('value','2023/05/05')", checkin);
		
		
	 WebElement dateout=driver.findElement(By.name("check_out"));
	 dateout.click();
	 WebElement dates = driver.findElement(By.xpath("//a[text()='16']"));
	 dates.click();
	
	 WebElement room=driver.findElement(By.id("no_rooms"));
	 room.click();
	 WebElement member = driver.findElement(By.xpath("//*[@id=\"no_rooms\"]/option[2]"));
	 member.click();
	 

	 WebElement pn=driver.findElement(By.id("no_adults"));
	 pn.click();
	 WebElement pn1 = driver.findElement(By.xpath("//*[@id=\"no_adults\"]/option[2]"));
	 pn1.click();

	 WebElement na=driver.findElement(By.id("no_child"));
	na.sendKeys("1");

	WebElement iframe = driver.findElement(By.id("hotelsearch_iframe"));
    driver.switchTo().frame(iframe);
    driver.findElement(By.id("searchBtn")).click();
  
    WebElement continue1 = driver.findElement(By.xpath("//a[text()='Continue']"));
    continue1.click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    WebElement continue2 = driver.findElement(By.id("own"));
    continue2.click();

    WebElement selectS = driver.findElement(By.name("title"));
    Select s3 = new Select(selectS);
    s3.selectByIndex(1);
    WebElement firstName = driver.findElement(By.id("first_name"));
    firstName.sendKeys("Ananth");
    WebElement lastName = driver.findElement(By.id("last_name"));
    lastName.sendKeys("priyan");
    WebElement phone = driver.findElement(By.name("phone"));
    phone.sendKeys("9003845731");
    WebElement email = driver.findElement(By.name("email"));
    email.sendKeys("ananthpriyanan@gmail.com");
    WebElement nextbtn = driver.findElement(By.id("step1next"));
    nextbtn.click();
    WebElement continue3 = driver.findElement(By.id("high"));
    continue3.click();
 
    WebElement text4 = driver.findElement(By.id("other_request"));
    text4.sendKeys("i need sun set view room");
 
    WebElement next = driver.findElement(By.id("step2next"));
    next.click();
    WebElement next7 = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/div/div/div[1]/div/div[3]/div/div"));
    next7.click();

   WebElement cardno= driver.findElement(By.id("card_no"));
    cardno.sendKeys("5555555555552222");
 
    WebElement cv= driver.findElement(By.id("cvv"));
    cv.sendKeys("654");
 
    WebElement cname= driver.findElement(By.id("card_name"));
    cname.sendKeys("Ananth");
 
    WebElement ctype= driver.findElement(By.xpath(" //*[@id=\"payment_type\"]"));
    ctype.click();

 
    WebElement ctname = driver.findElement(By.xpath("//*[@id=\"payment_type\"]/option[2]"));
    ctname.click();
	  
      WebElement cntype= driver.findElement(By.xpath("//*[@id=\"card_type\"]"));
      cntype.click();
      WebElement ctn = driver.findElement(By.xpath("//*[@id=\"card_type\"]/option[2]"));
      ctn.click();
	  WebElement month= driver.findElement(By.id("card_month"));
	  month.click();
	  WebElement m1= driver.findElement(By.xpath("//*[@id=\"card_month\"]/option[5]"));
	  m1.click();  
	  WebElement year= driver.findElement(By.id("card_year"));
	  year.click();   
	  WebElement y1= driver.findElement(By.xpath("//*[@id=\"card_year\"]/option[8]"));
	  y1.click();
				  
	  WebElement sub= driver.findElement(By.id("submitBtn"));
	  sub.click();
	  
	  WebElement orderid = driver.findElement(By.name("booking-code"));
	  String textid = orderid.getText();
	  System.out.println(textid);
	  
      Thread.sleep(3000);
	  WebElement myacd= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[2]/a"));
	  myacd.click();
	  Thread.sleep(3000);
	  WebElement myac= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div/div/div/div[2]/div/ul/li[2]/div/a[1]"));
	  myac.click();
	  Thread.sleep(3000);
	  WebElement cancel= driver.findElement(By.xpath("//*[@id=\"bookinglist\"]/div[1]/div/div[2]/div/a"));
	  cancel.click();
	  Alert alert2 = driver.switchTo().alert();
	  alert2.accept();
	  System.out.println("Your booking cancelled successfully");
  


}


}
