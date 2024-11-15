package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XpathStartWith {
    WebDriver driver;
    @BeforeTest
    public void before(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php?");
    }
    @Test
    public void StartWithXpath(){
    driver.findElement(By.xpath("//input[starts-with(@id, 'search_query_top')]")).sendKeys("T-Shirts");
    driver.findElement(By.xpath("//button[starts-with(@name, 'submit_search')]")).click();
    }
}
