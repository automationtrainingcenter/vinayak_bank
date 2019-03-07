package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {
	WebDriver driver;
	
	//new role button
	@FindBy(how = How.ID, using = "btnRoles")
	private WebElement newRoleButton;
	
	
	private By rolesTable = By.xpath("//table[@id='DGRoles']/tbody");
	
	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click role button
	public RoleCreationPage clickNewRoleButton() {
		this.newRoleButton.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}
	
	//validate role details page
	public boolean isNewRoleButtonDisplayed() {
		return this.newRoleButton.isDisplayed();
	}

}
