package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestExecution {
	
	//BrandhDetailsPage
	
	//BranchCreationPage
	
	//EmployeeDetailsPage
	
	//EmployeeCreationPage 
	
	WebDriver driver;
	Alert alert;
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	RoleDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	
	@Test(priority = 0)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.srssprojects.in");
		bankHomePageObj = new BankHomePage(driver);
	}
	
	@Test(priority = 1)
	public void testLogin() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPassword("Admin");
		bankHomePageObj.clickLogin();
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
	}
	
	@Test(priority = 2)
	public void roleCreationWithValidData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerTen");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	@Test(priority = 3)
	public void roleCreationWithDuplicateData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerTen");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	@Test(priority = 4)
	public void roleCreationWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		alert = roleCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	@Test(priority = 5)
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleCreationPageObj.fillRoleName("associateManagerTen");
		roleCreationPageObj.fillRoleDescription("associate manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
	}
	
	@Test(priority = 6)
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoleButton();
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		roleDetailsPageObj = roleCreationPageObj.cancleButton();
	}
	
	@Test(priority = 7)
	public void logoutTest() {
		adminHomePageObj.clickLogoutButton();
		driver.close();
	}

}
