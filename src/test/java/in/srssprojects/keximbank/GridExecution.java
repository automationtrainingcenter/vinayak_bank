package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	@BeforeClass(groups = { "branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel" })
	@Parameters({ "browserName", "url", "nodeURL", "os" })
	public void browserLaunch(String brName, String url, String nodeUrl, String os) {
		launchBrowser(brName, url, nodeUrl, os);
		bankHomePageObj = new BankHomePage(driver);
	}

	@AfterClass(groups = { "branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel" })
	public void logoutTest() {
		adminHomePageObj.clickLogoutButton();
		closeBrowser();
	}

}
