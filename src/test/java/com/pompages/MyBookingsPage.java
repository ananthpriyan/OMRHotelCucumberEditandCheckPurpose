package com.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class MyBookingsPage extends BaseClass {
	
	
	public MyBookingsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Welcome')] ")
	private WebElement clcUser;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement btnMyAccount;
	
	@FindBy(xpath="//button[text()='My Booking']")
	private WebElement myBookings;
	@FindBy(xpath="//input[@class='form-control w-50 d-inline-block']")
	private WebElement searchOrderId;
	@FindBy(xpath="//button[@class='edit btn filter_btn']")
	private WebElement editOrderId;
	
	
	@FindBy(name="check_in")
	private WebElement editDate;
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement btnConfirm;
	@FindBy(xpath="//li[text()='Booking updated successfully']")
	private WebElement editSuccessMessage;
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(xpath="//li[text()='Your booking cancelled successfully']")
	private WebElement cancelConfirmMeesage; 
	
	
	public WebElement getEditSuccessMessage() {
		return editSuccessMessage;
	}
	public WebElement getCancelConfirmMeesage() {
		return cancelConfirmMeesage;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public WebElement getEditDate() {
		return editDate;
	}
	public WebElement getBtnConfirm() {
		return btnConfirm;
	}
	public WebElement getMyBookings() {
		return myBookings;
	}
	public WebElement getSearchOrderId() {
		return searchOrderId;
	}
	public WebElement getEditOrderId() {
		return editOrderId;
	}

	public WebElement getClcUser() {
		return clcUser;
	}
	public WebElement getBtnMyAccount() {
		return btnMyAccount;
	}

	public void goTomyAccount() {
		
		click(getClcUser());
		click(getBtnMyAccount());

	}
	
	
	public void navigateToMybooking() {
		
		click(getMyBookings());
	}
	public void sendBookingId(String orderId) {
		
		sendKeys(getSearchOrderId(), orderId);
		
	}
	
	public void editBookingId() {
		
		click(getEditOrderId());

	}
	public void newDateUpdate(String newDate) {
		
		sendKeysByJavascript(getEditDate(), newDate);
		click(getBtnConfirm());	

	}
	
	public String txtEditSuccessMessage() {
		
		return txtFromWebPage(getEditSuccessMessage());

	}
	
	public void cancelBooking() {

		click(getBtnCancel());
        alertAccept();
	}
	
       public String cancelSuccessMessage() {
		
    	  return txtFromWebPage(getCancelConfirmMeesage()); 
	}
}
