package week14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class getCookies {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }
    @Test
    public void test1(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie:cookies){
            System.out.println("Cookie Name: "+ cookie.getName());
            System.out.println("Cookie Value: "+cookie.getValue());
            System.out.println("Cookie Domain: "+cookie.getDomain());
            System.out.println("Cookie expiry Date: "+cookie.getExpiry());
        }
    }
}
