package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	// 1

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	public String getProjectPath() {

		String path = System.getProperty("user.dir");
		return path;

	}

	public String getPropertyfileValue(String key)  {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.Properties"));
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	public static void browserConfigChrome() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// 2
	public static void openUrl(String url) {
		driver.get(url);
	}

	// 3
	public static void maximizeWindow() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// 4
	public String printTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 5
	public String printCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 6
	public WebElement locateById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}

	// 7
	public WebElement locateByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	// 8
	public WebElement locateByXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	// 9
	public WebElement locateBytagName(String tagname) {
		WebElement findElement = driver.findElement(By.tagName(tagname));
		return findElement;
	}

	// 10
	public WebElement locateByLinktext(String linkText) {

		WebElement findElement = driver.findElement(By.linkText(linkText));
		return findElement;
	}

	// 11
	public WebElement locateByPartialLinktext(String partialLinkText) {
		WebElement findElement = driver.findElement(By.partialLinkText(partialLinkText));
		return findElement;
	}

	// 12
	public WebElement locateByCssSelector(String cssSelector) {
		WebElement findElement = driver.findElement(By.cssSelector(cssSelector));
		return findElement;
	}

	// 13
	public WebElement locateByClassName(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;
	}
	// 14
	// SendKeys

	public static void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 15
	public void sendKeysByJavascript(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	// 16.insertvalue.textbox using java script
	public void inserttextboxjs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	// 16
	public String printText(WebElement element) {

		String text = element.getText();
		return text;
	}

	// 17
	public String getAttribute(WebElement element, String value) {

		String attribute = element.getAttribute(value);
		return attribute;

	}

	// 18
	public void getAllOptionsBytext(WebElement element) {

		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement ele = options.get(i);
			String text = ele.getText();
			System.out.println(text);

		}
		// return text;
	}

	// 19 //String value
	public void getAllOptionsByAttribute(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for (WebElement webElement : options) {
			String attribute = webElement.getAttribute("value");
			System.out.println(attribute);
		}
	}

	// 20
	// Click
	public void click(WebElement element) {
		element.click();
	}

	// 21
	public void clickByJs(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// 22
	public void scrollDownByjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 23
	public void scrollUpByjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 24
	public static void closeBrowser() {
		driver.close();
	}

	// 25
	public void quitBrowser() {
		driver.quit();
	}

	// 26
	// Actions
	public void mouseOverActions(WebElement element) {
		Actions acc = new Actions(driver);
		acc.moveToElement(element).perform();

	}

	// 27
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(source, target).perform();

	}

	// 28
	public void rightClick() {
		Actions acc = new Actions(driver);
		acc.contextClick().perform();
	}

	// 29
	public void doubleClick() {
		Actions acc = new Actions(driver);
		acc.doubleClick().perform();
	}

	// 30
	// Navigation
	public void refresh() {

		driver.navigate().refresh();
	}

	// 31
	public void navigateForward() {
		driver.navigate().forward();
	}

	// 32
	public void navigateBack() {
		driver.navigate().back();
	}

	// 33
	public void lounchBrowserBynavigate(String url) {
		driver.navigate().to(url);
	}

	// 34
	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// 35
	public void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// 36
	public void alerttextInput(String value) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(value);
	}

	// 37
	public void alertGetText() {
		Alert al = driver.switchTo().alert();
		al.getText();
	}

	// 38
	public String getParentWindowId() {
		String parId = driver.getWindowHandle();
		return parId;
	}

	// 39
	public Set<String> getAllWindowsId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// 40
	public void SwitchToWindow(String id) {
		driver.switchTo().window(id);
	}

	// 41
	// Frames
	public void switchToFramesByIdorName(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchtoFrambyWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	// 42
	public void switchToFramesByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 43
	public void switchToPreviousFrame() {
		driver.switchTo().parentFrame();
	}

	// 44
	public void switchToMainWindow() {
		driver.switchTo().defaultContent();
	}

	// 45
	// Select class
	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	// 46
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// 47
	public void selectByAttribute(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void clearText(WebElement element) { // we can use this or below sendkeys method
		element.clear();
	}

	// Screenshot
	public void takescreenShot(String locationToStore) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(locationToStore);
		FileUtils.copyFile(source, dest);
	}

	public void clearTextBox(WebElement element) {
		element.sendKeys("");
	}

	public void handleAlertWithSendKeys(String name) {

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
	}

	public static String txtfromWebpage(WebElement element) {

		return element.getText();

	}

	public String txtFromWebPage(WebElement element) {

		// String text = element.getText();
		// return text;
		return element.getText();

	}

	public void switchOutFromFrame() {

		driver.switchTo().defaultContent();
		
	}
	
	public byte[] screenShot() {
	
		TakesScreenshot  screenShot= (TakesScreenshot)driver;
		byte[] screenshotAs = screenShot.getScreenshotAs(OutputType.BYTES);
		
		return screenshotAs;

	}

}
