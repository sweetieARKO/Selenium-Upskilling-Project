package Week9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyUp {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }
@Test
    public void test(){
    WebElement searchElement = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
    Actions actions = new Actions(driver);
    actions.keyDown(Keys.SHIFT)
            .sendKeys(searchElement, "Software Testing")
            .keyUp(Keys.SHIFT)
            .perform();

    // Wait for the search button to be clickable
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")));

    // Click the search button
    searchButton.click();
}
}

