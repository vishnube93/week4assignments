package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();

		driver.findElement(By.id("brandSearchBox")).clear();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris", Keys.ENTER);

		driver.findElement(By.xpath("(//a[contains(text(), 'Paris')])[1]")).click();
		System.out.println("Title of the page is: " + driver.getTitle());
		System.out.println("Does the title contains L'Oreal Paris? " + driver.getTitle().contains("L'Oreal Paris"));

		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		System.out.println("Is filter applied? "
				+ driver.findElement(By.xpath("(//span[text()='Color Protection'])[1]")).isEnabled());

		WebElement click = driver.findElement(By.xpath("//div[@class='css-xrzmfa']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", click);

		// String nykaa = driver.getWindowHandle();
		// System.out.println(nykaa);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> firstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(firstwindow.get(1));

		driver.findElement(By.xpath("//select[@class='css-2t5nwu']")).click();
		driver.findElement(By.xpath("//select/option[text()='175ml']")).click();

		String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		String rmrp = mrp.replaceAll("\\D", "");

		System.out.println("MRP of the product: " + rmrp);
		driver.findElement(By.xpath("(//button/span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();

		driver.switchTo().frame(0);
		Thread.sleep(2000);

		WebElement frame = driver.findElement(By.xpath("//div[@class='value medium-strong']"));

		String frametotal = frame.getText();
		String rframetotal = frametotal.replaceAll("\\D", "");
		System.out.println("Grand Total: " + rframetotal);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();

		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String title1 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		String rtitle1 = title1.replaceAll("\\D", "");
		System.out.println("Grand Total at Checkout: " + rtitle1);

		if (rframetotal.equals(rtitle1)) {

			System.out.println("Prices are equal");

		} else {

			System.out.println("Prices are different");
		}

		driver.quit();

	}
}
