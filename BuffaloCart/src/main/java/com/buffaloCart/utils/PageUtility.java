package com.buffaloCart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtility {
	
	static WebDriver driver;
	
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void clickButton(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static String getText(WebElement element) {
		String txt= element.getText();
		return txt;
	}
	
	public static void enterKey(WebElement element) {
		element.clear();
		element.sendKeys(Keys.ENTER);
	}

	public static boolean displayed(WebElement element) {
		boolean b = element.isDisplayed();
		return b;
	}
	
	public static boolean selected(WebElement element) {
		boolean b = element.isSelected();
		return b;
	}

}