package Week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OverViewOfSelenuiam {
    WebDriver driver;
@BeforeTest
    public void setDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com");
}
@Test
    public void getTitleOFWebPage(){
 String Tittle =   driver.getTitle();
 String ExpectedTittle = "Swag Labs";
    Assert.assertEquals(Tittle, ExpectedTittle);
    System.out.println(Tittle);
}
@Test
public void getUrlofThePage(){
String ActualUrl =    driver.getCurrentUrl();
String ExpectedUrl = "https://www.saucedemo.com/";
Assert.assertEquals(ActualUrl, ExpectedUrl);
}
    @AfterTest
    public void afterTest(){
    if (driver !=  null){
        driver.quit();
    }
}

}
