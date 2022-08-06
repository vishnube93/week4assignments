package week4.assignment;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.chittorgarh.com/");

		// Maximize the browser window on loading
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on stock market by using id
		driver.findElement(By.id("navbtn_stockmarket")).click();

		// Click on NSE Bulk Deals by using linkText
		driver.findElement(By.linkText("NSE Bulk Deals")).click();

		// Get the total row size
		List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		int rowsize = row.size();
		System.out.println("Total row size :" + rowsize);
		System.out.println("\nSecurity Names:\n");
		// Get the Security Names for all the rows which is in 3rd column
		Set<String> mySet = new LinkedHashSet<String>();
		for (int i = 1; i < rowsize - 1; i++) {
			WebElement securityNames = driver.findElement(By.xpath("//table//tr[" + i + "]/td[3]"));
			System.out.println(securityNames.getText());
			// Add the security names to the LinkedHashSet to remove the Duplicates
			mySet.add(securityNames.getText());
		}

		if (mySet.size() < rowsize) {
			System.out.println("\nDuplicates are available in the Security Names");
		} else {
			System.out.println("\nNo Duplicates are available in the Security Names");
		}

		System.out.println("\nSecurity Names after removing the duplicates:\n");
		for (String webElement : mySet) {
			String text = webElement;
			System.out.println(text);
		}

	}
}
