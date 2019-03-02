package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class BranchDetailsPage {
	
	WebDriver driver;
	
	//Country
	@FindBy(how = How.ID, using = "lst_countryS")
	private WebElement country;
	
    //State
	@FindBy(how = How.ID, using = "lst_stateS")
	private WebElement state;
	
	//City
	@FindBy(how = How.ID, using = "lst_cityS")
	private WebElement city;
	
	//Search Button
	@FindBy(how = How.ID, using ="btn_search") 
	private WebElement searchButton;
	
	//Clear Search Button
	@FindBy(how = How.ID, using ="btn_clsearch")
	private WebElement clearSearchButton;
	
	//New Branch creation
	@FindBy(how=How.ID, using = "BtnNewBR")
	private WebElement newBranchButton;
	
	//pagefactory constructor
	public BranchDetailsPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Select country
	public void selectCountry(String Country) {
		Select s = new Select(this.country);
		s.selectByVisibleText(Country);
	}
	
	//Select State
	public void selectState(String State) {
		Select s = new Select(this.state);
		s.selectByVisibleText(State);
	}
	
	//Select City
	public void selectCity(String City) {
		Select s = new Select(this.city);
		s.selectByVisibleText(City);
	}

	//Click Search Button
		public void clickSearchButton() {
		this.searchButton.click();
	}
	
	//Click Clear Search Button
	public void clickClearSearchButton() {
		this.clearSearchButton.click();
	}
	
	//Click New Branch creation Button
	public BranchCreationPage clickNewBranchButton() {
		this.newBranchButton.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}
	
	//validate branch details page
	public boolean isNewBranchButtonDisplayed() {
		return this.newBranchButton.isDisplayed();
	}
	
	
}
