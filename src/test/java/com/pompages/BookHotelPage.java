package com.pompages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "own")
	private WebElement btnbookingoption;

	@FindBy(id = "user_title")
	private WebElement salution;

	@FindBy(id = "first_name")
	private WebElement txtfirstname;

	@FindBy(id = "last_name")
	private WebElement txtlastname;

	@FindBy(id = "user_phone")
	private WebElement txtphone;

	@FindBy(id = "user_email")
	private WebElement txtemail;

	@FindBy(id = "step1next")
	private WebElement btnnext1;

	@FindBy(id = "step2next")
	private WebElement btnnext2;

	@FindBy(xpath = "//div[@class='credit-card pm']")
	private WebElement clccard;

	@FindBy(id = "payment_type")
	private WebElement CardType;

	@FindBy(id = "card_type")
	private WebElement selectCard;

	@FindBy(id = "card_no")
	private WebElement cardNumber;

	@FindBy(id = "card_name")
	private WebElement nameOnCard;

	@FindBy(id = "card_month")
	private WebElement cardMonth;

	@FindBy(id = "card_year")
	private WebElement cardYear;

	@FindBy(id = "cvv")
	private WebElement cardCVV;

	@FindBy(id = "submitBtn")
	private WebElement btnSubmit;

	// Booking Confirmation Page WebElement
	@FindBy(name = "booking-code")
	private WebElement bookingID;

	@FindBy(xpath = "//h2[contains(text(), 'Booking')]")
	private WebElement bookingcofirmationMessage;

	@FindBy(id = "invalid-booking_for")
	private WebElement invalidBookingfor;

	@FindBy(id = "invalid-title")
	private WebElement invalidTitle;

	@FindBy(id = "invalid-first_name")
	private WebElement invalidFirstname;

	@FindBy(id = "invalid-last_name")
	private WebElement invalidLastname;

	@FindBy(id = "invalid-phone")
	private WebElement invalidMobilNum;

	@FindBy(id = "invalid-email")
	private WebElement invalidEmail;

	@FindBy(xpath = "//div[@class='upi pm']")
	private WebElement clcUpiId;

	@FindBy(id = "upi_id")
	private WebElement txtUpiId;

	@FindBy(id = "invalid-upi")
	private WebElement txtUpiErrorMsg;

	@FindBy(id = "invalid-card_no")
	private WebElement invalidCardmsg;
	
	
	
	@FindBy(id = "gst")
	private WebElement btnGst;

	@FindBy(id = "gst_registration")
	private WebElement txtRegistrationNum;

	@FindBy(id ="company_name")
	private WebElement txtcompany;

	@FindBy(id = "company_address")
	private WebElement txtCompanyAddress;
	
	@FindBy(id = "high")
	private WebElement btnHighfloor;
	

	public WebElement getBtnHighfloor() {
		return btnHighfloor;
	}

	public WebElement getBtnGst() {
		return btnGst;
	}

	public WebElement getTxtRegistrationNum() {
		return txtRegistrationNum;
	}

	public WebElement getTxtcompany() {
		return txtcompany;
	}

	public WebElement getTxtCompanyAddress() {
		return txtCompanyAddress;
	}

	public WebElement getInvalidCardmsg() {
		return invalidCardmsg;
	}

	public String txtCardErrorMessage() {
		return txtFromWebPage(getInvalidCardmsg());

	}

	public WebElement getTxtUpiErrorMsg() {
		return txtUpiErrorMsg;
	}

	public WebElement getClcUpiId() {
		return clcUpiId;
	}

	public WebElement getTxtUpiId() {
		return txtUpiId;
	}

	public WebElement getBookingID() {
		return bookingID;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getNameOnCard() {
		return nameOnCard;
	}

	public WebElement getCardMonth() {
		return cardMonth;
	}

	public WebElement getCardYear() {
		return cardYear;
	}

	public WebElement getCardCVV() {
		return cardCVV;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBtnbookingoption() {
		return btnbookingoption;
	}

	public WebElement getSalution() {
		return salution;
	}

	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtphone() {
		return txtphone;
	}

	public WebElement getTxtemail() {
		return txtemail;
	}

	public WebElement getBtnnext1() {
		return btnnext1;
	}

	public WebElement getBtnnext2() {
		return btnnext2;
	}

	public WebElement getClccard() {
		return clccard;
	}

	public WebElement getCardType() {
		return CardType;
	}

	public WebElement getSelectCard() {
		return selectCard;
	}

	public WebElement getInvalidBookingfor() {
		return invalidBookingfor;
	}

	public String invalidBookingfor() {

		return txtFromWebPage(getInvalidBookingfor());

	}

	public WebElement getInvalidTitle() {
		return invalidTitle;
	}

	public String invalidTitle() {

		String invalidTit = txtFromWebPage(getInvalidTitle());
		return invalidTit;

	}

	public WebElement getInvalidFirstname() {
		return invalidFirstname;
	}

	public String inavalidFirstname() {
		return txtFromWebPage(getInvalidFirstname());

	}

	public WebElement getInvalidLastname() {
		return invalidLastname;
	}

	public String invalidLastname() {

		return txtFromWebPage(getInvalidLastname());

	}

	public WebElement getInvalidMobilNum() {
		return invalidMobilNum;
	}

	public String invalidMobile() {

		return txtFromWebPage(getInvalidMobilNum());
	}

	public WebElement getInvalidEmail() {
		return invalidEmail;
	}

	public String invalidEmail() {

		return txtFromWebPage(getInvalidEmail());

	}

	public WebElement getBookingcofirmationMessage() {
		return bookingcofirmationMessage;

	}

	public void addGuestdetails(String salutation, String firstname, String lastname, String phone, String email) {

		click(getBtnbookingoption());
		selectByVisibleText(getSalution(), salutation);
		sendKeys(getTxtfirstname(), firstname);
		sendKeys(getTxtlastname(), lastname);
		sendKeys(getTxtphone(), phone);
		sendKeys(getTxtemail(), email);
		
		

	}
public void clickFirstnext() {
	click(getBtnnext1());

}
public void clickSecondnext() {
	click(getBtnnext2());

}
public void clickSubmit() {

	click(getBtnSubmit());
}
	
	public void paymentOptionByCard(String cardtype, DataTable datatable) {

		click(getClccard());
		selectByVisibleText(getCardType(), cardtype);

		List<Map<String, String>> card = datatable.asMaps();
		Map<String, String> map = card.get(0);
		String visaorelse = map.get("selectcardtype");
		String cardnum = map.get("entercardnum");
		String nameoncard = map.get("enternameoncard");
		String cardmonth = map.get("selectmonth");
		String cardyear = map.get("selectyear");
		String cvv = map.get("cardcvv");

		selectByVisibleText(getSelectCard(), visaorelse);
		sendKeys(getCardNumber(), cardnum);
		sendKeys(getNameOnCard(), nameoncard);
		selectByVisibleText(getCardMonth(), cardmonth);
		selectByVisibleText(getCardYear(), cardyear);
		sendKeys(getCardCVV(), cvv);

		

	}

	public String bookingId() {

		String bookId = txtFromWebPage(getBookingID());
		CharSequence sequenceBookId = bookId.subSequence(1, 11);

		String bookid = (String) sequenceBookId;
		return bookid;
	}

	public CharSequence bookingConfirmMessage() {

		String txtconfirmbook = txtFromWebPage(getBookingcofirmationMessage());
		CharSequence message = txtconfirmbook.subSequence(12, 32);
		return message;

	}

	public void paymentOptionUpiId(String upiId) {

		
		click(getClcUpiId());
		sendKeys(getTxtUpiId(), upiId);
		click(getBtnSubmit());

	}

	public String txtErrorUpiFromWebpage() {
		return txtFromWebPage(getTxtUpiErrorMsg());

	}


	public void addGstDetails(String gstNum,String companyName, String companyAddress) {

		click(getBtnGst());
		sendKeys(getTxtRegistrationNum(), gstNum);
		sendKeys(getTxtcompany(), companyName);
		sendKeys(getTxtCompanyAddress(), companyAddress);
		clickFirstnext();
		click(getBtnHighfloor());
		clickSecondnext();
		
		
	}
}
