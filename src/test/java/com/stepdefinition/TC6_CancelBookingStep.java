package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC6_CancelBookingStep extends BaseClass {
	
	PageObjectManager pom= new PageObjectManager();
//	String bookingId = pom.getBookHotelPage().bookingId();            
	                   
	
	@Then("User cancel the order id")
	public void userCancelTheOrderId() {
       // pom.getMyBookingsPage().goTomyAccount();
        
		pom.getMyBookingsPage().cancelBooking();
	
	}
	@Then("User should verify the success message after cancel {string}")
	public void userShouldVerifyTheSuccessMessageAfterCancel(String string) {
	
	Assert.assertTrue("Cancel Success Message", pom.getMyBookingsPage().cancelSuccessMessage().contains(string));
	}


}
