package Week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    @Test
    public void LoginWithCorrectCredentials(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        WebElement getText = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]"));
        String actualText = getText.getText();
        String ExpectedText = "Congratulations student. You successfully logged in!";
         Assert.assertEquals(actualText, ExpectedText);
    }
    @Test
    public void  LoginWithIncorrectUsername(){

    }
}
