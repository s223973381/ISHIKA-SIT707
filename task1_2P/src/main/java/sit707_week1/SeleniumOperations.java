package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

/**
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void open_chrome_and_close() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		driver.close();
	}

	public static void open_chrome_maximize_close() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		driver.manage().window().maximize();

		sleep(5);

		driver.close();
	}

	public static void load_web_page_close() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		driver.get("https://selenium.dev");

		sleep(5);

		driver.close();
	}

	/*
	 * CASE 4 (Your Task)
	 */
	public static void open_chrome_loadpage_resize_close() {

		// A. Student details
		System.out.println("Hello from s223973381, Ishika Mandal");

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		// B. Open Google
		driver.get("https://www.google.com");

		// C. Resize window to 640x480
		driver.manage().window().setSize(new Dimension(640, 480));
		sleep(5);

		// D. Resize window to 1280x960
		driver.manage().window().setSize(new Dimension(1280, 960));
		sleep(5);

		sleep(5);

		driver.close();
	}
}