package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution{
	
	@BeforeClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	@Parameters({"browserName", "url"})
	public void browserLaunch(String brName, String url) {
		launchBrowser(brName, url);
		bankHomePageObj = new BankHomePage(driver);
	}
	
	@AfterClass(groups = {"branch", "create", "valid", "role", "employee", "invalid", "reset", "cancel"})
	public void logoutTest() {
		adminHomePageObj.clickLogoutButton();
		closeBrowser();
	}

}
