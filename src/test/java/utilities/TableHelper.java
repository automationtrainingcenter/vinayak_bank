package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.xml.LaunchSuite;

public class TableHelper extends BrowserHelper {

	boolean after10 = false;

	public void handleTable(By xpath, String operation, String id) {
		boolean status = false;
		WebElement table = driver.findElement(xpath);
		// locate rows inside the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// locate the page links which are in last row
		String[] pageLinks = rows.get(rows.size() - 1).getText().split(" ");
		// iterate over the pages
		for (int i = 1; i < pageLinks.length; i++) {
			table = driver.findElement(xpath);
			// relocate the rows in the page
			rows = table.findElements(By.tagName("tr"));
			// iterate over the rows
			for (int j = 1; j < rows.size() - 1; j++) {
				List<WebElement> cells = rows.get(j).findElements(By.tagName("td"));
				if (cells.get(0).getText().equals(id)) {
					if (operation.equalsIgnoreCase("edit")) {
						rows.get(cells.size() - 2).findElement(By.tagName("a")).click();
					} else if (operation.equalsIgnoreCase("delete")) {
						rows.get(cells.size() - 1).findElement(By.tagName("a")).click();
					} else {
						throw new RuntimeException("invalid operation");
					}
					status = true;
					break; // for loop of rows
				}
			}
			if (status == true) {
				break;// for loop of pagelinks
			}
			if (status == false) {
				try {
					if (after10 == true && pageLinks[i].equals("...")) {
						rows.get(rows.size() - 1).findElement(By.xpath("(//a[contains(text(), '...')])[2]")).click();
					} else {
						rows.get(rows.size() - 1).findElement(By.linkText(pageLinks[i])).click();
					}
				} catch (Exception e) {
//					System.out.println(e.getMessage());
				}
			}
			if (pageLinks[i].equals("...")) {
				after10 = true;
				handleTable(xpath, operation, id);
			}

		}

	}

}
