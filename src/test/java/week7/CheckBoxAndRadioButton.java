package week7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxAndRadioButton {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ironspider.ca/forms/checkradio.htm");
    }

    @Test
    public void checkBox() {
        WebElement RED = driver.findElement(By.xpath("//input[@value='red']"));
        RED.click();
        RED.isSelected();
        WebElement BLUE = driver.findElement(By.xpath("//input[@value='blue']"));
        BLUE.click();
        BLUE.isSelected();
        WebElement Green = driver.findElement(By.xpath("//input[@value='green']"));
        Green.click();
        Green.isSelected();
    }

    @Test
    public void radiobutton() {
    WebElement internetExplorer = driver.findElement(By.xpath("//*[@id=\"Content\"]/div[1]/blockquote[2]/form/input[3]"));
internetExplorer.click();
internetExplorer.isSelected();
    }
    @AfterTest
    public void after(){
        driver.close();
    }
}