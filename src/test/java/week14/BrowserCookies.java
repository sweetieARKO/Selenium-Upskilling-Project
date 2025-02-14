package week14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCookies {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com//");
    }
    @Test
    public void addCookies(){
        Cookie cookie = new Cookie("Sweetie", "800");
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies());
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
