package Week9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class handlingKeyBoardACTion {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.get("https://omayo.blogspot.com/");
    }
                    @Test
                   public void keyUpAndKeyDown(){
        WebElement companyDivLink = driver.findElement(By.linkText("compendiumdev"));
                   Actions actions = new Actions(driver);
                       actions.moveToElement(companyDivLink).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
    }
    @AfterTest
    public void endDriver(){
        driver.quit();
    }
}
