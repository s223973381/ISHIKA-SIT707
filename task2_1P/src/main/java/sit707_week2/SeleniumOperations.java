package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		// Replace this with your actual chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		driver.get(url);
		driver.manage().window().maximize();

		try {
			// First name
			WebElement element = driver.findElement(By.id("firstname"));
			element.sendKeys("Ishika");

			// Other fields
			driver.findElement(By.id("lastname")).sendKeys("Mandal");
			driver.findElement(By.id("email")).sendKeys("ishika.test123@example.com");
			driver.findElement(By.id("password")).sendKeys("12345");
			driver.findElement(By.id("confirmPassword")).sendKeys("12345");

			// If phone field exists
			// driver.findElement(By.id("phoneNumber")).sendKeys("0412345678");

			// Click Create account
			WebElement createButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
			createButton.click();

			sleep(3);

			// Screenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File("officeworks_registration_screenshot.png");
			FileUtils.copyFile(srcFile, destFile);

			System.out.println("Screenshot saved successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Locator issue. Inspect the page and update the locators.");
			e.printStackTrace();
		}

		sleep(2);
		driver.quit();
	}
	
     public static void parabank_registration_page(String url) {

	WebDriver driver = new ChromeDriver();

	driver.get(url);
	driver.manage().window().maximize();

	sleep(2);

	try {
		// Personal Info
		driver.findElement(By.name("customer.firstName")).sendKeys("Ishika");
		driver.findElement(By.name("customer.lastName")).sendKeys("Mandal");
		driver.findElement(By.name("customer.address.street")).sendKeys("123 Street");
		driver.findElement(By.name("customer.address.city")).sendKeys("Melbourne");
		driver.findElement(By.name("customer.address.state")).sendKeys("VIC");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys("3000");
		driver.findElement(By.name("customer.phoneNumber")).sendKeys("0412345678");
		driver.findElement(By.name("customer.ssn")).sendKeys("12345");

		// Account Info
		driver.findElement(By.name("customer.username"))
			  .sendKeys("ishika" + System.currentTimeMillis());

		// Intentionally weak password (for assignment safety)
		driver.findElement(By.name("customer.password")).sendKeys("12345");
		driver.findElement(By.name("repeatedPassword")).sendKeys("12345");

		// Click Register
		driver.findElement(By.xpath("//input[@value='Register']")).click();

		sleep(3);

		// Screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("parabank_registration_screenshot.png");
		FileUtils.copyFile(srcFile, destFile);

		System.out.println("Parabank screenshot saved.");

	} catch (Exception e) {
		e.printStackTrace();
	}

	sleep(2);
	driver.quit();
    }
	public static void main(String[] args) {
		officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
		parabank_registration_page("https://parabank.parasoft.com/parabank/register.htm");
	}
}