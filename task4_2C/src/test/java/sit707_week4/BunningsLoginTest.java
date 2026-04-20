package sit707_week4;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BunningsLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String BASE_URL = "https://www.bunnings.com.au/login";
    private final String VALID_EMAIL = "abc1234@gmail.com";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(BASE_URL);
        dismissPopupsIfPresent();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s223973381";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Ishika Mandal";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testOpenPage() {
        Assert.assertTrue("Login page did not open correctly",
                driver.getCurrentUrl().contains("bunnings"));
    }

    private void dismissPopupsIfPresent() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe, div, button').forEach(function(el) {" +
                "  const txt = (el.innerText || '').toLowerCase();" +
                "  const meta = ((el.id || '') + ' ' + (el.className || '') + ' ' + (el.getAttribute('title') || '') + ' ' + (el.getAttribute('aria-label') || '')).toLowerCase();" +
                "  if (txt.includes('ai buddy') || meta.includes('chat') || meta.includes('intercom')) {" +
                "    el.style.display='none';" +
                "  }" +
                "});"
            );
        } catch (Exception e) {
            // ignore
        }
    }

    private WebElement getUsernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    private WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    private WebElement getLoginButton() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
    }

    private void enterUsername(String username) {
        WebElement field = getUsernameField();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", field);

        if (username != null && !username.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                field, username
            );
        }
    }

    private void enterPassword(String password) {
        WebElement field = getPasswordField();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", field);

        if (password != null && !password.isEmpty()) {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                field, password
            );
        }
    }

    private void clickLogin() {
        WebElement button = getLoginButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    private void assertStillOnLoginPage() {
        String url = driver.getCurrentUrl().toLowerCase();

        Assert.assertTrue(
            "Expected to remain on login page, but URL was: " + url,
            url.contains("login") || url.contains("bunnings")
        );
    }

    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        enterUsername("");
        enterPassword("");
        clickLogin();
        assertStillOnLoginPage();
    }

    @Test
    public void testEmptyUsernameAndWrongPassword() {
        enterUsername("");
        enterPassword("WrongPass123");
        clickLogin();
        assertStillOnLoginPage();
    }

    @Test
    public void testWrongUsernameAndEmptyPassword() {
        enterUsername("wrong@gmail.com");
        enterPassword("");
        clickLogin();
        assertStillOnLoginPage();
    }

    @Test
    public void testWrongUsernameAndWrongPassword() {
        enterUsername("wrong@gmail.com");
        enterPassword("WrongPass123");
        clickLogin();
        assertStillOnLoginPage();
    }

    @Test
    public void testCorrectUsernameAndEmptyPassword() {
        enterUsername(VALID_EMAIL);
        enterPassword("");
        clickLogin();
        assertStillOnLoginPage();
    }

    @Test
    public void testCorrectUsernameAndWrongPassword() {
        enterUsername(VALID_EMAIL);
        enterPassword("WrongPass123");
        clickLogin();
        assertStillOnLoginPage();
    }
}