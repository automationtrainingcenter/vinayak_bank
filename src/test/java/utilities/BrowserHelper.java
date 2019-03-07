package utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
	
	protected WebDriver driver;
	
	public String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}
	
	public String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}
	
	public void captureScreenShot(String folderName, String fileName) {
		File srcImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desImage = new File(getFilePath(folderName, fileName));
		try {
			FileUtils.copyFile(srcImage, desImage);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void alertScreenCapture(String folderName, String fileName) {
		Robot r;
		try {
			r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			File desImg = new File(getFilePath(folderName, fileName));
			ImageIO.write(bi, "png", desImg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
	
	public void launchBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome") && System.getProperty("os.name").toLowerCase().contains("win")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox") && System.getProperty("os.name").toLowerCase().contains("win")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver"));
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("invalid browser name");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String readProperty(String propertyName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath("", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(propertyName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
	

	
	
	public void closeBrowser() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	
	//valid alert message
	public boolean validateAlert(String exprectedAlertText, String actualAlertext) {
		return actualAlertext.toLowerCase().contains(exprectedAlertText);
	}
	
	

}
