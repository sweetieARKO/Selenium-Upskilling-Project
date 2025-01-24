package Week8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class fileDownload {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }
    @Test
    public void download(){
fileDownloadsetUp download = new fileDownloadsetUp(driver);
download.clickOnDownloadButton();
download.clickOnDownloadFirst();
download.clickDownloadSecond();
    }
}
