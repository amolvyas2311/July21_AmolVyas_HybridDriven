package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage clickOnQuickSearch(String name) {
		driver.findElement(By.xpath("//li[@data-tooltip='Filter']")).click();
		return this;
	}

	public PIM_EmployeeListPage setEmpIdInQuickSerch(String empId) {
		return setEmpNameInQuickSerch(empId);
	}

	public PIM_EmployeeListPage setEmpNameInQuickSerch(String empName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement quickSerch = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")));
		quickSerch.sendKeys(empName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return this;
	}

	public List<Employee> getListOfEmployee() {
		int rowCount = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
		List<Employee> list = new ArrayList();
		for (int row = 1; row <= rowCount; row++) {
			Employee e1 = new Employee();
			e1.setEmpId(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[" + row + "]/td[2]"))
					.getText());
			e1.setName(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[3]"))
					.getText());
			e1.setJobTitle(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[4]"))
					.getText());
			e1.setEmpStatus(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[5]"))
					.getText());
			e1.setSubUnit(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[6]"))
					.getText());
			e1.setCostCenter(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[7]"))
					.getText());
			e1.setLocation(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[8]"))
					.getText());
			e1.setSupervisor(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[\"+row+\"]/td[9]"))
					.getText());
			list.add(e1);
		}
		return list;
	}

}
