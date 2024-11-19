package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingtheParentXpath {
    WebDriver driver;
    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void parentXpath(){
        WebElement parentUserName = driver.findElement(By.xpath("//input[@id='user-name']/parent::div"));
        WebElement child = parentUserName.findElement(By.xpath("//input[@id='user-name']"));
        child.sendKeys("standard_user");
        WebElement parentPassword= driver.findElement(By.xpath("//input[@id='password']/parent::div"));
        WebElement childPassword = parentPassword.findElement(By.xpath("//input[@id='password']"));
        childPassword.sendKeys("secret_sauce");



    }
@AfterTest
    public void close(){
        driver.quit();
}
}
