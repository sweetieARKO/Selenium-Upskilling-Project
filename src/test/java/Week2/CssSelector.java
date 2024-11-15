package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelector {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void Class() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inputtext._55r1._6luy")))
                .sendKeys("7989903719");

        // Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inputtext._55r1._6luy._9npi")))
                .sendKeys("123456785");
        driver.findElement(By.cssSelector("._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy")).click();

    }
}
