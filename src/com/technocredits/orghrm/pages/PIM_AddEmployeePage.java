package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public String getEmployeeId() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='employeeId']")));
		WebElement employeeId =driver.findElement(By.xpath("//input[@id='employeeId']"));
		return employeeId.getAttribute("value");
	}

	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		sendkeysOnElement(getElement("XPATH", "//input[@id='first-name-box']", false), fname);
		System.out.println("STEP- Enter value of First Name");
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String mname) {
		sendkeysOnElement(getElement("XPATH", "//input[@id='middle-name-box']", false), mname);
		System.out.println("STEP- Enter value of Middle Name");
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lname) {
		sendkeysOnElement(getElement("XPATH", "//input[@id='last-name-box']", false), lname);
		System.out.println("STEP- Enter value of Last Name");
		return this;
	}

	public PIM_AddEmployeePage setEmployeeLocation(String location) {
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		driver.findElement(By.xpath("//span[text()='" + location +"']//parent::a")).click();
		//clickOnElement(getElement("XPATH", "//i[text()='arrow_drop_down']", false));
		//clickOnElement(getElement("XPATH", "//span[text()='" + location + "']//parent::a", false));
		System.out.println("STEP- Select Value of Location");
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		//clickOnElement(getElement("XPATH", "//button[text()='Next']", false));
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		System.out.println("STEP- Click on Next button");
		return this;
	}

	public void addEmployeeInfo(String fname, String mname, String lname, String location) {
		setEmpFirstName(fname);
		setEmpMiddleName(mname);
		setEmpLastName(lname);
		setEmployeeLocation(location);
		}

	public PIM_AddEmployeePage setHobbies(String hobbies) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement hobbiesElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='5']")));
		hobbiesElement.sendKeys(hobbies);
		//sendkeysOnElement(getElement("XPATH", "//input[@id='5']", true), hobbies);
		System.out.println("STEP-Enter Hobbies");
		return this;
	}

	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement shiftValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")));
		shiftValueElement.click();
		
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			"//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='" + shiftValue + "']")));
		e.click();
		//clickOnElement(getElement("XPATH", "//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input", true));
		//clickOnElement(getElement("XPATH", "//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='" + shiftValue + "']", true));
		
		System.out.println("STEP-Select Work Shift");
		return this;
	}

	// TODO - Sun, 20 Sep 2015
	public PIM_AddEmployeePage setEffectiveFrom(String date) {
		date = date.split("\\.")[0];
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement effectiveFromElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='" + date
						+ "'][contains(@class,'--infocus')]")));
		effectiveFromElement.click();
		return this;
	}

	public PIM_AddEmployeePage setRegion(String region) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		// scrolling
		regionDropDown.click();

		WebElement regionElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + region + "']")));
		regionElement.click();
		return this;
	}

	public PIM_AddEmployeePage setFTE(String FTEValue) {
		if (FTEValue.equals("1.0"))
			FTEValue = "1";

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='FTE']/preceding-sibling::div/input")));
		// scrolling
		regionDropDown.click();

		WebElement regionElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + FTEValue + "']")));
		regionElement.click();
		return this;
	}

	public PIM_AddEmployeePage setTempDept(String TempDept) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Temporary Department']/preceding-sibling::div/input")));
		// scrolling
		regionDropDown.click();

		WebElement regionElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + TempDept + "']")));
		regionElement.click();
		return this;
	}

	public PIM_AddEmployeePage clickOnSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}

	public boolean isSuccessfullySaved() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
			return true;
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	public void waitTillSuccessfulMessageIsInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
	}

	public boolean isUsernameTitleDisplayed() {
		// span[@id='pim.navbar.employeeName']
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pim.navbar.employeeName']")));
			return true;
		} catch (TimeoutException te) {
			return false;
		}
	}

}
