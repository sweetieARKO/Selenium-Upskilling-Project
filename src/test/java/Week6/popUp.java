package Week6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class popUp{
        WebDriver driver;

        @BeforeTest
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://omayo.blogspot.com/");
        }
        @Test
        public void handleAlert() {
            driver.findElement(By.xpath("//input[@id='alert1']")).click();
            System.out.println("Alert text: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }

        @Test(dependsOnMethods = {"handleAlert"})
        public void handlePrompt() {
            driver.findElement(By.xpath("//input[@id='prompt']")).click();
            driver.switchTo().alert().sendKeys("abigail");
            driver.switchTo().alert().accept(); // Accept the prompt after entering text
        }

        @AfterTest
        public void tearDown() {
            if (driver != null) {
            driver.quit();
            }
        }
    }

