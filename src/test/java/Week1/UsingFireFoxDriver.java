package Week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingFireFoxDriver {
    WebDriver driver;
    @BeforeTest
    public void setDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }
    @Test
    public void GetTitle(){
        driver.getTitle();
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}
