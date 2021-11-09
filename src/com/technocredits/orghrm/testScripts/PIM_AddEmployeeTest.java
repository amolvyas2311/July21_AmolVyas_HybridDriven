package com.technocredits.orghrm.testScripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;
import com.technocredits.orghrm.pojo.Employee;
import com.technocredits.orghrm.util.ExcelOperations;

public class PIM_AddEmployeeTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	//@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		String empId = pim_AddEmployeePage.getEmployeeId();
		pim_AddEmployeePage.setEmpFirstName("Techno")
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
		boolean IstoastMessageVisible = pim_AddEmployeePage.isSuccessfullySaved();
		Assert.assertTrue(IstoastMessageVisible);
		boolean isUserNameDisplayed = pim_AddEmployeePage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed);

		menuPage.navigateTo("Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
		List<Employee> listOfEmployee = pim_EmployeeListPage.setEmpIdInQuickSerch(empId).getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpId(), empId);
		Assert.assertTrue(listOfEmployee.size() == 1);

	}

	@Test(dataProvider = "ListOfEmp")
	public void verifyAddEmployeeDataDrivenTest(String firstname, String middlename, String lastname, String location,
			String hobbies, String workShift, String effectiveFrom, String region, String fte, String dept) {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		String empId = pim_AddEmployeePage.getEmployeeId();
		pim_AddEmployeePage.setEmpFirstName(firstname)
		.setEmpMiddleName(middlename)
		.setEmpLastName(lastname)
		.setEmployeeLocation(location)
		.clickOnNext()
		.setHobbies(hobbies)
		.clickOnNext()
		.setWorkShift(workShift)
		.setEffectiveFrom(effectiveFrom)
		.setRegion(region)
		.setFTE(fte)
		.setTempDept(dept)
		.clickOnSave();

		boolean IstoastMessageVisible = pim_AddEmployeePage.isSuccessfullySaved();
		Assert.assertTrue(IstoastMessageVisible);
		boolean isUserNameDisplayed = pim_AddEmployeePage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed);

		menuPage.navigateTo("Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();

		List<Employee> listOfEmployee = pim_EmployeeListPage.setEmpIdInQuickSerch(empId).getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpId(), empId);
		Assert.assertTrue(listOfEmployee.size() == 1);
	}

	@DataProvider(name = "ListOfEmp")
	public Object[][] getListOfNewEmp() throws IOException {
		return ExcelOperations.getDataFromExcel("./testdata/add-employee.xlsx", "data");
	}

	@AfterMethod
	public void teardown() {
		super.teardown();
	}
}
