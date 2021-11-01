package com.technocredits.orghrm.testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase{

	private MenuPage menuPage;
	
	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}
	
	@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage
			.setEmpFirstName("Techno")
			.setEmpMiddleName("M")
			.setEmpLastName("Credits")
			.setEmployeeLocation("Australian Regional HQ")
			.clickOnNext()
			.setHobbies("Reading")
			.clickOnNext()
			.setWorkShift("Twilight")
			.setEffectiveFrom("12")
			.setRegion("Region-1")
			.setFTE("1")
			.setTempDept("Sub unit-1")
			.clickOnSave();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		super.teardown();
	}
}
