package com.pompages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
	
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="email")
private WebElement txtUser;

@FindBy(id="pass")
private WebElement txtPass;

@FindBy(xpath="//button[@value='login']")
private WebElement btnLogin;

@FindBy(xpath="//b[contains(text(),'Invalid Login details')] ")
private WebElement txtErrorMsgValidUserinvalidpass;

@FindBy(xpath="//b[contains(text(),'User does not')] ")
private WebElement txtErrMsgInvalidUser;

@FindBy(xpath="//a[contains(text(),'Welcome')] ")
private WebElement txtLoginSuccess;



public WebElement getTxtLoginSuccess() {
	return txtLoginSuccess;
}

public WebElement getTxtErrorMsgValidUserinvalidpass() {
	return txtErrorMsgValidUserinvalidpass;
}

public WebElement getTxtErrMsgInvalidUser() {
	return txtErrMsgInvalidUser;
}
public WebElement getTxtUser() {
	return txtUser;
}
public WebElement getTxtPass() {
	return txtPass;
}
public WebElement getBtnLogin() {
	return btnLogin;
}


 public void login(String user, String pass) {
	 
	 
	sendKeys(getTxtUser(), user);
	sendKeys(getTxtPass(), pass);
	click(getBtnLogin());

}
 
 public String loginSuccessMessage() {
	
	 String textSuccess = txtFromWebPage(getTxtLoginSuccess());
	 return textSuccess;

}
 public String loginErrorMessage() {
	
      String text = txtFromWebPage(getTxtErrMsgInvalidUser());
      return text;
}
 
  public void loginWithRobotClass(String user, String pass) throws AWTException {
	
	  Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		
		 sendKeys(getTxtUser(), user);
		 
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		
		 
		 sendKeys(getTxtPass(), pass);
		
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER); 

}



	

	
	
	
}
