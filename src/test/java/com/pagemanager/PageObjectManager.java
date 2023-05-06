package com.pagemanager;

import com.baseclass.BaseClass;
import com.pompages.BookHotelPage;
import com.pompages.ExploreHotelPage;
import com.pompages.LoginPage;
import com.pompages.MyBookingsPage;
import com.pompages.SelectHotelPage;

public class PageObjectManager extends BaseClass {
	
	
	private LoginPage loginPage;
	private ExploreHotelPage exploreHotelPage; 
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private MyBookingsPage myBookingsPage;
	
	
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage =new LoginPage():loginPage;
	}
	
	
	public ExploreHotelPage getExploreHotelPage() {
		return (exploreHotelPage==null)? exploreHotelPage=new ExploreHotelPage():exploreHotelPage;
	}
	
	
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)? selectHotelPage=new SelectHotelPage():selectHotelPage;
	}
	
	
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)? bookHotelPage=new BookHotelPage():bookHotelPage;
	}
	
	public MyBookingsPage getMyBookingsPage() {
		return (myBookingsPage==null)? myBookingsPage =new MyBookingsPage():myBookingsPage;
	}
	
	
	
	

}
