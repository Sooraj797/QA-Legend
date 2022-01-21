package com.buffaloCart.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffaloCart.utils.PageUtility;

public class EventPage {
	
	WebDriver driver;
	
	public EventPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	boolean b;
	ArrayList<WebElement> list = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//span[text()='Events']//parent::a")
	WebElement goToEvents;
	@FindBy(xpath = "(//a[@title='Add event'])[2]")
	WebElement addEvent;
	
	@FindBy(id = "title")
	WebElement title;
	@FindBy(id = "description")
	WebElement description;
	@FindBy(id = "start_date")
	WebElement startDate;
	@FindBy(id = "start_time")
	WebElement startTime;
	@FindBy(id = "end_date")
	WebElement endDate;
	@FindBy(id = "end_time")
	WebElement endTime;
	@FindBy(id = "location")
	WebElement location;
	@FindBy(id = "s2id_clients_dropdown")
	WebElement clientSelectionDropdown;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active select2-drop-above']//parent::div//child::input")
	WebElement clientField;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::div//following-sibling::ul")
	WebElement clientClickField;
	
	@FindBy(id = "only_me")
	WebElement onlyMe;
	@FindBy(id = "share_with_all")
	WebElement shareWithAll;
	@FindBy(id = "share_with_specific_radio_button")
	WebElement shareWithSpecific;
	@FindBy(id = "s2id_share_with_specific")
	WebElement membersShared;
	
	@FindBy(id="event_recurring")
	WebElement eventRecurring;
	@FindBy(id = "repeat_every")
	WebElement repeatTimes;
	
	@FindBy(id = "s2id_repeat_type")
	WebElement repeatDurationDropdown;
	@FindBy(id = "s2id_clients_dropdown")
	WebElement repeatDuration;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::div//following-sibling::ul)[2]")
	WebElement repeatClickDuration;
	
	@FindBy(id = "no_of_cycles")
	WebElement repeatCycles;
	@FindBy(xpath = "(//div[@class='color-palet']//parent::div//child::span)[1]")
	WebElement eventColor;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath = "(//*[contains (text(),'month')]//parent::div//child::button)[1]")
	WebElement monthView;
	@FindBy(xpath = "(//*[contains (text(),'week')]//parent::div//child::button)[2]")
	WebElement weekView;
	@FindBy(xpath = "(//*[contains (text(),'day')]//parent::div//child::button)[3]")
	WebElement dayView;
	@FindBy(xpath = "(//*[contains (text(),'list')]//parent::div//child::button)[4]")
	WebElement listView;
	
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[2]")
	WebElement forwardNavigation;
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[1]")
	WebElement backwardNavigation;
	
	@FindBy(xpath = "(//div[@class='form-group']//parent::div//child::label[text()='Labels'])[1]")
	WebElement clickGeneral;
	
	public void addEvent(ArrayList<String> list1) {
		list.add(onlyMe);
		list.add(shareWithAll);
		list.add(shareWithSpecific);
		
		SoftAssert softAssert = new SoftAssert();
		
		PageUtility.clickButton(driver, goToEvents);
		
		PageUtility.clickButton(driver, addEvent);
		
		PageUtility.enterText(title, list1.get(0));
		PageUtility.enterText(description, list1.get(1));
		
		PageUtility.clickButton(driver, startDate);
		PageUtility.enterText(startDate, list1.get(2));
		PageUtility.enterKey(startDate);
		PageUtility.enterText(startTime, list1.get(3));
		PageUtility.clickButton(driver, clickGeneral);
		
		PageUtility.clickButton(driver, endDate);
		PageUtility.enterText(endDate, list1.get(4));
		PageUtility.enterKey(endDate);
		PageUtility.enterText(endTime, list1.get(5));
		PageUtility.clickButton(driver, clickGeneral);
		
		PageUtility.enterText(location, list1.get(6));
		
		PageUtility.clickActionButton(driver, clientSelectionDropdown);
		PageUtility.enterText(clientField, list1.get(7));
		PageUtility.enterKey(clientField);
		
		PageUtility.clickButton(driver, list.get(0));
		b =PageUtility.selected(list.get(2));
		softAssert.assertTrue(b,"Specific Members");
		PageUtility.enterText(membersShared, list1.get(8));
		PageUtility.clickButton(driver, membersShared);
		softAssert.assertAll();
		
		if(list1.get(9).equalsIgnoreCase("Yes")) {
			PageUtility.clickButton(driver, eventRecurring);
			PageUtility.enterText(repeatTimes, list1.get(10));
			PageUtility.clickButton(driver, repeatDurationDropdown);
			PageUtility.enterText(repeatDuration, list1.get(11));
			PageUtility.enterKey(repeatDuration);
			PageUtility.enterText(repeatCycles, list1.get(12));
		}
		PageUtility.clickButton(driver, eventColor);
		PageUtility.clickButton(driver, saveButton);
	}
	
	public void eventMonthView() {
		PageUtility.clickButton(driver, monthView);
	}
	
	public void eventWeekView() {
		PageUtility.clickButton(driver, weekView);
	}
	
	public void eventDayView() {
		PageUtility.clickButton(driver, dayView);
	}
	
	public void eventListView() {
		PageUtility.clickButton(driver, listView);
	}
	
	public void navigateEventForward() {
		PageUtility.clickButton(driver, forwardNavigation);
	}
	
	public void navigateEventBackward() {
		PageUtility.clickButton(driver, backwardNavigation);
	}


}
