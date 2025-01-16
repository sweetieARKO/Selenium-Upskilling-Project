package Week5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;
    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:// tomation.com");
    }
    @Test
    public void clickingOnThebrowserLink(){
iframeslist frame = new iframeslist(driver);
frame.clickOnIframes();
frame.switchIframe();
    }
}
