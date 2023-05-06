package com.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_ExploreHotelStep extends BaseClass {

	PageObjectManager pom=new PageObjectManager();
	
	@Then("User perform {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userPerformAnd(String state, String city, String roomtype, String checkin, String checkout,
			String numofrooms, String adults, String childs) throws InterruptedException {
	
		pom.getExploreHotelPage().exploreHotel(state, city, roomtype, checkin, checkout, numofrooms, adults, childs);
		
		pom.getExploreHotelPage().searchClick();
		
	}

	@Then("User should verify success message after search hotel {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotel(String select) {
	
		Assert.assertTrue("Success Message",pom.getExploreHotelPage().successSelectHotel().contains(select));
	}

	@Then("User should verify success message after search hotel all roomtypes are displayed {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotelAllRoomtypesAreDisplayed(String string) {
	
	}

	@Then("User should verify after search hotel all hotel name ends with {string}")
	public void userShouldVerifyAfterSearchHotelAllHotelNameEndsWith(String roomtype) {

		
		//List<String> hotelsEndsWith = pom.getExploreHotelPage().hotelsEndsWith();
		List<Boolean> hotelsEndsWith = pom.getExploreHotelPage().hotelsEndsWith(roomtype);
	Assert.assertTrue("Success message ends with", hotelsEndsWith.contains(true));
		
	}

	@Then("User perform search without entering any data")
	public void userPerformSearchWithoutEnteringAnyData() throws InterruptedException {
	
		pom.getExploreHotelPage().searchClick();
	}

	@Then("User should verify error messages displayed in six fields {string},{string},{string},{string},{string},{string}")
	public void userShouldVerifyErrorMessagesDisplayedInSixFields(String invalidState, String invalidCity, String invalidCheckIn,
			String invalidCheckOut, String invalidNoOfRoom, String invalidNoOfAdult) {

	Assert.assertTrue("State Error", pom.getExploreHotelPage().stateErrorMessage().contains(invalidState));	
	Assert.assertTrue("City Error Message", pom.getExploreHotelPage().cityErrorMessage().contains(invalidCity));
	Assert.assertTrue("CheckIn Error Message", pom.getExploreHotelPage().checkInErrorMessage().contains(invalidCheckIn));
	Assert.assertTrue("CheckOutError Message", pom.getExploreHotelPage().checkOutErrorMessage().contains(invalidCheckOut));
	Assert.assertTrue("NumofRoom Error Message", pom.getExploreHotelPage().invalidRoomErrorMessage().contains(invalidNoOfRoom));
	Assert.assertTrue("NumofAdults Error Message", pom.getExploreHotelPage().invalidNumofAdultsErrorMsg().contains(invalidNoOfAdult));
		
		
		
		
 // Assert.assertEquals("Six Error Message",pom.getExploreHotelPage().exploreHotelSixErrorMsg(invalidState, invalidCity, invalidCheckIn, invalidCheckOut, invalidNoOfRoom, invalidNoOfAdult), pom.getExploreHotelPage().actExploreHotelsixerrormsg());
	}
	
	@Then("User perform {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userPerformAnd(String state, String cityname, String roomtype, String roomtype2, String roomtype3, String checkin, String checkout, String numofrooms, String adults, String childs) {

	pom.getExploreHotelPage().exploreHotelMultyRoomCheck(state, cityname, roomtype, roomtype2, roomtype3, checkin, checkout, numofrooms, adults, childs);
	pom.getExploreHotelPage().searchClick();
	}

}
