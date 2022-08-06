package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[1]")).click();

		Set<String> windows = driver.getWindowHandles();
		List<String> newwindow = new ArrayList<String>(windows);
		driver.switchTo().window(newwindow.get(1));

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();

		driver.switchTo().window(newwindow.get(0));
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		Set<String> windows1 = driver.getWindowHandles();
		List<String> newwindow1 = new ArrayList<String>(windows1);
		driver.switchTo().window(newwindow1.get(1));

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(newwindow1.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println("Title of the page: " + driver.getTitle());

	}
}
