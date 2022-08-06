package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Values {
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
		
		//Get the No.of Columns of the table
		List<WebElement> column = driver.findElements(By.xpath("(//table)[1]//th"));	
		int columnSize = column.size();
		
		// Iterate the first row till the column size to get the respective values and add it to the list
		List<String> library1 = new ArrayList<String>();
		for (int i = 2; i < columnSize+1; i++) {
			String element1 = driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/td["+i+"]")).getText();
			library1.add(element1);
		}
		System.out.println("Market Share Values are:");
		System.out.println(library1);
		
		//Iterate the second row till the column size to get the respective values and add it to the list
		List<String> library2 = new ArrayList<String>();
		for (int j = 2; j < columnSize+1; j++) {
			String element2 = driver.findElement(By.xpath("(//table)[1]/tbody/tr[2]/td["+j+"]")).getText();
			library2.add(element2);
		}
		System.out.println("Absolute Usage Values are:");
		System.out.println(library2);
	}
}
