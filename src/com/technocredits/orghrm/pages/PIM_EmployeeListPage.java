package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage clickOnQuickSearch(String name) {
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class='angucomplete-row angucomplete-selected-row']")).click();
		return this;
	}

	public String getNameOfEmp() {
		return driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]")).getText();
	}

	public String getLocationOfEmp() {
		return driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[8]")).getText();
	}

}
