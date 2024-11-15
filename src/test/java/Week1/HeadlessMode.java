package Week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessMode {
    WebDriver driver;

    @BeforeTest
    public void headless() {
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true); // Corrected method name
        options.addArguments("--headless"); // Add additional headless argument for compatibility

        // Create the ChromeDriver instance with options
        driver = new ChromeDriver(options);

        // Open the webpage in headless mode
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void test() {
        String title = driver.getTitle();

        System.out.println(title);
    }


    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}