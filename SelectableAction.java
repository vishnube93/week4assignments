package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableAction {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[3]"));
		WebElement item4 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[4]"));
		WebElement item5 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[5]"));
		WebElement item6 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[6]"));
		WebElement item7 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[7]"));
		
		Actions builder=new Actions(driver);
		
	    builder.clickAndHold(item1).moveToElement(item5).release().perform();
		
	}
}
