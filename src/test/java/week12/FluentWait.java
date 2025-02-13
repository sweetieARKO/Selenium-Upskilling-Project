package week12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWait {
    WebDriver driver;


    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testOne() {
        // Proper Fluent Wait Implementation
        Wait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Max wait time
                .pollingEvery(Duration.ofSeconds(2)) // Poll every 2 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        WebElement Email = fluentWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@id='user-name']"))));
        Email.sendKeys("standard_user");
        WebElement password = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        password.sendKeys("secret_sauce");
        WebElement button = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']")));
        button.click();
    }
}