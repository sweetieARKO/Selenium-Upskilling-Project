package week4.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import week4.items.signup;

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
        signup register = new signup(driver);
        register.EnterEmail();
        register.EnterPassword();
        register.ClickOnButton();
    }
    @Test(priority = 2, dependsOnMethods = {"login"})
            public void SelectFirstItem() {
     signup register = new signup(driver);
        register.ChooseFirstItem();
    }
    @Test(priority = 3, dependsOnMethods = {"SelectFirstItem"})
            public void SelectSecondItem() {
        signup register = new signup(driver);
        register.ChooseSecondItem();
    }
    @Test(priority = 4, dependsOnMethods = {"SelectSecondItem"})
            public void SelectThirdItem() {
        signup register = new signup(driver);
        register.ChooseThirdItem();
    }

    @Test(priority = 5, dependsOnMethods = {"SelectThirdItem"})
    public void SelectFouthItem() {
        signup register = new signup(driver);
        register.ChooseFourthItem();
    }
    @Test(priority = 6, dependsOnMethods = {"SelectFouthItem"})
    public void SelectRemoveItem() {
        signup register = new signup(driver);
        register.RemoveItem();
    }

@AfterTest
    public void after(){
        driver.quit();
}
}
