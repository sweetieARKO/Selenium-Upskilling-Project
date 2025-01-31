package Week9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class usingKeyBoardShortcut {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://extendsclass.com/text-compare.html");
    }

    @Test
    public void test () throws InterruptedException {
        WebElement sourcetextArea = driver.findElement(By.xpath("//div[@id='dropZone']//div[5]/pre/span"));
        Actions actions = new Actions(driver);
        Thread.sleep(200);
        actions.keyDown(sourcetextArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        WebElement destinationTextArea = driver.findElement(By.xpath("//*[@id='dropZone2']//div[5]/div[3]/pre/span"));
        Thread.sleep(200);
        actions.keyDown(destinationTextArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
    }

}
