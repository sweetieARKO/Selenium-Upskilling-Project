package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class linkTest {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "http://www.automationpractice.pl/index.php?");

    }
@Test
public void TestilinkText(){
WebElement linkTest =driver.findElement(By.linkText("Sign in"));
assertTrue("Link is display", linkTest.isDisplayed());
linkTest.click();
String curruntUrl =driver.getCurrentUrl();
assertTrue(curruntUrl.contains("my-account"));
}
}
