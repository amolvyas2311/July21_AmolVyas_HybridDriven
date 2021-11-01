package com.technocredits.orghrm.testScripts;


import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;

public class PIM_EmployeeListTest extends TestBase {
	
private MenuPage menuPage;
	
	
	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}
	
	@Test
	public void verifyEmpData() throws InterruptedException {
		menuPage.navigateTo("PIM->Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
		pim_EmployeeListPage.clickOnQuickSearch("Techno");
		Thread.sleep(3000);
		String actualName = pim_EmployeeListPage.getNameOfEmp();
		String actualLocation = pim_EmployeeListPage.getLocationOfEmp();
		System.out.println(actualName+" "+actualLocation);
		SoftAssert softAssert = new SoftAssert();
		AssertJUnit.assertEquals(actualName.trim(), "Techno M Credits");
		AssertJUnit.assertEquals(actualLocation, "Australian Regional HQ");
		softAssert.assertAll();
		
		
		
	}
	
	@AfterMethod
	public void teardown() {
		super.teardown();
	}

}
