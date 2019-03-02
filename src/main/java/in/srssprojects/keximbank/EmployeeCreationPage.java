package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	
	WebDriver driver;
	
	//Employee Name
	@FindBy (how = How.XPATH, using ="//input[@id='txtUname']")
	private WebElement employeeName;
	
	//Employee Password
	@FindBy (how = How.ID, using ="txtLpwd")
	private WebElement employeePassword;
	
	//Employee Role
	@FindBy (how = How.ID, using ="lst_Roles")
	private WebElement employeeRole ;
	
	//Employee Branch
	@FindBy (how = How.ID, using ="lst_Branch")
	private WebElement employeeBranch;
	
	//Employee Submit Button
	@FindBy (how = How.ID, using ="BtnSubmit")
	private WebElement employeeSubmitButton;
	
	//Employee Reset Button
	@FindBy (how = How.ID, using ="btnreset")
	private WebElement employeeResetButton;
	
	//Employee Cancel Button 
	@FindBy (how = How.ID, using ="btnCancel")
	private WebElement employeeCancelButton ;
	
	//Page Factory constructor 
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Enter Employee Name
	public void EnterEmployeeName(String empName) {
		this.employeeName.sendKeys(empName);
	}
	
	//Enter Employee Password
	public void EnterEmployeePassword(String empPassword) {
		this.employeePassword.sendKeys(empPassword);
	}
	
	//Select Employee Role
	public void SelectEmpRole(String empRole) {
		Select s = new Select(this.employeeRole);
		s.selectByVisibleText(empRole);
	}
	
	//Select Employee Branch
	public void SelectEmpBranch(String empBranch) {
		Select s = new Select(this.employeeBranch);
		s.selectByVisibleText(empBranch);
	}
	
	//Click Submit button
	public void ClickEmpSubmitButton() {
		this.employeeSubmitButton.click();
	}
	
	//Click Reset Button
	public void ClickEmpResetButton() {
		this.employeeResetButton.click();
	}
	
	//Click Cancel Button
	public void ClickEmpCancelButton() {
		this.employeeCancelButton.click();
	}
}
