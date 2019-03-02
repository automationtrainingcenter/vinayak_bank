package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailPage {
	
	
	WebDriver driver;
	//New Employee 
	@FindBy(how = How.ID, using ="BtnNew")
	private WebElement newEmployeeButton;
	
	//page factory construtor
	public EmployeeDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click New Employee button
	public EmployeeCreationPage ClickNewEmployeeButton() {
		this.newEmployeeButton.click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}

	//validate employee details page
	public boolean isNewEmployeeButtonDisplayed() {
		return this.newEmployeeButton.isDisplayed();
	}
}