package in.srssprojects.keximbank;
/*
 * which will take parameters (browser name name and url) from properties file
 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseicExecution  extends TestExecution{
	@BeforeClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void browserLaunch() {
		launchBrowser(readProperty("browserName"), readProperty("url"));
		bankHomePageObj = new BankHomePage(driver);
	}

	@AfterClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void logoutTest() {
		adminHomePageObj.clickLogoutButton();
		closeBrowser();
	}
}
