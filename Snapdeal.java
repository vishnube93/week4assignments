package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement mfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mfashion).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Count of sports shoes for Men: " + count);

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		List<WebElement> sortlist = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		/*
		 * for (WebElement output : sortlist) { String text = output.getText(); String
		 * rtext = text.replaceAll("\\D", ""); //System.out.println(rtext); int num =
		 * Integer.parseInt(rtext);
		 * 
		 * //System.out.println(num);
		 * 
		 * 
		 * }
		 */

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.xpath("//label/a[contains(text(),'Navy')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkbox);
		String filter = driver.findElement(By.xpath("(//span[text()='2'])[4]")).getText();
		// System.out.println(filter);
		String filter1 = driver.findElement(By.xpath("//span[text()='(2 Items)']")).getText();
		// System.out.println(filter1);
		String rfilter1 = filter1.replaceAll("\\D", "");
		// System.out.println(rfilter1);
		if (filter.equals(rfilter1)) {

			System.out.println("All applied filters are verified");
		} else {

			System.out.println("Not verified");
		}

		Thread.sleep(2000);

		WebElement quick = driver.findElement(By.xpath("(//p[@class='product-title'])[1]"));

		Actions act = new Actions(driver);
		act.moveToElement(quick).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		String price = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("Product price & Discount Percentage: " + price);
		// String off = driver.findElement(By.xpath("//span[@class='percent-desc
		// ']")).getText();
		// System.out.println("Discount Percentage: " +off);

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/shoe.png");
		FileUtils.copyFile(source, destination);

		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();

		// Thread.sleep(3000);
		driver.close();
	}

}
