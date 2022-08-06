package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {
	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://www.leafground.com/pages/table.html");

		// Maximise the browser window on loading
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Get the No.of Columns of the table
		List<WebElement> columns = driver.findElements(By.xpath("//table//th"));
		int columnsSize = columns.size();
		System.out.println("\n1. No of Columns in the table: " + columnsSize);

		// 2. Get the No.of Rows of the table
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		int rowSize = rows.size();
		System.out.println("\n2. No of Rows in the table: " + rowSize);

		// 3. Get the Progress value of the Learn to interact with Elements

		List<WebElement> column = driver.findElements(By.xpath("//table//tr[1]/th"));
		int columnSize = column.size();
		System.out.println("\n3. Progress value of Learn to interact with Elements:");

		for (int i = 3; i <= 5; i++)
			for (int j = 2; j < columnSize; j++) {
				String value = driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(value);

			}

		// 4. To Check the vital task for the least completed progress.
		List<String> data = new ArrayList<String>();
		for (int i = 2; i <= rowSize; i++) {
			for (int j = 2; j < columnSize; j++) {
				String value1 = driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText();
				data.add(value1);
			}
		}
		if (data.contains("20%")) {
			driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
		}

	}
}
