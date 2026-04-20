package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///C:/Users/ishik/eclipse-workspace/webservice1/pages/login.html");
        sleep(2);

        // Username
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("Ishika");

        // Password
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("Ishika_M");

        // DOB (FIXED using JS)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value='2001-10-03';");

        // Submit
        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        System.out.println("TITLE: " + driver.getTitle());
        assertEquals("success", driver.getTitle());

        driver.quit();
    }

    @Test
    public void testLoginWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///C:/Users/ishik/eclipse-workspace/webservice1/pages/login.html");
        sleep(2);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("Ishika");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("WrongPass");

        // DOB FIX
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value='2001-10-03';");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        System.out.println("TITLE: " + driver.getTitle());
        assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    @Test
    public void testLoginWrongDob() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///C:/Users/ishik/eclipse-workspace/webservice1/pages/login.html");
        sleep(2);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("Ishika");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("Ishika_M");

        // WRONG DOB
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value='2000-01-01';");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        System.out.println("TITLE: " + driver.getTitle());
        assertEquals("fail", driver.getTitle());

        driver.quit();
    }

    @Test
    public void testLoginWrongUsername() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///C:/Users/ishik/eclipse-workspace/webservice1/pages/login.html");
        sleep(2);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("WrongUser");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("Ishika_M");

        // DOB FIX
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value='2001-10-03';");

        driver.findElement(By.cssSelector("[type=submit]")).click();
        sleep(2);

        System.out.println("TITLE: " + driver.getTitle());
        assertEquals("fail", driver.getTitle());

        driver.quit();
    }
}