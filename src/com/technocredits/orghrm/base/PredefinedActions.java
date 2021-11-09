package com.technocredits.orghrm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.technocredits.orghrm.customExceptions.InvalidSelectorExpection;

public class PredefinedActions {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public static void start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public static void start() {
		start("https://avyas8-trials72.orangehrmlive.com/");
	}

	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement element = null;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				element = driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			else
				element = driver.findElement(By.id(locatorValue));
			break;
		case "CLASSNAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			else
				element = driver.findElement(By.className(locatorValue));
		case "CSSSELECTOR":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				element = driver.findElement(By.cssSelector(locatorValue));
		case "NAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			else
				element = driver.findElement(By.name(locatorValue));
		case "TAGNAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			else
				element = driver.findElement(By.tagName(locatorValue));
		case "LINKTEXT":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			else
				element = driver.findElement(By.linkText(locatorValue));
		case "PARTIALLINKTEXT":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			else
				element = driver.findElement(By.partialLinkText(locatorValue));
		default:
			throw new InvalidSelectorExpection(
					"User Should Select values from XPATH, CSSSELECTOR, ID, NAME,TAGNAME, LINKTEXT, PARTIALLINKTEXT,CLASSNAME,TAGNAME");
		}
		return element;
	}

	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	protected void clickOnElement(WebElement element) {
		if (!element.isDisplayed())
			scrollToElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected void sendkeysOnElement(WebElement element, String data) {
		if (!(element.isEnabled() && element.isDisplayed()))
			scrollToElement(element);
		element.sendKeys(data);

	}

	protected List<String> getTextOfAllElements(String locator) {
		List<WebElement> widgetsListElements = driver.findElements(By.xpath(locator));
		List<String> widgetsList = new ArrayList<String>();
		for (WebElement widgetElement : widgetsListElements) {
			widgetsList.add(widgetElement.getText());
		}
		return widgetsList;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

}
