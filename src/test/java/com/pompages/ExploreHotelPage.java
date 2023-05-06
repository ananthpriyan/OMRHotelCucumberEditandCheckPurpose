package com.pompages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class ExploreHotelPage extends BaseClass {

	public ExploreHotelPage() {

		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//h3[text()='Hotel Booking']")
	private WebElement btnHotelBooking;
	
	

	@FindBy(id = "state")
	private WebElement txtState;

	@FindBy(id = "city")
	private WebElement txtCityname;

	@FindBy(id = "room_type")
	private WebElement txtRoomtype;

	@FindBy(name = "check_in")
	private WebElement txtCheckin;

	@FindBy(name = "check_out")
	private WebElement txtCheckout;

	@FindBy(id = "no_rooms")
	private WebElement txtNumofRooms;

	@FindBy(id = "no_adults")
	private WebElement txtAdults;

	@FindBy(id = "no_child")
	private WebElement txtChilds;

	@FindBy(id = "hotelsearch_iframe")
	private WebElement switchframe;

	// @FindBy(xpath = "//iframe[@class='iframe']")
	// private WebElement frameselect;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//div[text()='Please select state']")
	private WebElement invalidState;
	@FindBy(id = "invalid-city")
	private WebElement invalidCity;
	@FindBy(id = "invalid-check_in")
	private WebElement invalidCheckin;
	@FindBy(id = "invalid-check_out")
	private WebElement invalidCheckout;
	@FindBy(id = "invalid-no_rooms")
	private WebElement invalidNumofRoom;
	@FindBy(id = "invalid-no_adults")
	private WebElement invalidNumofAdults;

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement selectHotel;
	@FindBy(xpath = "//div[@class='col-md-5 hotel-suites']")
	private List<WebElement> hotelsEndsWith;

	public List<WebElement> getHotelsEndsWith() {
		return hotelsEndsWith;
	}

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getInvalidState() {
		return invalidState;
	}

	public WebElement getInvalidCity() {
		return invalidCity;
	}

	public WebElement getInvalidCheckin() {
		return invalidCheckin;
	}

	public WebElement getInvalidCheckout() {
		return invalidCheckout;
	}

	public WebElement getInvalidNumofRoom() {
		return invalidNumofRoom;
	}

	public WebElement getInvalidNumofAdults() {
		return invalidNumofAdults;
	}
	

	
	public WebElement getBtnHotelBooking() {
		return btnHotelBooking;
	}


	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtCityname() {
		return txtCityname;
	}

	public WebElement getTxtRoomtype() {
		return txtRoomtype;
	}

	public WebElement getTxtCheckin() {
		return txtCheckin;
	}

	public WebElement getTxtCheckout() {
		return txtCheckout;
	}

	public WebElement getTxtNumofRooms() {
		return txtNumofRooms;
	}

	public WebElement getTxtAdults() {
		return txtAdults;
	}

	public WebElement getTxtChilds() {
		return txtChilds;
	}

	public WebElement getSwitchframe() {
		return switchframe;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void exploreHotel(String statename, String cityname, String roomtype, String checkin, String checkout,
			String numofrooms, String adults, String childs) throws InterruptedException {

		
		click(getBtnHotelBooking());
		selectByVisibleText(getTxtState(), statename);
		selectByVisibleText(getTxtCityname(), cityname);
		selectByVisibleText(getTxtRoomtype(), roomtype);
		
		
		Boolean contain = roomtype.contains("/");
		Thread.sleep(3000);
		if (contain) {
			
			String[] split = roomtype.split("/");
			
			for (String eachroom : split) {
				
				selectByVisibleText(getTxtRoomtype(), eachroom);
			}
			
		}

	  else {
		  selectByVisibleText(getTxtRoomtype(), roomtype);
		}
		
		//click(getTxtRoomtype());
		//sendKeys(element, data);
		
		sendKeysByJavascript(getTxtCheckin(), checkin);
		sendKeysByJavascript(getTxtCheckout(), checkout);
		selectByVisibleText(getTxtNumofRooms(), numofrooms);
		selectByVisibleText(getTxtAdults(), adults);
		sendKeys(getTxtChilds(), childs);

	}

	public void searchClick() {

		switchToFramesByIdorName(getSwitchframe());
		click(getBtnSearch());
		switchOutFromFrame();
	}

	public List<Boolean> hotelsEndsWith(String roomtype) {

		List<Boolean> listOfHotels = new ArrayList<Boolean>();
		for (WebElement eachHotelelement : getHotelsEndsWith()) {

			String eachHotelName = txtFromWebPage(eachHotelelement);
			
			Boolean isHotelcontains = eachHotelName.contains(roomtype);

			listOfHotels.add(isHotelcontains);
			System.out.println(listOfHotels);
		}

		return listOfHotels;
	}
//	public List<String> hotelsEndsWith() {
//
//		List<String> listOfHotels = new ArrayList<String>();
//		for (WebElement eachHotelelement : getHotelsEndsWith()) {
//
//			String eachHotelName = txtFromWebPage(eachHotelelement);
//
//			listOfHotels.add(eachHotelName);
//			System.out.println(listOfHotels);
//		}
//
//		return listOfHotels;
//	}

	public List<String> exploreHotelSixErrorMsg(String invalidState, String invalidCity, String invalidChechIn,
			String invalidCheckOut, String invalidNoOfRoom, String invalidNoOfAdult) {
		List<String> li = new ArrayList<String>();
		li.add(invalidState);
		li.add(invalidCity);
		li.add(invalidChechIn);
		li.add(invalidCheckOut);
		li.add(invalidNoOfRoom);
		li.add(invalidNoOfAdult);

		return li;
	}

	public List<String> actExploreHotelsixerrormsg() {
		List<String> li = new ArrayList<String>();
		li.add(stateErrorMessage());
		li.add(cityErrorMessage());
		li.add(checkInErrorMessage());
		li.add(checkOutErrorMessage());
		li.add(invalidRoomErrorMessage());
		li.add(invalidNumofAdultsErrorMsg());

		return li;
	}

	public String stateErrorMessage() {

		String stateError = txtFromWebPage(getInvalidState());
		return stateError;

	}

	public String cityErrorMessage() {
		String cityerror = txtfromWebpage(getInvalidCity());
		return cityerror;

	}

	public String checkInErrorMessage() {

		return txtFromWebPage(getInvalidCheckin());
	}

	public String checkOutErrorMessage() {

		return txtFromWebPage(getInvalidCheckout());
	}

	public String invalidRoomErrorMessage() {

		return txtFromWebPage(getInvalidNumofRoom());

	}

	public String invalidNumofAdultsErrorMsg() {

		return txtFromWebPage(getInvalidNumofAdults());

	}

	public String successSelectHotel() {
		return txtFromWebPage(getSelectHotel());

	}
	public void exploreHotelMultyRoomCheck(String statename, String cityname, String roomtype,String roomtype2,String roomtype3, String checkin, String checkout,
			String numofrooms, String adults, String childs){

		selectByVisibleText(getTxtState(), statename);
		selectByVisibleText(getTxtCityname(), cityname);
		selectByVisibleText(getTxtRoomtype(), roomtype);
		selectByVisibleText(getTxtRoomtype(), roomtype2);
		selectByVisibleText(getTxtRoomtype(), roomtype3);
		sendKeysByJavascript(getTxtCheckin(), checkin);
		sendKeysByJavascript(getTxtCheckout(), checkout);
		selectByVisibleText(getTxtNumofRooms(), numofrooms);
		selectByVisibleText(getTxtAdults(), adults);
		sendKeys(getTxtChilds(), childs);

	}
}
