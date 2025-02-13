package Week6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopupTest {
    WebDriver driver;

    By Popup = By.xpath("//a[normalize-space()='Popups']");
    By alertPopup = By.xpath("//button[normalize-space()='Alert Popup']");
    By confirmPopup = By.xpath("//button[@id='confirm']");
    By cofirmanswer = By.xpath("//p[@id='confirmResult']");
    By Prompt = By.xpath("//button[@id='prompt']");
    By promptAnswer = By.xpath("//p[@id='promptResult']");
    // Method to click on "Popups" l

    @BeforeTest
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }
    @Test
        public void setPopup() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            WebElement pop = wait.until(ExpectedConditions.visibilityOfElementLocated(Popup));
            pop.click();
        }

        @Test(dependsOnMethods = {"setPopup"})
        public void setAlertPopup() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement alert = wait.until(ExpectedConditions.elementToBeClickable(alertPopup));
            alert.click();
            Alert switchalert = driver.switchTo().alert();
            String mainMesaage=switchalert.getText();
            String ExpectedMessage = "Hi there, pal!";
            Assert.assertEquals(mainMesaage, ExpectedMessage);
            switchalert.accept();

        }
        @Test(dependsOnMethods = {"setAlertPopup"})
        public void ConfirmPopUp(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement alerts = wait.until(ExpectedConditions.elementToBeClickable(confirmPopup));
            alerts.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();


            String answer = driver.findElement(cofirmanswer).getText();
            String Expected = "OK it is!";
            Assert.assertEquals(answer, Expected);
        }
        @Test(dependsOnMethods = {"ConfirmPopUp"})
        public void promptPopUp(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement alert = wait.until(ExpectedConditions.elementToBeClickable(Prompt));
            alert.click();
            Alert alert1 = driver.switchTo().alert();
            String keysTosend = "Abigail";
            alert1.sendKeys(keysTosend);
            alert1.accept();
            WebElement answeer = driver.findElement(promptAnswer);
            String actualText = answeer.getText();
            String ExpectedText = "Nice to meet you, "+ keysTosend+"!";
            Assert.assertEquals(actualText, ExpectedText);
        }
        @AfterTest
    public void afterTest(){
        driver.quit();
        }
    }
