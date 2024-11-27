package Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class HandlingCheckbox {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void register() {
        driver.findElement(By.xpath("//input[contains(@ng-model,'FirstName')]")).sendKeys("Emmanuelle");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Mensa");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("33/5");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("DomAbigail026@gmail.com");
        driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("05988029");

        // Select gender and hobbies
        driver.findElement(By.xpath("//input[@value='FeMale']")).click();
        driver.findElement(By.xpath("//input[@value='Movies']")).click();

        // Scroll and click the language dropdown
        WebElement languageDropdown = driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", languageDropdown);
        languageDropdown.click();

        // Handle iframe ad if present
        try {
            WebElement iframeAd = driver.findElement(By.id("aswift_2"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", iframeAd);
        } catch (NoSuchElementException e) {
            System.out.println("No iframe ad detected");
        }

        // Click the language
        WebElement czechLanguage = driver.findElement(By.xpath("//a[normalize-space()='Czech']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", czechLanguage);

        // Select an option from the "Skills" dropdown
        WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select select = new Select(skills);
        select.selectByVisibleText("Java"); // Change to the skill you want to select
        WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
        Select countries = new Select(country);
        countries.selectByIndex(0);
        WebElement Country = driver.findElement(By.xpath("//span[@role='combobox']"));
        Country.click();
        WebElement chooseCountries = driver.findElement(By.xpath("//li[contains(text(),'Hong Kong')]"));
        chooseCountries.click();
        WebElement year =  driver.findElement(By.xpath("//select[@id='yearbox']"));
        Select years = new Select(year);
        years.selectByValue("1949");
    }

    @AfterTest
    public void afterTest() {
        // Uncomment this line to close the browser after the test
        // driver.quit();
    }
}
