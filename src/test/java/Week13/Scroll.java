package Week13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scroll {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com");
    }

    @Test
    public void scroll() throws InterruptedException {
        Thread.sleep(300); // Not recommended, but kept for initial load

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Find the element first
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Iframes']")));

        // Scroll to the element
        js.executeScript("arguments[0].scrollIntoView(true);", iframes);

        // Wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(iframes));

        try {
            // Try clicking normally
            iframes.click();
        } catch (ElementClickInterceptedException e) {
            // Use JavaScript click as a fallback
            js.executeScript("arguments[0].click();", iframes);
        }
    }

    @Test
    public void scrollTwo() throws InterruptedException {
        Thread.sleep(200);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Find the element first
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='iframe-2']")));

        // Scroll to the element
        js.executeScript("arguments[0].scrollIntoView(true);", iframes);
        driver.switchTo().frame(iframes);
            System.out.println("frame is switched");
    WebElement image=driver.findElement(By.xpath("//body/div[@class='container-fluid td-default td-outer']/main[@role='main']/div[3]"));

        js.executeScript("arguments[0].scrollIntoView(true);", image);
        image.isDisplayed();


    }
}