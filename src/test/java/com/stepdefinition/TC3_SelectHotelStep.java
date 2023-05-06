package com.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;


public class TC3_SelectHotelStep extends BaseClass {
	
	PageObjectManager pom=new PageObjectManager();

	@Then("User select the first hotel name and save the selected hotel name")
	public void userSelectTheFirstHotelNameAndSaveTheSelectedHotelName() {

	
	}

	@When("User perform continue and accept the alert")
	public void userPerformContinueAndAcceptTheAlert() {
	
		pom.getSelectHotelPage().selectHotelWithAccept();
	
	}

	@Then("User should verify success message after selecting hotel {string}")
	public void userShouldVerifySuccessMessageAfterSelectingHotel(String string) {
	
	Assert.assertTrue("Book Hotel Success Message", pom.getSelectHotelPage().bookHotelSuccessMessage().contains(string));
		
	}


	@When("User perform continue and dismiss the alert")
	public void userPerformContinueAndDismissTheAlert() {
	
	 pom.getSelectHotelPage().selectHotelWithDismiss();
	}

	@When("User clicks Name ascending filter button")
	public void userClicksNameAscendingFilterButton() {
	
	 
		
	}

	@Then("User should verify hotel names are displayed in ascending order")
	public void userShouldVerifyHotelNamesAreDisplayedInAscendingOrder() throws InterruptedException {
		
		
		List<String> hotelNamesbefore = pom.getSelectHotelPage().beforSortHotel();
		pom.getSelectHotelPage().clickNameAscending();
		Thread.sleep(3000);
		List<String> afterSortHotelName = pom.getSelectHotelPage().afterSortHotel();
	
	Assert.assertEquals("Names Ascending Success Message",hotelNamesbefore,afterSortHotelName);
	
	
	}

	@When("User unselecting roomtype by unselecting filter button")
	public void userUnselectingRoomtypeByUnselectingFilterButton() {
	
		
	}

	@Then("User should verify all hotels are listed")
	public void userShouldVerifyAllHotelsAreListed() {
	
	}
	
	@When("User clicks prize low to high ascending filter button")
	public void userClicksPrizeLowToHighAscendingFilterButton() {
	
	
	}

	@Then("User should verify hotel prize are displayed in ascending order")
	public void userShouldVerifyHotelPrizeAreDisplayedInAscendingOrder() throws InterruptedException {

		List<String> ascendingPrizeList = pom.getSelectHotelPage().actAscendingPrizeList();
	
		List<String> expAscendingPrizeList = pom.getSelectHotelPage().expAscendingPrizeList();
		
		Assert.assertEquals("Done",expAscendingPrizeList, ascendingPrizeList);
	}
	
	@When("User clicks prize high to low descending filter button")
	public void userClicksPrizeHighToLowDescendingFilterButton() {
	
	
	}
	@Then("User should verify hotel prize are displayed in descending order")
	public void userShouldVerifyHotelPrizeAreDisplayedInDescendingOrder() throws InterruptedException {
	
	List<Integer> expDescendingPrize = pom.getSelectHotelPage().expDescendingPrize();
	pom.getSelectHotelPage().clickBtnHightoLow();
	Thread.sleep(3000);
	List<Integer> actDescendingPrize = pom.getSelectHotelPage().actDescendingPrize();
	
	Assert.assertEquals("Successfully sorted ", expDescendingPrize, actDescendingPrize);
	
	}

	

}
