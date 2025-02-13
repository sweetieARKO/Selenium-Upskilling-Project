package Week10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tooltip {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtestinginsider.com/");
    }
    @Test
    public void test(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gsc-input']"));
        String tootipText = searchBox.getAttribute("title");
        System.out.println("Tooltip text is : " +tootipText);

    }
}
