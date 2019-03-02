package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	
	WebDriver driver;
	
	@FindBy (how = How.ID, using ="txtUname")
	private WebElement employeeName;
	
	@FindBy (how = How.ID, using ="txtLpwd")
	private WebElement employeePassword;
	
	@FindBy (how = How.ID, using ="lst_Roles")
	private WebElement employeeRole ;
	
	@FindBy (how = How.ID, using ="lst_Branch")
	private WebElement employeeBranch;
	
	@FindBy (how = How.ID, using ="BtnSubmit")
	private WebElement employeeSubmitButton;
	
	@FindBy (how = How.ID, using ="btnreset")
	private WebElement employeeResetButton;
	
	@FindBy (how = How.ID, using ="btnCancel")
	private WebElement employeeCreateCancelButton ;
	
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmployeeName(String empName) {
		this.employeeName.sendKeys(empName);
	}
	
	public void EnterEmployeePassword(String empPassword) {
		this.employeePassword.sendKeys(empPassword);
	}
	
	public void SelectEmpRole(String empRole) {
		Select s = new Select(this.employeeRole);
		s.selectByVisibleText(empRole);
	}
	
	public void SelectEmpBranch(String empBranch) {
		Select s = new Select(this.employeeBranch);
		s.selectByVisibleText(empBranch);
	}
	
	public void ClickEmpSubmitButton() {
		this.employeeSubmitButton.click();
	}
	
	public void ClickEmpResetButton() {
		this.employeeResetButton.click();
	}
	
	public void ClickEmpCancelButton() {
		this.employeeCreateCancelButton.click();
	}
}
