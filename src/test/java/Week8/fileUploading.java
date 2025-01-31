package Week8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fileUploading {
        WebDriver driver;
        @BeforeTest
        public void before(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://practice-automation.com/");
        }
        @Test
    public void uploading(){
            FileUploadSetUp uploading = new FileUploadSetUp(driver);
            uploading.setFileUploadIcon();
            uploading.uploading();
        }
        @AfterTest
    public void afterTest(){
            driver.quit();
        }

}
