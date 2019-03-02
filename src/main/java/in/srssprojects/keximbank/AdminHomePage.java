package in.srssprojects.keximbank;
// this class is implemented using page factory

import java.awt.print.Pageable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;

	// home button
	@FindBy(how = How.CSS, using = "a[href='adminflow.aspx']")
	private WebElement homeButton;

	// logout button
	@FindBy(css = "a[href='home.aspx']")
	private WebElement logoutButton;

	// branches button
	@FindBy(how = How.CSS, using = "a[href='admin_banker_master.aspx']")
	private WebElement branches;

	// role button
	@FindBy(how = How.CSS, using = "a[href='Admin_Roles_details.aspx']")
	private WebElement rolebutton;

	// employess button
	@FindBy(how = How.CSS, using = "a[href='Admin_Emp_details.aspx']")
	private WebElement employeeButton;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		// locate elements in this page using PageFactory
		PageFactory.initElements(driver, this);
	}

	// click home button
	public AdminHomePage clickHomeButton() {
		this.homeButton.click();
		return this;
	}

	// click on branches button
	public BranchDetailsPage clickBranchButton(){
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	} 

	// click on roles button
	public RoleDetailsPage clickRoleButton() {
		this.rolebutton.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click on employee button
	public EmployeeDetailPage clickEmployeeButton() {
		this.employeeButton.click();
		return PageFactory.initElements(driver, EmployeeDetailPage.class);
	}

	// click on logout button
	public BankHomePage clickLogoutButton() {
		this.logoutButton.click();
		return PageFactory.initElements(driver, BankHomePage.class);
	}
	
	
	//page validation using visibility of logout button and  url of the page
	public boolean isAdminHomePageDisplayed() {
		return this.logoutButton.isDisplayed() && driver.getCurrentUrl().contains("adminflow");
	}
	

}
