package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class Listener implements WebDriverEventListener{
	JavascriptExecutor js;

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		Reporter.log("alert accepted");
		TestListener.test.log(LogStatus.INFO, "alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		Reporter.log("alert dismissed");
		TestListener.test.log(LogStatus.INFO,"alert dismissed");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		js = (JavascriptExecutor)arg1;
		Reporter.log("element value changed "+js.executeScript("return arguments[0].value", arg0).toString());
		TestListener.test.log(LogStatus.INFO,"element value changed "+js.executeScript("return arguments[0].value", arg0).toString());
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("element clicked");
		TestListener.test.log(LogStatus.INFO,"element clicked");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("element located successfully");
		TestListener.test.log(LogStatus.INFO,"element located successfully");
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		Reporter.log("text of element is  "+arg2);
		TestListener.test.log(LogStatus.INFO,"text of element is  "+arg2);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
	
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		Reporter.log("alert came with alert text "+arg0.switchTo().alert().getText());
		TestListener.test.log(LogStatus.INFO,"alert came with alert text "+arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		Reporter.log("alert came with alert text "+arg0.switchTo().alert().getText());
		TestListener.test.log(LogStatus.INFO,"alert came with alert text "+arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("clicking on that element");
		TestListener.test.log(LogStatus.INFO,"clicking on that element");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("locating an element using "+arg0);
		TestListener.test.log(LogStatus.INFO,"locating an element using "+arg0);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		
	}

}
