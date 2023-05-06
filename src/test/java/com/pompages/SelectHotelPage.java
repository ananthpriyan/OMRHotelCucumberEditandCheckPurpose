package com.pompages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Price low to high']")
	private WebElement filterLowToHigh;

	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement filterHighToLow;

	@FindBy(xpath = "//label[text()='Name Ascending']")
	private WebElement filterNameascending;

	@FindBy(xpath = "//label[text()='Name Descending']")
	private WebElement filterNamedescending;

	@FindBy(className = "total-prize")
	private List<WebElement> sortedprice;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text()='Standard']")
	private WebElement filterStandard;

	@FindBy(xpath = "//label[text()='Deluxe']")
	private WebElement filterDelux;

	@FindBy(xpath = "//label[text()='Suite']")
	private WebElement filterSuite;

	@FindBy(xpath = "//label[text()='Luxury']")
	private WebElement filterLuxury;

	@FindBy(xpath = "//label[text()='Studio']")
	private WebElement filterStudio;

	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> sortedHotelnames;

	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement bookSuccessMessage;

	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> sortedPrizeList;

	public List<WebElement> getSortedPrizeList() {
		return sortedPrizeList;
	}

	public WebElement getBookSuccessMessage() {
		return bookSuccessMessage;
	}

	public String bookHotelSuccessMessage() {

		return txtFromWebPage(getBookSuccessMessage());

	}

	public List<WebElement> getSortedHotelnames() {
		return sortedHotelnames;
	}

	public List<WebElement> getSortedprice() {
		return sortedprice;
	}

	public WebElement getFilterLowToHigh() {
		return filterLowToHigh;
	}

	public WebElement getFilterHighToLow() {
		return filterHighToLow;
	}

	public WebElement getFilterNameascending() {
		return filterNameascending;
	}

	public WebElement getFilterNamedescending() {
		return filterNamedescending;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getFilterStandard() {
		return filterStandard;
	}

	public WebElement getFilterDelux() {
		return filterDelux;
	}

	public WebElement getFilterSuite() {
		return filterSuite;
	}

	public WebElement getFilterLuxury() {
		return filterLuxury;
	}

	public WebElement getFilterStudio() {
		return filterStudio;
	}

	public void selectHotelWithAccept() {

		click(getBtnContinue());
		alertAccept();

	}

	public void selectHotelWithDismiss() {
		click(getBtnContinue());
		alertDismiss();

	}

	public void clickNameAscending() {

		click(getFilterNameascending());

	}

	public boolean verifysortHotelNameAscending() {

		List<String> beforeSort = new ArrayList<String>();
		for (WebElement hotelsEle : getSortedHotelnames()) {
			String hotelNames = txtFromWebPage(hotelsEle);
			beforeSort.add(hotelNames);
			System.out.println(beforeSort);
		}

		List<String> afterSort = new ArrayList<String>();
		afterSort.addAll(beforeSort);
		Collections.sort(afterSort);
		System.out.println(afterSort);
		boolean notEquals = beforeSort.equals(afterSort);
		return notEquals;

	}

	public List<String> beforSortHotel() {
		List<String> beforSort = new ArrayList<String>();
		for (WebElement hotelEle : getSortedHotelnames()) {

			String before = txtFromWebPage(hotelEle);
			beforSort.add(before);
			System.out.println(beforSort);
			Collections.sort(beforSort);
		}
		return beforSort;

	}

	public List<String> afterSortHotel() {
		List<String> li = new ArrayList<String>();

		for (WebElement afterSort : getSortedHotelnames()) {

			String after = txtFromWebPage(afterSort);
			li.add(after);
			System.out.println(li);
		}
		return li;
	}

	public Boolean unSelectingRoomtype() {

		Boolean isRoomTypecount = false;

		List<WebElement> beforeCount = getSortedHotelnames();
		int before = beforeCount.size();
		click(getFilterDelux());

		List<WebElement> aftercount = getSortedHotelnames();
		int after = aftercount.size();

		if (before != after) {

			isRoomTypecount = true;
		}
		return isRoomTypecount;

	}

	public List<String> expAscendingPrizeList() throws InterruptedException {

		List<String> listPrize = new ArrayList<>();

		for (WebElement webElement : getSortedPrizeList()) {

			String prizeFromWebPage = txtFromWebPage(webElement);

			listPrize.add(prizeFromWebPage);
			System.out.println(listPrize);
			Thread.sleep(3000);
			Collections.sort(listPrize);

		}
		return listPrize;

	}

	public List<String> actAscendingPrizeList() throws InterruptedException {

		click(getFilterLowToHigh());
		Thread.sleep(3000);
		List<String> li = new ArrayList<>();

		for (WebElement eachelement : getSortedPrizeList()) {

			String prize = txtFromWebPage(eachelement);
			li.add(prize);
		}
		return li;
	}

	public List<Integer> expDescendingPrize() {

		List<Integer> listPrize = new ArrayList<>();

		for (WebElement webElement : getSortedPrizeList()) {

			String prize = txtFromWebPage(webElement);

			String replaceAll = prize.replace("$ ", "");
			String replaceAll2 = replaceAll.replace(",", "");
			System.out.println(replaceAll2);
			int parseInt = Integer.parseInt(replaceAll2);
			listPrize.add(parseInt);
			Collections.sort(listPrize);
			System.out.println("aftersortlistPrize:" + listPrize);
			Collections.reverse(listPrize);
			System.out.println("afterreverselistPrize:" + listPrize);
		}
		return listPrize;
	}
	public void clickBtnHightoLow() {
		click(getFilterHighToLow());
	}
	public List<Integer> actDescendingPrize() {
		List<Integer> listPrize = new ArrayList<>();
		for (WebElement eachElement : getSortedPrizeList()) {
			String prizeString = txtFromWebPage(eachElement);
			String replaceAll = prizeString.replace("$ ", "");
			String replaceAll2 = replaceAll.replace(",", "");

			int prizeInt = Integer.parseInt(replaceAll2);
			listPrize.add(prizeInt);
			System.out.println(listPrize);
		}
		return listPrize;

	}

}
