package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ColumnRows {
	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://html.com/tags/table/");

		// Maximize the browser window on loading
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Get the No.of Rows of the first table
		List<WebElement> rows1 = driver.findElements(By.xpath("(//table)[1]//tr"));
		int rowSize1 = rows1.size();
		System.out.println("No. of rows in First Table: " +rowSize1);
		
		//Get the No.of Columns of the first table
		List<WebElement> columns1 = driver.findElements(By.xpath("(//table)[1]//th"));	
		int columnsSize1 = columns1.size();
		System.out.println("No. of columns in First Table: " +columnsSize1);

		//Get the No.of Rows of the second table
		List<WebElement> rows2 = driver.findElements(By.xpath("(//table)[2]//tr"));
		int rowSize2 = rows2.size();
		System.out.println("No. of rows in Second Table: " +rowSize2);

		//Get the No.of Columns of the second table
		List<WebElement> columns2 = driver.findElements(By.xpath("(//table)[2]//th"));
		int columnsSize2 = columns2.size();
		System.out.println("No. of columns in Second Table: " +columnsSize2);
	}
}
