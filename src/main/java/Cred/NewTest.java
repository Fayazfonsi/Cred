package Cred;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;

	@Test(priority = 0)
	public void f() throws InterruptedException {

		String[] fn = new String[] { "ponu swami", "chinna swami", "kanu swami" };
		String[] ln = new String[] { "Pswami", "cswami", "kswami" };
		String[] email = new String[] { "p@gmail.com", "c@gmail.com", "k@gmail.com" };
		String[] age = new String[] { "10", "20", "30" };
		String[] salary = new String[] { "100000", "200000", "300000" };
		String[] department = new String[] { "ECE", "CSE", "IT" };

		int j =0;
		for (int i = 0; i <=2; i++) {

			driver.findElement(By.cssSelector("#addNewRecordButton")).click();

			driver.findElement(By.cssSelector("#firstName")).sendKeys(fn[j]);
			driver.findElement(By.cssSelector("#lastName")).sendKeys(ln[j]);
			driver.findElement(By.cssSelector("#userEmail")).sendKeys(email[j]);
			driver.findElement(By.cssSelector("#age")).sendKeys(age[j]);
			driver.findElement(By.cssSelector("#salary")).sendKeys(salary[j]);
			driver.findElement(By.cssSelector("#department")).sendKeys(department[j]);
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#submit")).click();
			j++;
			

		}
		
	}

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\chrome driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
