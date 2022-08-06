package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();

		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String newcount = count.replaceAll("\\D", "");
		System.out.println("Total count of items: " + newcount);
		int num = Integer.parseInt(newcount);
		// System.out.println(num);

		String count1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String rcount1 = count1.replaceAll("\\D", "");
		System.out.println("Categories Count of Jackets: " + rcount1);
		int num1 = Integer.parseInt(rcount1);
		// System.out.println(num1);

		String count2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String rcount2 = count2.replaceAll("\\D", "");
		System.out.println("Categories Count of Jackets: " + rcount2);
		int num2 = Integer.parseInt(rcount2);
		// System.out.println(num2);

		int sum = num1 + num2;
		// System.out.println(sum);

		if (sum == num) {

			System.out.println("Sum of categories matches the total count");

		} else {

			System.out.println("There is a mismatch");

		}

		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke", Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[11]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> duke = driver.findElements(By.xpath("//li//div/h3[@class='product-brand']"));
		for (WebElement output : duke) {
			String text = output.getText();
			// System.out.println(text);
			if (text.equalsIgnoreCase("Duke")) {

				System.out.println("All the coats are of brand Duke");

				break;
			} else {

				System.out.println("Brand mismatch");
				break;

			}

		}

		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions act = new Actions(driver);
		act.moveToElement(sort).perform();
		driver.findElement(By.xpath("(//ul[@class='sort-list']//label)[4]")).click();

		Thread.sleep(2000);
		String first = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of first displayed product: " + first);

		driver.findElement(By.xpath("(//div/h3[@class='product-brand'])[1]")).click();

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/product.png");
		FileUtils.copyFile(source, destination);

		driver.findElement(By.xpath("(//div/span[text()='wishlist'])[1]")).click();

		driver.close();

	}
}
