package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PartialLinkTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
    }

    @Test
    public void testPartialLink() {
        // Click on the link containing "Sign"
        driver.findElement(By.partialLinkText("Sign")).click();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Expected substring in the URL
        String expected = "my-account";

        // Assert that the URL contains the expected substring
        Assert.assertTrue(currentUrl.contains(expected),
                "The current URL does not contain the expected substring. Current URL: " + currentUrl);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
