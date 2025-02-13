package week12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }
     @Test
    public void Explicit(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
         WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
         wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='title']"))));
         driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

     }
     @AfterTest
    public void after(){
        driver.quit();
     }
}
