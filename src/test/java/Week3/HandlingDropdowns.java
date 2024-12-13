package Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingDropdowns {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");


    }
    @Test
    public void dropdown(){
WebElement Electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        Electronics.click();

        WebElement camera = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Camera & photo']"));
        camera.click();

        // Add a cookie for CAPTCHA (if applicable)
        Cookie captchaCookie = new Cookie("captcha", "validCaptchaValue");
        driver.manage().addCookie(captchaCookie);
        driver.navigate().refresh();

    }

}
