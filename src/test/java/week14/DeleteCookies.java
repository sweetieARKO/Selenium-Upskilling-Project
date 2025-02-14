package week14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteCookies {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // Page load
        driver.get("https://practice-automation.com/");
    }

    @Test
    public void deleteCookies() {
        // Retrieve the cookie
        Cookie cookie = driver.manage().getCookieNamed("Sweetie");

        if (cookie != null) {
            System.out.println("Cookie found: " + cookie);
            driver.manage().deleteCookie(cookie);
            System.out.println("Cookie deleted successfully!");
        } else {
            System.out.println("Cookie 'Sweetie' not found. Nothing to delete.");
        }

        // Alternative: Delete all cookies
        // driver.manage().deleteAllCookies();
    }
}
