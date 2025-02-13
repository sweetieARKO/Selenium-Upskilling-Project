package Week10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {

    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://www.automationpractice.pl/index.php");
    }
    @Test
    public void MouseHover(){
        WebElement  Woman= driver.findElement(By.linkText("Women"));
        WebElement mac = driver.findElement(By.xpath("//a[.='Evening Dresses']/ancestor::ul"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Woman).moveToElement(mac).click().build().perform();
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}

