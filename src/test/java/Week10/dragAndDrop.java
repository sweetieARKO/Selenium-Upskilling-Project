package Week10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dragAndDrop {

        WebDriver driver;

        @BeforeTest
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        }

        @Test
        public void MoveTheCursorAndClickAndHold() throws InterruptedException {
            WebElement boxA = driver.findElement(By.xpath("//li[@name='A']"));
            WebElement boxD = driver.findElement(By.xpath("//li[@name='D']"));

            Actions actions = new Actions(driver);
            actions.clickAndHold(boxA)
                    .moveToElement(boxD)
                    .release()
                    .perform();
            Thread.sleep(2000);
        }

        @Test
        public void RightClick() {
            WebElement boxC = driver.findElement(By.xpath("//li[@name='C']"));

            Actions actions = new Actions(driver);
            actions.contextClick(boxC).perform();
        }
        @Test
        public  void  DobuleClick(){
            WebElement BoxE = driver.findElement(By.xpath("//li[@name='E']"));
            Actions actions = new Actions(driver);
            actions.doubleClick(BoxE);
        }
        @AfterTest
        public void teardown() {
            if (driver != null) {
                //  driver.quit();
            }
        }
    }

