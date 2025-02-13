package Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class All {
    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void ParentAndChild() {
        // Directly locate and click on the Register link
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        String currentUrl = driver.getCurrentUrl();
        String expected = "register";

        Assert.assertTrue(currentUrl.contains(expected),
                "Expected URL to contain '" + expected + "', but found: " + currentUrl);
    }

    @Test(dependsOnMethods = {"ParentAndChild"})
    public void ID() {
        // Select the male gender radio button
        driver.findElement(By.id("gender-male")).click();
        // Assert the radio button is selected
        Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected(),
                "Male gender radio button is not selected.");
    }

    @Test(dependsOnMethods = {"ID"})
    public void ByName() {
        // Locate and input into the First Name field
        By firstNameLocator = By.name("FirstName");
        driver.findElement(firstNameLocator).sendKeys("Abigail");
        // Validate the input is entered
        String enteredValue = driver.findElement(firstNameLocator).getAttribute("value");
        Assert.assertEquals(enteredValue, "Abigail", "First Name value is not entered correctly.");
    }

    @Test(dependsOnMethods = {"ByName"})

    public void cssSelector() {
        driver.findElement(By.cssSelector("#LastName")).sendKeys("Arko");
    }

    @Test(dependsOnMethods = {"cssSelector"})
    public void relativeXpath() {
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("arko.abigail@amalitech.com");
    }

    @Test(dependsOnMethods = {"relativeXpath"})
    public void StartWithxpath() {
        WebElement company = driver.findElement(By.xpath("//input[starts-with(@id, 'Company')]"));
        company.sendKeys("Amalitech comapany");
    }

@Test(dependsOnMethods = {"StartWithxpath"})
public void parent(){
        WebElement parent = driver.findElement(By.xpath("//input[@name='Password']/parent::div"));
        WebElement child = parent.findElement(By.xpath("//input[@name='Password']"));
        child.sendKeys("sweetie");
}
@Test(dependsOnMethods = {"parent"})
public void self(){
        driver.findElement(By.xpath("//input[@id='ConfirmPassword'][self::input]")).sendKeys("sweetie");
}
    @Test(dependsOnMethods = {"self"})
    public void ClassName() {
        driver.findElement(By.xpath("//button[@id='register-button']/ancestor::div[.='Register']")).click();    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
     //       driver.quit();
        }
    }
}
