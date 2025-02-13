package Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectByIndex {
    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test(dependsOnMethods = {"login"})
    public void sort() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Retry logic in case of StaleElementReferenceException
        int attempts = 0;
        boolean isSorted = false;

        while (attempts < 3) {
            try {
                // Wait for the dropdown to be visible and get the reference each time
                WebElement sort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='product_sort_container']")));

                // Select the dropdown option
                Select select = new Select(sort);
                select.selectByIndex(3);

                // Verify the selected option
                String selectedOption = select.getFirstSelectedOption().getText();
                Assert.assertEquals(selectedOption, "Price (high to low)");

                // Exit the loop if successful
                isSorted = true;
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Encountered StaleElementReferenceException. Retrying... Attempt: " + (attempts + 1));
                attempts++;
            }
        }

        Assert.assertTrue(isSorted, "Failed to select 'Name High to Low)' in the sort dropdown after multiple attempts.");
    }


    @AfterTest
    public void afterTest() {
//        driver.quit();
    }
}


