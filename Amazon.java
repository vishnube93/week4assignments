package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//div[text()='oneplus 9 pro']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String text = driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[2]"))
				.getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("//span[@class=\"a-size-base s-underline-text\"]")).getText();
		System.out.println(text2);
		WebElement stars = driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-popover\"][1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(stars).click().perform();
		String Percentage = driver.findElement(By.xpath("(//span[@class=\"a-size-base\"])[2]")).getText();
		System.out.println("Percentage of 5 star ratings:" + Percentage);
		driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/phone.png");
		FileUtils.copyFile(source, destination);
		driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
	}
}
