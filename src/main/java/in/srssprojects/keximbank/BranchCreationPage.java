package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
	WebDriver driver;
	
	//Branch name
	@FindBy(id="txtbName")
	private WebElement branchName;
	
	//Address1
	@FindBy(how=How.ID,using= "txtAdd1")
	private WebElement address1;
	
	//Zip code
	@FindBy(how=How.ID,using= "txtZip")
	private WebElement zipCode;
	
	//Country
	@FindBy(how=How.ID,using= "lst_counrtyU")
	private WebElement country;
	
	//state
	@FindBy(how=How.ID,using= "lst_stateI")
	private WebElement state;
	
	//city
	@FindBy(how=How.ID,using= "lst_cityI")
	private WebElement city;
	
	//submit
	@FindBy(how=How.ID,using= "btn_insert")
	private WebElement submit;
	
	//reset
	@FindBy(how=How.ID,using= "Btn_Reset")
	private WebElement reset;
	
	//Cancel
	@FindBy(how=How.ID,using= "Btn_cancel")
	private WebElement cancel;
	
	public BranchCreationPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	//fill branch name
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
		
	}
	//fill address
	public void fillAddressName(String Address) {
		this.address1.sendKeys(Address);
	}
	
	//fill zip code
	public void fillZipcode(String Zipcode) {
		this.zipCode.sendKeys(Zipcode);
	}
	
	//fill country
	public void fillCountry(String Country) {
		Select s= new Select(this.country);
		s.selectByVisibleText(Country);
	
	}
	
	//fill state
	public void fillState(String State) {
		Select s= new Select(this.state);
		s.selectByVisibleText(State);
	}
	
	//fill city
	public void fillCity(String City) {
		Select s= new Select(this.city);
		s.selectByVisibleText(City);
		
	}
	
	//click submit
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}
	
	//click reset button
	public void clickResetButton() {
		this.reset.click();
	}
	
	//click cancel button
	public BranchDetailsPage CancelButton() {
		this.cancel.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);	
	}
	
	//validate is creation form reset or not
	public boolean isFormReset() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return arguments[0].value", this.branchName).toString().isEmpty();
		
	}
	
	

}
