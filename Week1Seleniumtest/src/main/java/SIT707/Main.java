package SIT707;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());

        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}