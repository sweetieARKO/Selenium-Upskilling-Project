package Week10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop2 {
    WebDriver driver;
    @BeforeTest
    public void Before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium08.blogspot.com/2020/01/drag-me.html?m=1");
    }
    @Test
    public void Test(){
        WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement element2 = driver.findElement(By.xpath("//body/div[@class=\"all-container\"]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element1, element2);
        actions.build().perform();
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}

