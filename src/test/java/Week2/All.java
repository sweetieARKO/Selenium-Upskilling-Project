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
        driver.findElement(firstNameLocator).sendKeys("abi");
        // Validate the input is entered
        String enteredValue = driver.findElement(firstNameLocator).getAttribute("value");
        Assert.assertEquals(enteredValue, "abi", "First Name value is not entered correctly.");
    }

    @Test(dependsOnMethods = {"ByName"})

    public void cssSelector() {
        driver.findElement(By.cssSelector("#LastName")).sendKeys("ark");
    }

    @Test(dependsOnMethods = {"cssSelector"})
    public void relativeXpath() {
        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Select select = new Select(day);
        select.selectByVisibleText("1");
    }

    @Test(dependsOnMethods = {"relativeXpath"})
    public void StartWithxpath() {
        WebElement month = driver.findElement(By.xpath("//select[starts-with(@name, 'DateOfBirthMonth')]"));
        Select select = new Select(month);
        select.selectByVisibleText("June");
    }

    @Test(dependsOnMethods = {"StartWithxpath"})
    public void XpathByPositiion() {
        WebElement year = driver.findElement(By.xpath("//select[position()=3]"));
        Select select = new Select(year);
        select.selectByVisibleText("1999");
    }

    @Test(dependsOnMethods = {"XpathByPositiion"})
    public void StartWithXpath2() {
        driver.findElement(By.xpath("//input[starts-with(@id, 'Email')]")).sendKeys("abigail.arko027@gmail.com");
    }
    @Test(dependsOnMethods = {"StartWithXpath2"})
    public void contains(){
        driver.findElement(By.xpath("//input[contains(@id,'Company')] ")).sendKeys("Amalitech Company Limited");
    }
@Test(dependsOnMethods = {"contains"})
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
        driver.findElement(By.xpath("//input[@id='ConfirmPassword'][self::input]")).click();    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
