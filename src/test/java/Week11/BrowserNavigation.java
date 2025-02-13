package Week11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserNavigation {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        String Title = driver.getTitle();
        Assert.assertEquals(Title, "Practice Page");
        System.out.println(driver.getTitle());
    }
    @Test
    public void NavigateTo(){
        driver.navigate().to("https://www.saucedemo.com/");
        String Title = driver.getTitle();
        Assert.assertEquals(Title, "Swag Labs");
        System.out.println(driver.getTitle());


    }
    @Test(dependsOnMethods = {"NavigateTo"})
    public void NavigateBack(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().back();
        wait.until(ExpectedConditions.titleIs("Practice Page"));
        String Title = driver.getTitle();
        Assert.assertEquals(Title, "Practice Page");
        System.out.println(driver.getTitle());

    }
    @Test(dependsOnMethods = {"NavigateBack"})
    public void refresh(){
        driver.navigate().refresh();
    }
    @AfterTest
    public void after(){
    driver.quit();
    }
}
