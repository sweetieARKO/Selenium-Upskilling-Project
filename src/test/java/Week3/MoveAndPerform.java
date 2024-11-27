package Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MoveAndPerform {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testlio.com/");
    }

    @Test
    public void test() {
        // Wait for the "Solutions" element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement solutions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='solutions']")));
        solutions.click();

        // Hover over "Solutions" and click "Coverage"
        WebElement coverage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://testlio.com/coverage/']//div[@class='nav__link-inner']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).perform();
        actions.moveToElement(coverage).click().build().perform();

        // Validate the navigation to the "Coverage" page
        String expectedUrl = "https://testlio.com/coverage/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to the Coverage page failed.");
    }

    @AfterTest
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
