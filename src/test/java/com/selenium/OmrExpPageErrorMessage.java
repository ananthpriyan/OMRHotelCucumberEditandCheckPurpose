package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrExpPageErrorMessage {
	
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
	
	WebElement iframe = driver.findElement(By.id("hotelsearch_iframe"));
	driver.switchTo().frame(iframe);
	WebElement btnSearch = driver.findElement(By.xpath("//button[text()='Search']"));
	 
	btnSearch.click();
	
	driver.switchTo().defaultContent();
	WebElement state1 = driver.findElement(By.id("invalid-state"));
	String text = state1.getText();
	System.out.println(text);
	
	WebElement city = driver.findElement(By.id("invalid-city"));
	String errorcity = city.getText();
	System.out.println(errorcity);
	
	WebElement invalidcheckin = driver.findElement(By.id("invalid-check_in"));
	String errordatein = invalidcheckin.getText();
	System.out.println(errordatein);
	
	WebElement invalidcheckout = driver.findElement(By.id("invalid-check_out"));
	String errordateout = invalidcheckout.getText();
	System.out.println(errordateout);
	
	WebElement invalidroom = driver.findElement(By.id("invalid-no_rooms"));
	String room = invalidroom.getText();
	System.out.println(room);
	
	WebElement adults = driver.findElement(By.id("invalid-no_adults"));
	String aderror = adults.getText();
	System.out.println(aderror);
	
	
    }

}
