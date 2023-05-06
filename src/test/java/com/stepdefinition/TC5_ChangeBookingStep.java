package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC5_ChangeBookingStep extends BaseClass {

	PageObjectManager pom=new PageObjectManager();
	String saveId  =  pom.getBookHotelPage().bookingId();             
	
	
	
	
	@When("User navigate into my bookings and search order id")
	public void userNavigateIntoMyBookingsAndSearchOrderId() {
	
	
		pom.getMyBookingsPage().navigateToMybooking();
		
		pom.getMyBookingsPage().sendBookingId(saveId);
	}

	
	
	@Then("User should verify order id and hotel name are same")
	public void userShouldVerifyOrderIdAndHotelNameAreSame() {
	
	
	}

	@Then("User change the booking {string}")
	public void userChangeTheBooking(String newDate) {
	//pom.getMyBookingsPage().updateBooking(saveId);
	pom.getMyBookingsPage().editBookingId();
	pom.getMyBookingsPage().newDateUpdate(newDate);
	}

	@Then("User should verify the success message after update {string}")
	public void userShouldVerifyTheSuccessMessageAfterUpdate(String editMsg) {
	
	Assert.assertTrue("Update Success Message", pom.getMyBookingsPage().txtEditSuccessMessage().contains(editMsg));
	}

}
