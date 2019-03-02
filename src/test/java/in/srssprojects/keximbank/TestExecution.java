package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {

	// BrandhDetailsPage

	// BranchCreationPage

	// EmployeeDetailsPage

	// EmployeeCreationPage

	Alert alert;
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	RoleDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	BranchDetailsPage branchDetailsPageObj;
	EmployeeDetailPage employeeDetailPageObj;
	EmployeeCreationPage employeeCreationPageObj;
	BranchCreationPage branchCreationPageObj;

	@BeforeClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void browserLaunch() {
		launchBrowser(readProperty("browserName"), readProperty("url"));
		bankHomePageObj = new BankHomePage(driver);
	}

	@Test(priority = 1, groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void testLogin() {
		bankHomePageObj.fillUserName(readProperty("username"));
		bankHomePageObj.fillPassword(readProperty("password"));
		bankHomePageObj.clickLogin();
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePageObj.isAdminHomePageDisplayed());
	}

	@Test(priority = 2, groups = {"role", "create", "valid"})
	public void roleCreationWithValidData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerNine");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		String actualAlertext = alert.getText();
		alert.accept();
		Reporter.log(actualAlertext, true);
		Assert.assertTrue(validateAlert("Created Sucessfully", actualAlertext));
	}

	@Test(priority = 3, groups = {"role", "create", "invalid"}, dependsOnMethods = { "roleCreationWithValidData" })
	public void roleCreationWithDuplicateData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerNine");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		String actualAlertext = alert.getText();
		alert.accept();
		Reporter.log(actualAlertext);
		Assert.assertTrue(validateAlert("role name already exists", actualAlertext));
		
	}

	@Test(priority = 4, groups = {"role", "create", "invalid"})
	public void roleCreationWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		alert = roleCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 5, groups = {"role", "reset", "valid"})
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerTen");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
	}

	@Test(priority = 6, groups = {"role", "cancel", "valid"})
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleDetailsPageObj = roleCreationPageObj.cancleButton();
	}

	@Test(priority = 7, groups = {"branch", "search", "valid"})
	public void branchDetailssearch() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchDetailsPageObj.selectCountry("INDIA");
		branchDetailsPageObj.selectState("GOA");
		branchDetailsPageObj.selectCity("GOA");
		branchDetailsPageObj.clickSearchButton();
		branchDetailsPageObj.clickClearSearchButton();
	}

	@Test(priority = 8, groups = {"employee", "create", "valid"})
	public void employeeCreationwithValidData() {
		employeeDetailPageObj = adminHomePageObj.clickEmployeeButton();
		employeeCreationPageObj = employeeDetailPageObj.ClickNewEmployeeButton();
		employeeCreationPageObj.EnterEmployeeName("vijayEmployee");
		employeeCreationPageObj.EnterEmployeePassword("Test@123");
		employeeCreationPageObj.SelectEmpRole("manager");
		employeeCreationPageObj.SelectEmpBranch("Amritsar");
		alert = employeeCreationPageObj.ClickEmpSubmitButton();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(priority = 9, groups = {"employee", "create", "invalid"})
	public void employeeCreationWithDuplicateData() {
		employeeDetailPageObj = adminHomePageObj.clickEmployeeButton();
		employeeCreationPageObj = employeeDetailPageObj.ClickNewEmployeeButton();
		employeeCreationPageObj.EnterEmployeeName("vijayEmployee");
		employeeCreationPageObj.EnterEmployeePassword("Test@123");
		employeeCreationPageObj.SelectEmpRole("manager");
		employeeCreationPageObj.SelectEmpBranch("Amritsar");
		alert = employeeCreationPageObj.ClickEmpSubmitButton();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 10, groups = {"employee", "create", "invalid"})
	public void employeeCreationWithBlankData() {
		employeeDetailPageObj = adminHomePageObj.clickEmployeeButton();
		employeeCreationPageObj = employeeDetailPageObj.ClickNewEmployeeButton();
		alert = employeeCreationPageObj.ClickEmpSubmitButton();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 11,  groups = {"employee", "reset", "valid"})
	public void employeeCreationReset() {
		employeeDetailPageObj = adminHomePageObj.clickEmployeeButton();
		employeeCreationPageObj = employeeDetailPageObj.ClickNewEmployeeButton();
		employeeCreationPageObj.EnterEmployeeName("Aruntej");
		employeeCreationPageObj.EnterEmployeePassword("Test@123");
		employeeCreationPageObj.SelectEmpRole("manager");
		employeeCreationPageObj.SelectEmpBranch("Amritsar");
		employeeCreationPageObj.ClickEmpResetButton();
	}

	@Test(priority = 12,  groups = {"employee","cancel", "valid"})
	public void employeeCreationCancel() {
		employeeDetailPageObj = adminHomePageObj.clickEmployeeButton();
		employeeCreationPageObj = employeeDetailPageObj.ClickNewEmployeeButton();
		employeeDetailPageObj = employeeCreationPageObj.ClickEmpCancelButton();
	}

	@Test(priority = 13,  groups = {"branch", "create", "valid"})
	public void branchCreationWithValidData() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		branchCreationPageObj.fillBranchName("newbranchName");
		branchCreationPageObj.fillAddressName("lingampalli");
		branchCreationPageObj.fillZipcode("54321");
		branchCreationPageObj.fillCountry("INDIA");
		branchCreationPageObj.fillState("Delhi");
		branchCreationPageObj.fillCity("Delhi");
		alert = branchCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 14, groups = {"branch", "create", "invalid"})
	public void branchCreationWithDuplicateData() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		branchCreationPageObj.fillBranchName("newbranchName");
		branchCreationPageObj.fillAddressName("lingampalli");
		branchCreationPageObj.fillZipcode("54321");
		branchCreationPageObj.fillCountry("INDIA");
		branchCreationPageObj.fillState("Delhi");
		branchCreationPageObj.fillCity("Delhi");
		alert = branchCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 15, groups = {"branch", "create", "invalid"})
	public void branchCreationWithBlankData() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		alert = branchCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 16,groups = {"branch", "reset", "valid"})
	public void branchCreationRest() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		branchCreationPageObj.fillBranchName("newbranchName");
		branchCreationPageObj.fillAddressName("lingampalli");
		branchCreationPageObj.fillZipcode("54321");
		branchCreationPageObj.fillCountry("INDIA");
		branchCreationPageObj.fillState("Delhi");
		branchCreationPageObj.fillCity("Delhi");
		branchCreationPageObj.clickResetButton();
	}

	@Test(priority = 17, groups = {"branch", "cancel", "valid"})
	public void branchCreationCancel() {
		branchDetailsPageObj = adminHomePageObj.clickBranchButton();
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		branchDetailsPageObj = branchCreationPageObj.CancelButton();
	}

	@AfterClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void logoutTest() {
		adminHomePageObj.clickLogoutButton();
		closeBrowser();
	}

}
