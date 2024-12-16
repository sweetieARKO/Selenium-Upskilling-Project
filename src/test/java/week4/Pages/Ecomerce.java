package week4.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week4.items.ecomerce;


public class Ecomerce {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }
    @Test(priority = 1)
    public void login() {
        ecomerce register = new ecomerce(driver);
        register.EnterEmail();
        register.EnterPassword();
        register.ClickOnButton();
    }
    @Test(priority = 2, dependsOnMethods = {"login"})
            public void SelectFirstItem() {
     ecomerce register = new ecomerce(driver);
        register.ChooseFirstItem();
    }
    @Test(priority = 3, dependsOnMethods = {"SelectFirstItem"})
            public void SelectSecondItem() {
        ecomerce register = new ecomerce(driver);
        register.ChooseSecondItem();
    }
    @Test(priority = 4, dependsOnMethods = {"SelectSecondItem"})
            public void SelectThirdItem() {
        ecomerce register = new ecomerce(driver);
        register.ChooseThirdItem();
    }

    @Test(priority = 5, dependsOnMethods = {"SelectThirdItem"})
    public void SelectFouthItem() {
        ecomerce register = new ecomerce(driver);
        register.ChooseFourthItem();
    }
    @Test(priority = 6, dependsOnMethods = {"SelectFouthItem"})
    public void SelectRemoveItem() {
        ecomerce register = new ecomerce(driver);
        register.RemoveItem();
    }

@AfterTest
    public void after(){
        driver.quit();
}
}
