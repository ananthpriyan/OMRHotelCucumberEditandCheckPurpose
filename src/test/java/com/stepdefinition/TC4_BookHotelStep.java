package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User add guest details {string},{string},{string},{string} and {string}")
	public void userAddGuestDetailsAnd(String salutation, String firstname, String lastname, String phone,
			String email) {

		pom.getBookHotelPage().addGuestdetails(salutation, firstname, lastname, phone, email);

	}

	@When("User enters payment details proceed with card type {string}")
	public void userEntersPaymentDetailsProceedWithCardType(String cardtype,
			io.cucumber.datatable.DataTable dataTable) {
        pom.getBookHotelPage().clickFirstnext();
        pom.getBookHotelPage().clickSecondnext();
		pom.getBookHotelPage().paymentOptionByCard(cardtype, dataTable);
		
		pom.getBookHotelPage().clickSubmit();

	}

	@Then("User should verify after book hotel confirmation message {string} and save the order id")
	public void userShouldVerifyAfterBookHotelConfirmationMessageAndSaveTheOrderId(String expected) {

		Assert.assertEquals("Booking success message", expected, pom.getBookHotelPage().bookingConfirmMessage());
		pom.getBookHotelPage().bookingId();
	}

	@Then("User should verify whether selected hotel is booked")
	public void userShouldVerifyWhetherSelectedHotelIsBooked() {
	}

	@When("User enter UPI ID {string}")
	public void userEnterUPIID(String upiId) {

		pom.getBookHotelPage().paymentOptionUpiId(upiId);
	}

	@Then("User should verify UPI error message {string}")
	public void userShouldVerifyUPIErrorMessage(String expect) {

		Assert.assertEquals("Invalid Upi id", expect, pom.getBookHotelPage().txtErrorUpiFromWebpage());
	}

	@Then("User should verify card error message {string}")
	public void userShouldVerifyCardErrorMessage(String string) {

		Assert.assertTrue("Invalid Card Message", pom.getBookHotelPage().txtCardErrorMessage().contains(string));

	}

	@Then("User clicks next button without giving guest details")
	public void userClicksNextButtonWithoutGivingGuestDetails() {
		pom.getBookHotelPage().clickFirstnext();

	}

	@Then("User should verify all error message displayed {string},{string},{string},{string},{string},{string}")
	public void userShouldVerifyAllErrorMessageDisplayed(String string, String string2, String string3, String string4,
			String string5, String string6) {
		
		Assert.assertTrue("Success",pom.getBookHotelPage().invalidBookingfor().contains(string));
		Assert.assertTrue("Success",pom.getBookHotelPage().invalidTitle().contains(string2));
		Assert.assertTrue("Success",pom.getBookHotelPage().inavalidFirstname().contains(string3));
		Assert.assertTrue("Success",pom.getBookHotelPage().invalidLastname().contains(string4));
		Assert.assertTrue("Success",pom.getBookHotelPage().invalidMobile().contains(string5));
		Assert.assertTrue("Success",pom.getBookHotelPage().invalidEmail().contains(string6));
		
		

	}
	
	
	@When("User enters GST details and any one Special request {string},{string},{string}")
	public void userEntersGSTDetailsAndAnyOneSpecialRequest(String gstNum, String companyName, String companyAddress) {
	
		pom.getBookHotelPage().addGstDetails(gstNum, companyName, companyAddress);
		
	
	}
	

}
