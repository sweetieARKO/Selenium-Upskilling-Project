package Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MovePerform {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php?");
    }

    @Test
    public void Test() {
        WebElement dresses = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dresses).perform();
        WebElement element = driver.findElement(By.xpath("(//a[@title='Evening Dresses'][normalize-space()='Evening Dresses'])[2]"));
        actions.moveToElement(element).click().build().perform();
        String  CurrentLink = driver.getCurrentUrl();
        CurrentLink.contains("Evening Dresses");
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
