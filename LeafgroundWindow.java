package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println("Title of main page: " + driver.getTitle());
		driver.findElement(By.xpath("//button[@id='home']")).click();

		Set<String> home = driver.getWindowHandles();
		List<String> homepage = new ArrayList<String>(home);
		driver.switchTo().window(homepage.get(1));
		System.out.println("Title of home page: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(homepage.get(0));

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();

		Set<String> multiple = driver.getWindowHandles();
		List<String> multiplewin = new ArrayList<String>(multiple);
		System.out.println("Number of opened windows: " + multiple.size());
		System.out.println("Title of first window: " + driver.getTitle());

		driver.switchTo().window(multiplewin.get(1));
		System.out.println("Title of second window: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(multiplewin.get(2));
		System.out.println("Title of third window: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(homepage.get(0));

		driver.findElement(By.xpath("(//button[@id='color'])[1]")).click();

		Set<String> close = driver.getWindowHandles();
		List<String> closewin = new ArrayList<String>(close);
		driver.switchTo().window(closewin.get(1));
		driver.close();

		driver.switchTo().window(closewin.get(2));
		driver.close();

		driver.switchTo().window(homepage.get(0));

		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();

		driver.quit();

	}
}
